/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.RandomPassword;
import Model.Validation;
import database.BackendUser;
import database.Image;
import database.NewHibernateUtil;
import database.Role;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class ASaveUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();

            DiskFileItemFactory dfif = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dfif);
            List<FileItem> file = sfu.parseRequest(req);

            String uname = "";
            String un = "";
            String email = "";
            String mobile = "";
            String utype = "";
            FileItem image = null;

            for (FileItem i : file) {
                if (i.isFormField()) {
                    switch (i.getFieldName()) {
                        case "uname":
                            uname = i.getString().trim();
                            break;
                        case "un":
                            un = i.getString().trim();
                            break;
                        case "mobile":
                            mobile = i.getString().trim();
                            break;
                        case "email":
                            email = i.getString().trim();
                            break;
                        case "utype":
                            utype = i.getString().trim();
                            break;
                    }
                } else {
                    image = i;
                }
            }

            if (uname.isEmpty()) {
                writer.write("Please enter your name");
            } else if (un.isEmpty()) {
                writer.write("Please enter username");
            }else if (utype.toLowerCase().equals("select")) {
                writer.write("Please select user type");
            } else if (mobile.isEmpty()) {
                writer.write("Please enter your mobile number");
            } else if (!email.isEmpty() && !Validation.isValidEmailAddress(email)) {
                writer.write("Please enter valid email address");
            } else {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                Criteria criteria = session.createCriteria(Role.class);
                criteria.add(Restrictions.eq("role", utype));
                Role role = (Role) criteria.uniqueResult();

                Date date = new Date();

                BackendUser beUser = new BackendUser();
                beUser.setName(uname);
                beUser.setUsername(un);
                beUser.setPassword(RandomPassword.getRandomPassword());
                beUser.setMobile(mobile);
                beUser.setEmail(email);
                beUser.setRole(role);
                beUser.setDateCreated(date);
                beUser.setDateUpdate(date);
                beUser.setBuserStatus("active");
                if (image != null) {
                    beUser.setImage(email);
                    String name = "uimg_" + beUser.getUsername() + ".jpg";
                    String path = req.getServletContext().getRealPath("/") + "resources\\profile\\" + name;

                    File f = new File(path);

                    if (!f.exists()) {
                        image.write(f);
                    }

                    if (f.exists()) {
                        beUser.setImage("resources/profile/" + name);
                    }
                }

                session.save(beUser);
                session.flush();
                session.clear();
                tr.commit();
                writer.write("1");
                session.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
