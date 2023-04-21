/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import database.Category;
import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Thilini
 */
public class ADeleteCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String id = req.getParameter("cid").trim();
            if (!id.isEmpty()) {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                Category cat = (Category) session.load(Category.class, Integer.parseInt(id));
                if (cat != null) {
                    Set<Product> products = cat.getProducts();
                    for (Product p : products) {
                        if (!p.getPstatus().equals("deactive")) {
                            p.setPstatus("category_deactive");
                            session.update(p);
                            session.flush();
                            session.clear();
                        }
                    }
                    cat.setCstatus("deactive");
                    session.update(cat);
                    session.flush();
                    session.clear();
                    Transaction tr = session.beginTransaction();
                    tr.commit();
                    writer.write("1");
                }
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
