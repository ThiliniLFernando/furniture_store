/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import database.NewHibernateUtil;
import database.Role;
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

/**
 *
 * @author Thilini
 */
public class ALoadUserType extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.clear();
            
            Criteria criteria = session.createCriteria(Role.class);
            List<Role> roleList = criteria.list();
            
            writer.write("<option>Select</option>");
            for (Role role : roleList) {
                writer.write("<option>"+role.getRole()+"</option>");
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
