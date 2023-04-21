package Controler;

import Model.Validation;
import database.FrontUser;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CSignUpProcess extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            String name = req.getParameter("name").trim().toLowerCase();
            String email = req.getParameter("email").trim();
            String pw = req.getParameter("pw").trim();
            String repw = req.getParameter("repw").trim();

            PrintWriter writer = resp.getWriter();
            String responseText = "";

            if (name.isEmpty()) {
                responseText = "Please enter your Name";
            } else if (email.isEmpty()) {
                responseText = "Please enter your Email";
            } else if (!Validation.isValidEmailAddress(email)) {
                responseText = "Please enter valid email address";
            } else if (pw.isEmpty()) {
                responseText = "Please enter your Password";
            } else if (repw.isEmpty()) {
                responseText = "Please enter Retype Password Field";
            } else if (!Validation.isValidPassword(pw) | !Validation.isValidPassword(repw)) {
                responseText = "Please enter valid Password. Password must contain Number,Upercase Letter,Lowercase Latter.Shouldn't contain white space and password length must be 8 characters.";
            } else if (!pw.equals(repw)) {
                responseText = "Password and Retype password doesn't match";
            } else {

                Criteria cr1 = session.createCriteria(FrontUser.class);
                cr1.add(Restrictions.eq("email", email));
                if (cr1.uniqueResult() == null) {
                    // user not exist in db
                    Date d = new Date();
                    FrontUser fu = new FrontUser();
                    fu.setName(name);
                    fu.setEmail(email);
                    fu.setPassword(pw);
                    fu.setDateCreated(d);
                    fu.setDateUpdate(d);
                    fu.setFuserStatus("active");

                    session.save(fu);
                    session.flush();
                    session.clear();

                    Transaction tr = session.beginTransaction();
                    tr.commit();

                    responseText = "1";

                    session.close();
                } else {
                    // already user exist
                    responseText = "Already you rejested with this email address";
                }
            }

            writer.write(responseText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
