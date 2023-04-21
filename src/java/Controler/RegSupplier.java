package Controler;

import database.NewHibernateUtil;
import database.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RegSupplier extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            
            String name = req.getParameter("name").trim();
            String address = req.getParameter("address").trim();
            String city = req.getParameter("city").trim();
            String contact_no = req.getParameter("contact_no").trim();
            String email = req.getParameter("email").trim();

            String responseText = "";
            if (name.isEmpty()) {
                responseText = "Please enter supplier name";
            } else if (address.isEmpty()) {
                responseText = "Please enter supplier address";
            } else if (city.isEmpty()) {
                responseText = "Please enter supplier city";
            } else if (contact_no.isEmpty()) {
                responseText = "Please enter supplier contact no";
            } else {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session hibernateSession = sessionFactory.openSession();
                
                Supplier supplier = new Supplier();
                supplier.setSname(name);
                supplier.setSaddress1(address);
                supplier.setScity(city);
                supplier.setScontactNo(contact_no);
                supplier.setEmail(email);
                supplier.setSstatus("active");
                hibernateSession.save(supplier);
                
                Transaction tr = hibernateSession.beginTransaction();
                tr.commit();
                
                responseText = "1";
                hibernateSession.close();
            }
            
            writer.write(responseText);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
