package Controler;

import Model.ProductFeatureObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.Category;
import database.Feature;
import database.Image;
import database.NewHibernateUtil;
import database.Product;
import database.ProductFeature;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class ASaveProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            PrintWriter writer = resp.getWriter();
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dfif);
            List<FileItem> file = sfu.parseRequest(req);

            String pid = "";
            String pname = "";
            String pdesc = "";
            String pcat = "";
            String pdep = "";
            double pprice = 0;
            int pqty = 0;
            String pwarranty = "";
            int pcdays = 0;
            ArrayList<ProductFeatureObject> pfos = null;
            ArrayList<FileItem> uploadFiles = new ArrayList<>();

            Gson gson = new Gson();
            Type arrayListType = new TypeToken<ArrayList<ProductFeatureObject>>() {
            }.getType();

            for (FileItem i : file) {
                if (i.isFormField()) {
                    switch (i.getFieldName()) {
                        case "pid":
                            pid = i.getString();
                            break;
                        case "pname":
                            pname = i.getString();
                            break;
                        case "pdesc":
                            pdesc = i.getString();
                            break;
                        case "pdepartment":
                            pdep = i.getString();
                            break;
                        case "pcat":
                            pcat = i.getString();
                            break;
                        case "pprice":
                            if (!i.getString().isEmpty()) {
                                pprice = Double.parseDouble(i.getString());
                            }
                            break;
                        case "pqty":
                            if (!i.getString().isEmpty()) {
                                pqty = Integer.parseInt(i.getString());
                            }
                            break;
                        case "pwarranty":
                            pwarranty = i.getString();
                            break;
                        case "pcdays":
                            if (!i.getString().isEmpty()) {
                                pcdays = Integer.parseInt(i.getString());
                            }
                            break;
                        case "features":
                            pfos = gson.fromJson(i.getString(), arrayListType);
                            break;
                    }
                } else {
                    uploadFiles.add(i);
                }
            }

            String responseText = "";

            if (pid.isEmpty()) {
                responseText = "please enter product id";
            } else if (pname.isEmpty()) {
                responseText = "please enter product name";
            } else if (pcat.isEmpty() | pcat.equals("Select category")) {
                responseText = "please select the category";
            } else if (pdep.isEmpty()) {
                responseText = "please select the department";
            } else if (pprice <= 0.0) {
                responseText = "please enter the product price";
            } else if (pqty <= 0) {
                responseText = "please enter the product quantity";
            } else if (pcdays <= 0) {
                responseText = "please enter valid days count";
            } else if (uploadFiles.isEmpty()) {
                responseText = "please upload product image";
            } else {

                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();

                Criteria cr1 = session.createCriteria(Product.class);
                cr1.add(Restrictions.eq("pname", pname.toLowerCase()));

                if (cr1.list().size() > 0) {
                    responseText = "already exist product";
                } else {

                    Product p = new Product();
                    p.setId(pid);
                    p.setPname(pname.toLowerCase());
                    p.setPdesc(pdesc);
                    p.setDepartment(pdep);
                    p.setPrice(pprice);
                    p.setMaxQtyOrderPerDay(pqty);
                    p.setWarrantyDetails(pwarranty);
                    p.setMpsDateCount(pcdays);

                    Criteria criteria = session.createCriteria(Category.class);
                    criteria.add(Restrictions.eq("cname", pcat.toLowerCase()));
                    Category cat = (Category) criteria.uniqueResult();
                    p.setCategory(cat);

                    p.setPsearchName(pname.toLowerCase());
                    p.setPstatus("active");
                    session.save(p);
                    session.flush();
                    session.clear();

                    // product feature adding process start
                    if (pfos.size() > 0) {
                        Criteria fCriteria = session.createCriteria(Feature.class);
                        ArrayList<Feature> features = (ArrayList<Feature>) fCriteria.list();

                        for (ProductFeatureObject obj : pfos) {
                            for (Feature f : features) {
                                if (f.getFname().equals(obj.getFeatureName())) {
                                    ProductFeature pf = new ProductFeature();
                                    pf.setFeature(f);
                                    pf.setProduct(p);
                                    pf.setFeatureValue(obj.getfValue());
                                    session.save(pf);
                                    session.flush();
                                    session.clear();
                                }
                            }
                        }
                    }
                    // product feature adding process end 

                    if (uploadFiles.size() > 0) {
                        for (FileItem fileItem : uploadFiles) {
                            String name = System.currentTimeMillis() + p.getId() + fileItem.getFieldName() + ".jpg";
                            String path = req.getServletContext().getRealPath("/") + "resources\\" + name;

                            File f = new File(path);
                            fileItem.write(f);

                            if (f.exists()) {
                                Image image = new Image();
                                image.setFilePath("resources/" + name);
                                image.setProduct(p);
                                session.save(image);
                                session.flush();
                                session.clear();
                            }
                        }
                    }
                    Transaction tr = session.beginTransaction();
                    tr.commit();

                    responseText = "1";

                    session.close();
                }
            }

            writer.write(responseText);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
