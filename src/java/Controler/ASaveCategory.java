package Controler;

import com.google.gson.Gson;
import database.Category;
import database.Feature;
import database.NewHibernateUtil;
import database.SpecifiedFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ASaveCategory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String responseText = "";

            String cname = req.getParameter("cname").trim().toLowerCase();
            String cdesc = req.getParameter("cdesc").trim();
            String featureJsonString = req.getParameter("feature_list");

            Gson gson = new Gson();
            String[] feature_array = gson.fromJson(featureJsonString, String[].class);

            if (!cname.isEmpty()) {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session hibernateSession = sessionFactory.openSession();

                Criteria categoryCriteria = hibernateSession.createCriteria(Category.class);
                categoryCriteria.add(Restrictions.eq("cname", cname));

                if (categoryCriteria.uniqueResult() == null) {

                    Category category = new Category();
                    category.setCname(cname);
                    category.setCdesc(cdesc);
                    category.setCstatus("active");
                    hibernateSession.save(category);
                    hibernateSession.flush();
                    hibernateSession.clear();

                    List<Feature> saveFeaturesList = new ArrayList<>();

                    if (feature_array.length > 0) {
                        // features contains in array
                        Criteria featureCriteria = hibernateSession.createCriteria(Feature.class);
                        List<Feature> db_feList = featureCriteria.list();

                        if (db_feList.isEmpty()) {
                            // feature db empty // add new features
                            for (String feature_name : feature_array) {
                                Feature f = new Feature();
                                f.setFname(feature_name.toLowerCase());
                                f.setFstatus("active");
                                hibernateSession.save(f);
                                hibernateSession.flush();
                                hibernateSession.clear();
                                saveFeaturesList.add(f);
                            }
                        } else {
                            // feature db not empty // start checking
                            for (String feature_name : feature_array) {
                                boolean found_exist_feature = false;

                                for (Feature feature : db_feList) {
                                    if (feature_name.equals(feature.getFname())) {
                                        found_exist_feature = true;
                                        saveFeaturesList.add(feature);
                                    }
                                }

                                if (!found_exist_feature) {
                                    Feature f = new Feature();
                                    f.setFname(feature_name);
                                    f.setFstatus("active");
                                    hibernateSession.save(f);
                                    hibernateSession.flush();
                                    hibernateSession.clear();
                                    saveFeaturesList.add(f);
                                }
                            }
                            // end checking
                        }
                    }

                    if (!saveFeaturesList.isEmpty()) {
                        for (Feature feature : saveFeaturesList) {
                            SpecifiedFeature sf = new SpecifiedFeature();
                            sf.setCategory(category);
                            sf.setFeature(feature);
                            hibernateSession.save(sf);
                            hibernateSession.flush();
                            hibernateSession.clear();
                        }
                    }

                    Transaction transaction = hibernateSession.beginTransaction();
                    transaction.commit();
                    responseText = "1";

                } else {
                    // category already exist
                    responseText = "Category already exists";
                }
                hibernateSession.close();
            } else {
                responseText = "Please enter the category name";
            }
            writer.write(responseText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFeatures() {

    }

}
