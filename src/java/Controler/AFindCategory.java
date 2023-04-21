/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import database.Category;
import database.NewHibernateUtil;
import database.SpecifiedFeature;
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
public class AFindCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id").trim();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Category cat = (Category) session.load(Category.class, Integer.parseInt(id));
            if (cat != null) {
                if (cat.getCstatus().equals("active")) {
                    Gson gson = new Gson();
                    JsonObject jo = new JsonObject();
                    jo.addProperty("cid", cat.getId());
                    jo.addProperty("cname", cat.getCname());
                    jo.addProperty("cdesc", cat.getCdesc());

                    JsonArray feature_array = new JsonArray();
                    Set<SpecifiedFeature> sfs = cat.getSpecifiedFeatures();
                    if (sfs.size() > 0) {
                        for (SpecifiedFeature sf : sfs) {
                            feature_array.add(sf.getFeature().getFname());
                        }
                    }
                    jo.add("feature_array", feature_array);
                    resp.getWriter().write(gson.toJson(jo));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
