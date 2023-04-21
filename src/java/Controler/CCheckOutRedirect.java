/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.Cart;
import database.FrontUser;
import database.NewHibernateUtil;
import database.Order;
import database.OrderProduct;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class CCheckOutRedirect extends HttpServlet {

    private static double USD = 181.53;
    static DecimalFormat df = new DecimalFormat("#.00");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String total = req.getParameter("tot");
            double cart_total = Double.parseDouble(total);
            double tot = Double.parseDouble(total);
            cart_total = cart_total / USD;
            total = df.format(cart_total);

            PrintWriter writer = resp.getWriter();
            HttpSession session = req.getSession(false);

            if (session != null) {
                if (session.getAttribute("current_user") != null) {
                    System.out.println(" user found");
                    session.setAttribute("cart_total", total);

                    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                    Session session1 = sessionFactory.openSession();

                    FrontUser user = (FrontUser) session.getAttribute("current_user");
                    user = (FrontUser) session1.load(FrontUser.class, user.getId());

                    Order order = new Order();
                    order.setFrontUser(user);
                    order.setOrderDate(new Date());
                    order.setOrderStatus("processing");
                    order.setSubTotal(tot);

                    session1.save(order);

                    Criteria cr1 = session1.createCriteria(Cart.class);
                    cr1.add(Restrictions.eq("frontUser", user));
                    List<Cart> cart_items = cr1.list();

                    for (Cart c : cart_items) {

                        Product p = (Product) session1.load(Product.class, c.getProduct().getId());

                        OrderProduct op = new OrderProduct();
                        op.setOpStatus("processing");
                        op.setOrder(order);
                        op.setOrderPrice(p.getPrice() * c.getCartQty());
                        op.setOrderQty(c.getCartQty());
                        op.setProduct(c.getProduct());
                        op.setRowDiscount(0.00);
                        op.setRowSubTotal((c.getCartQty() * p.getPrice()));
                        op.setRowTotal((c.getCartQty() * p.getPrice()));

                        session1.save(op);
                        session1.flush();
                        
                        session1.delete(c);
                    }
                    writer.write("CCheckOut.jsp");

                    Transaction tr = session1.beginTransaction();
                    tr.commit();
                    session1.close();

                } else {
                    System.out.println("user not found");
                    writer.write("CSignInUp.jsp");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
