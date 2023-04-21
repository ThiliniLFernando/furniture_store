package Controler;

import database.Cart;
import database.FrontUser;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
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

public class CSignInProcess extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String responseText = "";

            String email = req.getParameter("email").trim();
            String pw = req.getParameter("pw").trim();

            if (email.isEmpty()) {
                responseText = "Please enter email address";
            } else if (pw.isEmpty()) {
                responseText = "Please enter password";
            } else {

                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.clear();
                Criteria cr1 = session.createCriteria(FrontUser.class);
                cr1.add(Restrictions.eq("email", email));
                cr1.add(Restrictions.eq("password", pw));

                if (cr1.uniqueResult() != null) {

                    FrontUser customer = (FrontUser) cr1.uniqueResult();

                    Set<Cart> dbCart = customer.getCarts();

                    if (req.getSession().getAttribute("user_cart_items") != null) {
                        // session cart has items
                        List<Cart> sessionCart = (List<Cart>) req.getSession().getAttribute("user_cart_items");
                        if (dbCart.isEmpty()) {
                            for (Cart cart : sessionCart) {
                                Cart c = new Cart();
                                c.setFrontUser(customer);
                                c.setProduct(cart.getProduct());
                                c.setCartQty(cart.getCartQty());
                                session.save(c);
                                session.flush();
                                session.clear();
                            }
                        } else {
                            for (Cart sc : sessionCart) {
                                boolean found_in_db_cart = false;

                                for (Cart dbc : dbCart) {
                                    if (dbc.getProduct().getId().equals(sc.getProduct().getId())) {
                                        found_in_db_cart = true;
                                        if (sc.getProduct().getMaxQtyOrderPerDay() >= (dbc.getCartQty() + sc.getCartQty())) {
                                            dbc.setCartQty(dbc.getCartQty() + sc.getCartQty());
                                            session.update(dbc);
                                            session.flush();
                                            session.clear();

                                        } else {
                                            //out of stock
                                            dbc.setCartQty(dbc.getProduct().getMaxQtyOrderPerDay());
                                            session.update(dbc);
                                            session.flush();
                                            session.clear();
                                        }
                                    }
                                }

                                // check
                                if (!found_in_db_cart) {
                                    Cart c = new Cart();
                                    c.setFrontUser(customer);
                                    c.setProduct(sc.getProduct());
                                    c.setCartQty(sc.getCartQty());
                                    session.save(c);
                                    session.flush();
                                    session.clear();
                                }
                            }
                        }
                    }

                    HttpSession session1 = req.getSession();
                    session1.setAttribute("current_user", customer);
                    responseText = "1";
                } else {
                    responseText = "This user not exist.please sign up";
                }

                Transaction tr = session.beginTransaction();
                tr.commit();
                session.close();
                
            }

            writer.write(responseText);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
