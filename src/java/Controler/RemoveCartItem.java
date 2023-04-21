/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.Cart;
import database.FrontUser;
import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
public class RemoveCartItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String pid = req.getParameter("id").trim().toUpperCase();
            PrintWriter writer = resp.getWriter();
            String responseText = "";
            
            HttpSession httpSession = req.getSession();

            List<Cart> cart_items = null;
            if (httpSession.getAttribute("current_user") != null) {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                FrontUser customer = (FrontUser) httpSession.getAttribute("current_user");
                customer = (FrontUser) session.load(FrontUser.class, customer.getId());
                Product product = (Product) session.load(Product.class, pid);

                Criteria criteria = session.createCriteria(Cart.class);
                criteria.add(Restrictions.eq("frontUser", customer));
                criteria.add(Restrictions.eq("product", product));

                Cart cart = (Cart) criteria.uniqueResult();
                session.delete(cart);

                session.beginTransaction().commit();
                responseText = "1";
                session.close();
            } else {
                cart_items = (List<Cart>) httpSession.getAttribute("user_cart_items");
                if (cart_items != null) {
                    Cart found_cart = null;
                    for (Cart cart : cart_items) {
                        if (cart.getProduct().getId().equals(pid)) {
                            found_cart = cart;
                        }
                    }

                    if (found_cart != null) {
                        cart_items.remove(found_cart);
                        responseText = "1";
                    }
                }
            }

           writer.write(responseText);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
