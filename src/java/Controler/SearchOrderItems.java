/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.NewHibernateUtil;
import database.Order;
import database.OrderProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Thilini
 */
public class SearchOrderItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session s = sessionFactory.openSession();
            
            Order o = (Order) s.load(Order.class, Integer.parseInt(id));
            Set<OrderProduct> ops = o.getOrderProducts();
            req.setAttribute("ops", ops);
            req.getRequestDispatcher("temp_order_items_viewer.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
