package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // userid, passwd 파라미터 추출
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        // 추출한 값을 request scope에 저장
        req.setAttribute("userid", userid);
        req.setAttribute("passwd", passwd);

        // login.jsp로 포워딩
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
