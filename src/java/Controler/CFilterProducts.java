/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.FO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import database.Category;
import database.Feature;
import database.NewHibernateUtil;
import database.Product;
import database.ProductFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class CFilterProducts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String startPage = req.getParameter("start");
            String dept = req.getParameter("dept").toLowerCase().trim();
            String category = req.getParameter("category").toLowerCase().trim();
            String features = req.getParameter("features").toLowerCase().trim();
            String search_pname = req.getParameter("search_pname").toLowerCase().trim();
            String order_by = req.getParameter("order_by").toLowerCase().trim();
            String price_from = req.getParameter("min_price");
            String price_to = req.getParameter("max_price");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("pstatus", "active"));

            if (!dept.isEmpty() & !dept.equals("select department")) {
                criteria.add(Restrictions.eq("department", dept));
            }

            if (!category.isEmpty() & !category.equals("select category")) {
                Criteria cr1 = session.createCriteria(Category.class);
                cr1.add(Restrictions.eq("cname", category));
                Category cat = (Category) cr1.uniqueResult();
                criteria.add(Restrictions.eq("category", cat));
            }

            if (!search_pname.isEmpty()) {
                criteria.add(Restrictions.like("pname", search_pname, MatchMode.START));
            }

            switch (order_by) {
                case "price low to high":
                    criteria.addOrder(Order.asc("price"));
                    break;
                case "price high to low":
                    criteria.addOrder(Order.desc("price"));
                    break;
                case "model asc":
                    criteria.addOrder(Order.asc("pname"));
                    break;
                case "model des":
                    criteria.addOrder(Order.desc("pname"));
                    break;
            }

            double from = 0;
            if (!price_from.isEmpty()) {
                try {
                    from = Double.parseDouble(price_from);
                    criteria.add(Restrictions.ge("price", from));
                } catch (Exception e) {

                }
            }

            double to = 0;
            if (!price_to.isEmpty()) {
                try {
                    to = Double.parseDouble(price_to);
                    if (to > from) {
                        criteria.add(Restrictions.le("price", to));
                    }
                } catch (Exception e) {

                }
            }

            if (!features.equals("[]")) {
                Gson gson = new GsonBuilder().setLenient().create();
                Type arrayListType = new TypeToken<ArrayList<FO>>() {
                }.getType();

                ArrayList<FO> fo_list = gson.fromJson(features, arrayListType);

                if (fo_list.size() > 0) {
                    Criteria criteria2 = session.createCriteria(ProductFeature.class);

                    Disjunction disjunction = Restrictions.disjunction();
                    int i = 0;
                    for (FO fo : fo_list) {
                        Feature feature = (Feature) session.load(Feature.class, Integer.parseInt(fo.getName()));
                        if (!fo.getValue().equals(feature.getFname())) {
                            Criterion c1 = Restrictions.eq("feature", feature);
                            Criterion c2 = Restrictions.eq("featureValue", fo.getValue());
                            disjunction.add(Restrictions.and(c1, c2));
                            i++;
                        }
                    }

                    criteria2.add(disjunction);

                    Set<String> pid_list = new HashSet<>();

                    if (i > 0) {
                        ProjectionList list = Projections.projectionList();
                        list.add(Projections.groupProperty("product"));
                        list.add(Projections.property("product"));
                        list.add(Projections.count("product").as("count"));
                        criteria2.setProjection(list);

                        List<Object[]> ps = criteria2.list();
                        for (Object[] objects : ps) {
                            Product p = (Product) objects[1];
                            long count = (long) objects[2];
                            if (count == i) {
                                pid_list.add(p.getId());
                            }

                        }

                        System.out.println("PId count" + pid_list.size());
                        if (pid_list.size() <= 0) {
                            pid_list.add("P000001");
                        }

                        criteria.add(Restrictions.in("id", pid_list));
                    }
                }
            }

            int count = criteria.list().size();
            int pages = count / 12;
            if (count % 12 != 0) {
                pages++;
            }

            criteria.setFirstResult(Integer.parseInt(startPage));
            criteria.setMaxResults(12);

            ArrayList<Product> p_List = (ArrayList<Product>) criteria.list();

            req.setAttribute("p_list", p_List);
            req.setAttribute("pages", pages);
            req.getRequestDispatcher("temp_product_panel.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
