package main.com.junhua.tournesol.myservlet;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        try {
            Context ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
//            conn = ds.getConnection();
//            System.out.println(conn);

            Context envCtx = (Context) ctx.lookup("java:comp/env");
            DataSource bs = (DataSource) envCtx.lookup("jdbc/mysql");
            conn = bs.getConnection();

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmed_password");

        if (password.equals(confirmedPassword))
            req.getRequestDispatcher("success").forward(req, resp);
        else
            req.getRequestDispatcher("failure").forward(req, resp);

    }
}
