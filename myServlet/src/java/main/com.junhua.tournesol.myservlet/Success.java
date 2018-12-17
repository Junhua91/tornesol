package main.com.junhua.tournesol.myservlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class Success extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        resp.setCharacterEncoding("utf-8");

        resp.getWriter().println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>注册成功: " + username + "</title>\n" +
                        "</head>\n" +
                        "<meta http-equiv=\"Content-Type\" content = \"text/html;charset=UTF-8\">"+
                        "<body>\n" +
                        "\n" +
                        "<h1>欢迎登录</h1>\n" +
                        "</body>\n" +
                        "</html>"
        );
        resp.getWriter().close();
    }
}
