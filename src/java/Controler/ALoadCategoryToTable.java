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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class ALoadCategoryToTable extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String category_name = req.getParameter("cat_name").trim();
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            Criteria criteria = session.createCriteria(Category.class);
            
            if(!category_name.isEmpty()){
            criteria.add(Restrictions.ilike("cname", category_name, MatchMode.START));
            }
            
            List<Category> categories = criteria.list();
            req.setAttribute("categories", categories);
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("temp_category_row.jsp");
            dispatcher.include(req, resp);
            
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
