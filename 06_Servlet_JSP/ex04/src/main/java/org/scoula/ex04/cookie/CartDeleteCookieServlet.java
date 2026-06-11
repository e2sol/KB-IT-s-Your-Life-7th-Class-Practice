package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cartDeleteCookie", value = "/cart_delete_cookie")
public class CartDeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 모든 쿠키 삭제 (session도 같이 삭제될 수 있음)

        // 현재 저장된 쿠키 얻어오기
        Cookie[] cookies = req.getCookies();

        // 저장된 쿠키의 수명을 1초로 변환 후 다시 저장
        // -> 다시 저장된 쿠키들이 자동으로 삭제됨
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(1); // 1초 뒤 만료
            resp.addCookie(cookie);
        }

        // 화면 출력
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("장바구니 비웠음!!<br>");
        out.println("<a href='cookie_product.jsp'>상품 선택 페이지</a>");
    }
}
