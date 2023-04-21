/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Validation;
import database.FrontUser;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Thilini
 */
public class CChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            HttpSession session = req.getSession(false);

            if (session != null) {
                String currentPw = req.getParameter("currentPw").trim();
                String newPw = req.getParameter("newPw").trim();
                String retypePw = req.getParameter("retypePw").trim();

                if (session.getAttribute("current_user") != null) {
                    FrontUser customer = (FrontUser) session.getAttribute("current_user");

                    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                    Session session1 = sessionFactory.openSession();

                    customer = (FrontUser) session1.load(FrontUser.class, customer.getId());

                    if (!currentPw.equals(customer.getPassword())) {
                        writer.write("Current password incorrect !");
                    } else if (!newPw.equals(retypePw)) {
                        writer.write("Conform your password !");
                    } else if(newPw.equals(retypePw) & !Validation.isValidPassword(newPw)){
                        writer.write("Please enter valid password !");
                    }else {
                        customer.setPassword(newPw);
                        session1.update(customer);
                        session1.beginTransaction().commit();
                        writer.write("1");
                    }

                    session1.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
