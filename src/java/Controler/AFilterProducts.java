package Controler;

import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class AFilterProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.clear();
            
//            String dept = req.getParameter("sdept").trim().toLowerCase();
            
            Criteria criteria = session.createCriteria(Product.class);
            
//            if (!dept.isEmpty() | !dept.equals("select department")) {
//                criteria.add(Restrictions.eq("department", dept));
//            }
            
            criteria.addOrder(Order.asc("id"));
            req.setAttribute("plist", criteria.list());
            req.getRequestDispatcher("temp_admin_product_row.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
