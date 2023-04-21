/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import org.hibernate.criterion.Projections;

/**
 *
 * @author Thilini
 */
public class CountProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.clear();
            Criteria criteria = session.createCriteria(Product.class);
            int count = criteria.list().size();
            count++;
            if (count>=1 & count<10) {
                writer.write("PDCT0000"+count);
            }else if (count>=10 & count<100) {
                writer.write("PDCT000"+count);
            }else if (count>=100 & count<1000) {
                writer.write("PDCT00"+count);
            }else if (count>=1000 & count<10000) {
                writer.write("PDCT0"+count);
            }else if (count>=10000 & count<100000) {
                writer.write("PDCT"+count);
            }
            
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
