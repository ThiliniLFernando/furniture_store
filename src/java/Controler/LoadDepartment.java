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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

public class LoadDepartment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String request_code = req.getParameter("rc").trim();
            PrintWriter writer = resp.getWriter();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Product.class);
            criteria.setProjection(Projections.distinct(Projections.property("department")));

            ArrayList<String> pList = (ArrayList<String>) criteria.list();

            if (request_code.equals("101")) {
                req.setAttribute("pList", pList);
                req.getRequestDispatcher("temp_department.jsp").forward(req, resp);
            }else if (request_code.equals("100")) {
                writer.write("<option>Select department</option>");
                for (String s : pList) {
                    writer.write("<option>"+s+"</option>");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
