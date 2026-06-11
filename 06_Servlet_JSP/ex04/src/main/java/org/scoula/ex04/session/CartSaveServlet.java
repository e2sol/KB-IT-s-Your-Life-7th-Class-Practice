package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "cartSave", value = "/cart_save")
public class CartSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Session 객체 추출
        HttpSession session = req.getSession();

        // product 파라미터 얻기
        String product = req.getParameter("product");

        // session 객체에 product 파라미터가 존재하는지 검사
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");

        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute("product", list);
        }

        // 현재 session과 list가 같은 객체를 참조중 -> list.add() 실행이 session객체의 list에 값을 추가하는 것과 동일한 역할
        // 받아온 product를 list에 추가하기
        list.add(product);

        // 화면 출력
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Product 추가!!<br>");
        out.println("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.println("<a href='cart_view'>장바구니 보기</a><br>");
        out.println("</body></html>");
    }
}
