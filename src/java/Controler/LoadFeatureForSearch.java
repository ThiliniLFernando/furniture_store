package Controler;

import database.Category;
import database.Feature;
import database.NewHibernateUtil;
import database.Product;
import database.ProductFeature;
import database.SpecifiedFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class LoadFeatureForSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String param = req.getParameter("cat_name").toLowerCase().trim();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Category.class);
            criteria.add(Restrictions.eq("cname", param));
            Category cat = (Category) criteria.uniqueResult();

            Set<Product> products = cat.getProducts();
            Set<SpecifiedFeature> specifiedFeatures = cat.getSpecifiedFeatures();

            List<Feature> features = new ArrayList<>();
            for (SpecifiedFeature sf : specifiedFeatures) {
                features.add(sf.getFeature());
            }

            Criteria criteria2 = session.createCriteria(ProductFeature.class);
            criteria2.add(Restrictions.in("feature", features));
            criteria2.add(Restrictions.in("product", products));
            List<ProductFeature> productFeatures = criteria2.list();

            HashMap<Feature, Set<String>> sf_Map = new HashMap<>();

            for (SpecifiedFeature sf : specifiedFeatures) {
                Feature feature = sf.getFeature();
                String feature_name = sf.getFeature().getFname();
                Set<String> feature_value = new HashSet<>();

                for (ProductFeature pf : productFeatures) {
                    String pfString = pf.getFeatureValue();
                    if (feature_name.equals(pf.getFeature().getFname())) {
                        feature_value.add(pfString);
                    }

                }
                sf_Map.put(feature, feature_value);
            }

            session.close();

            req.setAttribute("sf_map", sf_Map);
            req.getRequestDispatcher("temp_specified_feature_comboViewer.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
