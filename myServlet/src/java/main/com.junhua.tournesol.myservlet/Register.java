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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmed_password");
        String username = req.getParameter("username");

        if (password.equals(confirmedPassword)) {
            try {
                Context ctx = new InitialContext();
                Context envCtx = (Context) ctx.lookup("java:comp/env");
                DataSource bs = (DataSource) envCtx.lookup("com.junhua.mybatis.jdbc/mysql");
                conn = bs.getConnection();

                PreparedStatement st = conn.prepareStatement(
                        "insert into admin (nickname,password) values(?,?)"
                );
                st.setString(1, username);
                st.setString(2, password);
                st.executeUpdate();
                st.clearParameters();
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
            resp.getWriter().println("./success.html");
        } else {
            resp.getWriter().println("./failure.html");
        }
    }


}
