/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.Category;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class LoadCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String requestCode = req.getParameter("rc");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.clear();

            Criteria criteria = session.createCriteria(Category.class);
            criteria.add(Restrictions.eq("cstatus", "active"));
            List<Category> categories = criteria.list();

            if (requestCode.equals("101")) {
                req.setAttribute("c_list", categories);
                req.getRequestDispatcher("temp_category_dropdown.jsp").forward(req, resp);
            } else {
                PrintWriter writer = resp.getWriter();
                writer.write("<option>Select category</option>");
                for (Category category : categories) {
                    writer.write("<option>" + category.getCname() + "</option>");
                }

            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
