package Controler;

import database.BackendUser;
import database.NewHibernateUtil;
import database.Role;
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

public class ASignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name").trim();
            String username = req.getParameter("username").trim();
            String pwd = req.getParameter("pwd").trim();
            String retype_pwd = req.getParameter("retype_pwd").trim();
            String role = req.getParameter("role").trim();

            String responseText = "";
            if (name.isEmpty()) {
                responseText = "Please enter your name";
            } else if (username.isEmpty()) {
                responseText = "Please enter your email";
            } else if (pwd.isEmpty()) {
                responseText = "Please enter your password";
            } else if (pwd.length() < 8) {
                responseText = "Please enter valid password";
            } else if (!pwd.equals(retype_pwd)) {
                responseText = "Please confirm your password";
            } else {
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session hibernateSession = sessionFactory.openSession();

                Criteria criteria1 = hibernateSession.createCriteria(Role.class);
                criteria1.add(Restrictions.eq("role", role));
                Role roleObj = (Role) criteria1.uniqueResult();

                BackendUser user = new BackendUser();
                user.setName(name);
                user.setUsername(username);
                user.setPassword(pwd);
                user.setRole(roleObj);
                user.setDateCreated(new Date());
                user.setBuserStatus("active");
                hibernateSession.save(user);

                Transaction transaction = hibernateSession.beginTransaction();
                transaction.commit();

                hibernateSession.close();

                responseText = "success";
            }

            PrintWriter writer = resp.getWriter();
            writer.write(responseText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
