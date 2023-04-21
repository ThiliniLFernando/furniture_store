package Controler;

import database.BackendUser;
import database.NewHibernateUtil;
import database.Role;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thilini
 */
public class ALoadUser extends HttpServlet {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.clear();
            
            String name = req.getParameter("sbname").trim();
            String uname = req.getParameter("sbuname").trim();
            String utype = req.getParameter("sbutype").trim();
            String mobile = req.getParameter("sbmobile").trim();
            String email = req.getParameter("sbemail").trim();
            String status = req.getParameter("sbstatus").trim();
            String dcreate = req.getParameter("sbdcreate").trim();
            
            Criteria criteria = session.createCriteria(BackendUser.class);
            
            if (!name.isEmpty()) {
                criteria.add(Restrictions.ilike("name", name, MatchMode.START));
            }
            
            if (!uname.isEmpty()) {
                criteria.add(Restrictions.ilike("username", uname, MatchMode.START));
            }
            
            if (!utype.isEmpty() & !utype.toLowerCase().equals("select")) {
                Criteria cr1 = session.createCriteria(Role.class);
                Role role = (Role) cr1.uniqueResult();
                criteria.add(Restrictions.eq("role", role));
            }
            
            if (!mobile.isEmpty()) {
                criteria.add(Restrictions.ilike("mobile", mobile, MatchMode.START));
            }
            
            if (!email.isEmpty()) {
                criteria.add(Restrictions.ilike("email", email, MatchMode.START));
            }
            
            if (!status.isEmpty() & !status.toLowerCase().equals("none")) {
                criteria.add(Restrictions.eq("buserStatus", status));
            }
            
            if (!dcreate.isEmpty()) {
                Date date = dateFormat.parse(dcreate);
                criteria.add(Restrictions.eq("dateCreated", date));
            }
            
            List<BackendUser> backendUsers = criteria.list();
            
            req.setAttribute("backendUsers", backendUsers);
            req.getRequestDispatcher("temp_admin_user_row.jsp").forward(req, resp);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
