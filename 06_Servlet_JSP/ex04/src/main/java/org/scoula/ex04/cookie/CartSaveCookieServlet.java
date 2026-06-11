package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cartSaveCookie", value = "/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // product 파라미터 값 추출
        String product = req.getParameter("product");

        // 기존의 쿠키 목록 들고오기
        Cookie[] cookies = req.getCookies();

        // 새롭게 저장할 쿠키 객체 생성
        Cookie cookie = null;

        if (cookies == null || cookies.length == 0) {
            // 기존의 쿠키가 존재하지 않는 경우
            cookie = new Cookie("product", product);
        } else {
            // 기존의 쿠키가 존재하는 경우
            cookie = new Cookie("product"+(cookies.length+1), product);
        }

        // 쿠키 값을 저장
        resp.addCookie(cookie);

        // 화면 출력
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Product 추가!!<br>");
        out.println("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.println("<a href='cart_view_cookie'>장바구니 보기</a><br>");
        out.println("</body></html>");
    }
}
