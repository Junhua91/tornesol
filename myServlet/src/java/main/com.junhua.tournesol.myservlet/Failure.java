package main.com.junhua.tournesol.myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/failure")
public class Failure extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <title>Title</title>\n" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> " +
                        "</head>\n" +
                        "<body>\n" +
                        "<a href = \"register.html\">很遗憾: " + username + "注册失败。请重新注册</h1>\n" +
                        "</body>\n" +
                        "</html>"
        );
        resp.getWriter().close();
    }
}
