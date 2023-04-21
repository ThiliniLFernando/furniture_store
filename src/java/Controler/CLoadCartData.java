/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.Cart;
import database.FrontUser;
import database.NewHibernateUtil;
import java.io.IOException;
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

public class CLoadCartData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            HttpSession httpSession = req.getSession();

            List<Cart> cart_items = null;

            if (httpSession.getAttribute("current_user") != null) {
                FrontUser customer = (FrontUser) httpSession.getAttribute("current_user");
                Criteria criteria = session.createCriteria(Cart.class);
                criteria.add(Restrictions.eq("frontUser", customer));
                cart_items = criteria.list();

            } else {
                cart_items = (List<Cart>) httpSession.getAttribute("user_cart_items");
            }

            req.setAttribute("citems", cart_items);
            RequestDispatcher rd = req.getRequestDispatcher("temp_cart_row.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
