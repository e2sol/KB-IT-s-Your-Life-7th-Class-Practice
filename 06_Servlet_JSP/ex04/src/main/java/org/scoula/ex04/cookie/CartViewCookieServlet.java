package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cartViewCookie", value = "/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        // 화면 출력
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("장바구니 리스트<br>");
        for (Cookie cookie : cookies) {
            out.println(cookie + "<br>");
        }
        out.println("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.println("<a href='cart_delete_cookie'>장바구니 비우기</a>");
    }
}
