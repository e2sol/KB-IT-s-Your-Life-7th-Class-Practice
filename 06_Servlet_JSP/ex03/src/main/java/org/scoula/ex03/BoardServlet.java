package org.scoula.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "board", value = "/board")
public class BoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getParameterNames()의 반환 타입 : Enumeration
        Enumeration<String> enu = req.getParameterNames();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            out.println("<p>" + name + " : " + req.getParameter(name) + "</p><br>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
