/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Validation;
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
public class UpdateCartItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String responseText = "";

            String pid = req.getParameter("id").trim().toUpperCase();
            String qty = req.getParameter("qty").trim();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            List<Cart> cart_items = null;
            // check qty
            if (!qty.isEmpty() & !pid.isEmpty() & Validation.isNumeric(qty)) {
                System.out.println("pid not null.. qty ok");
                HttpSession httpSession = req.getSession();

                int update_qty = Integer.parseInt(qty);

                if (httpSession.getAttribute("current_user") != null) {
                    // user exist
                    // db cart

                    FrontUser customer = (FrontUser) httpSession.getAttribute("current_user");
                    customer = (FrontUser) session.load(FrontUser.class, customer.getId());
                    Product product = (Product) session.load(Product.class, pid);

                    if (product.getMaxQtyOrderPerDay() >= update_qty) {
                        Criteria criteria = session.createCriteria(Cart.class);
                        criteria.add(Restrictions.eq("frontUser", customer));
                        criteria.add(Restrictions.eq("product", product));

                        Cart cart = (Cart) criteria.uniqueResult();
                        if (update_qty == 0) {
                            session.delete(cart);
                        } else {
                            cart.setCartQty(update_qty);
                            session.update(cart);
                        }

                        session.flush();
                        session.clear();
                        session.beginTransaction().commit();
                        session.close();

                        writer.write("1");
                    } else {
                        //out of stock
                        writer.write("0");
                    }
                } else {
                    // user not exist
                    // session cart
                    cart_items = (List<Cart>) httpSession.getAttribute("user_cart_items");
                    if (cart_items != null) {
                        // have session cart
                        Cart found_cart = null;

                        for (Cart cart : cart_items) {
                            if (cart.getProduct().getId().equals(pid)) {
                                found_cart = cart;
                            }
                        }

                        if (found_cart != null) {
                            if (found_cart.getProduct().getMaxQtyOrderPerDay() >= update_qty) {
                                //qty ok
                                Product p = found_cart.getProduct();
                                FrontUser frontUser = found_cart.getFrontUser();
                                cart_items.remove(found_cart);

                                if (update_qty > 0) {
                                    Cart c = new Cart();
                                    c.setCartQty(update_qty);
                                    c.setFrontUser(frontUser);
                                    c.setProduct(p);
                                    cart_items.add(c);
                                }
                                writer.write("1");

                            } else {
                                //out of stock
                                writer.write("0");
                            }
                        }

                    }
                }
            } else {
                writer.write("2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
