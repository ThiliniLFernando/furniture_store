package Controler;

import Model.Validation;
import database.Cart;
import database.FrontUser;
import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

/**
 *
 * @author Thilini
 */
public class CAddCartData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String responseText = "";

            String product_id = req.getParameter("pid").trim();
            String qty = req.getParameter("cqty").trim();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            if (!product_id.isEmpty()) {
                if (!qty.isEmpty()) {
                    if (Validation.isNumeric(qty)) {
                        Integer enter_qty = Integer.parseInt(qty);
                        if (enter_qty > 0) {

                            Product product = (Product) session.load(Product.class, product_id);

                            if (req.getSession().getAttribute("current_user") != null) {
                        // user logged // use db cart

                                // get customer object from http session
                                FrontUser customer = (FrontUser) req.getSession().getAttribute("current_user");

                                //get customer from db
                                customer = (FrontUser) session.load(FrontUser.class, customer.getId());

                                // get cart
                                Set<Cart> db_cart = customer.getCarts();

                                if (db_cart.isEmpty()) {
                                    // no items in user's cart
                                    if (product.getMaxQtyOrderPerDay() >= Integer.parseInt(qty)) {

                                        //Add to DB Cart
                                        //cart object ekak hadala data tika add karagannawa
                                        Cart cart = new Cart();
                                        cart.setFrontUser(customer);
                                        cart.setProduct(product);//hibernate waladi has-A relationship ekakata adalawa value ekak add karaddi nikanma id eka add karala behe,e product id ekata adala product object ekak yawanna one,e nisa id ekata adala product object eka ihatha widiyata araganna puluwan
                                        cart.setCartQty(Integer.parseInt(qty));

                                        session.save(cart);//cart object eka save karanawa
                                        session.beginTransaction().commit();

                                        responseText = "1";

                                    } else {
                                        responseText = "Quantity out of stock";
                                    }
                                } else {
                                    // user has cart items
                                    Cart cart = null;
                                    for (Cart c : db_cart) {
                                        if (c.getProduct().getId().equals(product.getId())) {
                                            cart = c;
                                            break;
                                        }
                                    }

                                    if (cart != null) {
                                        // this product already in the cart
                                        if (product.getMaxQtyOrderPerDay() >= (cart.getCartQty() + Integer.parseInt(qty))) {
                                            cart.setCartQty(cart.getCartQty() + Integer.parseInt(qty));
                                            session.update(cart);
                                            session.beginTransaction().commit();
                                            responseText = "1";
                                        } else {
                                            // quantity out of stock
                                            responseText = "You can add only " + (product.getMaxQtyOrderPerDay() - cart.getCartQty()) + " Items";
                                        }
                                    } else {
                                        // this product is not in the cart
                                        if (product.getMaxQtyOrderPerDay() >= Integer.parseInt(qty)) {
                                            Cart cart1 = new Cart();
                                            cart1.setFrontUser(customer);
                                            cart1.setProduct(product);//hibernate waladi has-A relationship ekakata adalawa value ekak add karaddi nikanma id eka add karala behe,e product id ekata adala product object ekak yawanna one,e nisa id ekata adala product object eka ihatha widiyata araganna puluwan
                                            cart1.setCartQty(Integer.parseInt(qty));

                                            // insert new cart object
                                            session.save(cart1);
                                            session.beginTransaction().commit();
                                            responseText = "1";
                                        } else {
                                            responseText = "Quantity out of stock";
                                        }
                                    }
                                }
                                // user logged // use db cart

                            } else {
                                // user not logged // use session cart
                                //Add to Session Cart

                                HttpSession httpSession = req.getSession();

                                if (httpSession.getAttribute("user_cart_items") != null) {
                                    // session cart exist
                                    ArrayList<Cart> cart_items = (ArrayList<Cart>) httpSession.getAttribute("user_cart_items");

                                    Cart cart = null;

                                    for (Cart c : cart_items) {
                                        if (c.getProduct().getId().equals(product.getId())) {
                                            cart = c;
                                            break;
                                        }
                                    }

                                    if (cart != null) {
                                        if (product.getMaxQtyOrderPerDay() >= (cart.getCartQty() + Integer.parseInt(qty))) {
                                            cart.setCartQty(cart.getCartQty() + Integer.parseInt(qty));
                                            responseText = "1";
                                        } else {
                                            // quantity out of stock
                                            responseText = "you can add only " + (product.getMaxQtyOrderPerDay() - cart.getCartQty()) + " items";
                                        }
                                    } else {
                                        if (product.getMaxQtyOrderPerDay() >= Integer.parseInt(qty)) {
                                            // quantity available

                                            Cart cart1 = new Cart();
                                            cart1.setFrontUser(null);
                                            cart1.setProduct(product);
                                            cart1.setCartQty(Integer.parseInt(qty));

                                            cart_items.add(cart1);
                                            responseText = "1";

                                        } else {
                                            // quantity out of stock
                                            responseText = "quantity out of stock";
                                        }
                                    }

                                } else {
                                    // there is no session cart

                                    if (product.getMaxQtyOrderPerDay() >= Integer.parseInt(qty)) {
                                        // quantity available

                                        ArrayList<Cart> cart_items = new ArrayList<>();
                                        Cart cart = new Cart();
                                        cart.setFrontUser(null);
                                        cart.setProduct(product);
                                        cart.setCartQty(Integer.parseInt(qty));

                                        cart_items.add(cart);
                                        httpSession.setAttribute("user_cart_items", cart_items);
                                        responseText = "1";
                                    } else {
                                        // quantity out of stock
                                        responseText = "quantity out of stock";
                                    }
                                }
                                // add to session cart
                                // user not logged // use session cart
                            }

                        } else {
                            responseText = "Please enter valid qty to add";
                        }
                    } else {
                        responseText = "Please enter valid qty to add";
                    }
                } else {
                    // no qty
                    responseText = "Please enter qty to add";
                }
            } else {
                // no product id
                responseText = "No Product Id";
            }

            writer.write(responseText);

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
