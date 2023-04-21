/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.NewHibernateUtil;
import database.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class LoadSupplier extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();

            String startPage = req.getParameter("start");
            String name = req.getParameter("name").trim();
            String city = req.getParameter("city").trim();
            String contact_no = req.getParameter("contact_no").trim();
            String email = req.getParameter("email").trim();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Supplier.class);

            int count = criteria.list().size();
            int pages = count / 8;
            if (count % 8 != 0) {
                pages++;
            }

            criteria.setFirstResult(Integer.parseInt(startPage));
            criteria.setMaxResults(8);

            List<Supplier> suppliers = criteria.list();
            req.setAttribute("suppliers", suppliers);
            req.setAttribute("pages", pages);

            RequestDispatcher dispatcher = req.getRequestDispatcher("temp_supplier_row.jsp");
            dispatcher.include(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
