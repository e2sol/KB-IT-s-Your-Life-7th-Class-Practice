package org.scoula.ex04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestRedirect", value = "/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", "홍길동");
        req.setAttribute("useraddress", "서울");

        resp.sendRedirect("response_redirect");
        // sendRedirect()로 인해 주소창에 직접 /request_redirect를 입력해도 response_redirect로 이동
    }
}
