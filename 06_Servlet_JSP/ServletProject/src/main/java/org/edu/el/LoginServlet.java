package org.edu.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/el/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userid");
        String pw = req.getParameter("passwd");

        // 전달 받은 값 로그창에 출력하기
        System.out.println("id : " + id);
        System.out.println("pw : " + pw);

        // 전달 받은 값 attribute에 세팅 > request scope 범위 : 값을 받고, 위임받은 곳까지!
        req.setAttribute("userId", id);
        req.setAttribute("pwd", pw);

        req.getRequestDispatcher("/el/login.jsp").forward(req, resp);
    }
}
