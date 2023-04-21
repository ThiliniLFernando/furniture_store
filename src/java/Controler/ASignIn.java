/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.BackendUser;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javassist.compiler.TokenId;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class ASignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            
            String username = req.getParameter("username").trim();
            String password = req.getParameter("password").trim();

            String responseText = "";
            if (username.isEmpty()) {
                responseText = "Please enter your email";
            } else if (password.isEmpty()) {
                responseText = "Please enter your password";
            } else {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session hibernateSession = sessionFactory.openSession();

                Criteria criteria = hibernateSession.createCriteria(BackendUser.class);
                criteria.add(Restrictions.eq("username", username));
                criteria.add(Restrictions.eq("password", password));

                BackendUser currentUser = (BackendUser) criteria.uniqueResult();
                HttpSession session = req.getSession();
                session.setAttribute("current_user", currentUser);

                responseText = "success";
                hibernateSession.close();
                
            }
            writer.write(responseText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
