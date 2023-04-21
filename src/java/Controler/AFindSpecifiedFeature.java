/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.Category;
import database.NewHibernateUtil;
import database.SpecifiedFeature;
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
public class AFindSpecifiedFeature extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String category_name = req.getParameter("cat_name");
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            Criteria criteria1 = session.createCriteria(Category.class);
            criteria1.add(Restrictions.eq("cname", category_name));
            Category category = (Category) criteria1.uniqueResult();
            
            Criteria criteriaSF = session.createCriteria(SpecifiedFeature.class);
            criteriaSF.add(Restrictions.eq("category", category));
            List<SpecifiedFeature> sf = criteriaSF.list();
            
            req.setAttribute("sf_list", sf);
            req.getRequestDispatcher("temp_specified_feature_row.jsp").forward(req, resp);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
