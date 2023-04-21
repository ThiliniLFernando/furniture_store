package Controler;

import com.google.gson.Gson;
import database.Category;
import database.Feature;
import database.NewHibernateUtil;
import database.SpecifiedFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Thilini
 */
public class AUpdateCategory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String responseText = "";

            String cid = req.getParameter("cid").trim();
            String cname = req.getParameter("cname").trim();
            String cdesc = req.getParameter("cdesc").trim();
            String featureJsonString = req.getParameter("feature_list");

            Gson gson = new Gson();
            String[] feature_array = gson.fromJson(featureJsonString, String[].class);
            System.out.println(feature_array.length);

            if (!cid.isEmpty() & !cname.isEmpty()) {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();

                Category cat = (Category) session.load(Category.class, Integer.parseInt(cid));
                if (cat != null) {
                    cat.setCname(cname);
                    cat.setCdesc(cdesc);
                    if (feature_array.length > 0) {
                        Criteria cr1 = session.createCriteria(Feature.class);
                        List<Feature> features = cr1.list();
                        if (features.size() > 0) {
                            for (String feature_name : feature_array) {
                                boolean found_exist_feature = false;

                                for (Feature feature : features) {
                                    if (feature_name.toLowerCase().equals(feature.getFname())) {
                                        found_exist_feature = true;
                                    }
                                }

                                if (!found_exist_feature) {
                                    Feature f = new Feature();
                                    f.setFname(feature_name.toLowerCase());
                                    f.setFstatus("active");
                                    session.save(f);
                                    session.flush();
                                    session.clear();
                                }
                            }
                            // end checking
                        } else {
                            // feature table hasn't features 
                            for (String feature_name : feature_array) {
                                Feature f = new Feature();
                                f.setFname(feature_name.toLowerCase());
                                f.setFstatus("active");
                                session.save(f);
                                session.flush();
                                session.clear();
                            }
                        }
                        
                        
                        
                    }
                    session.update(cat);
                    session.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
