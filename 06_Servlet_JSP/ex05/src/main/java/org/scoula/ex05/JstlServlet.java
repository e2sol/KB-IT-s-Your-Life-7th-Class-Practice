package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("role", "ADMIN");
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Member member = new Member("member_"+i, "id_"+i);
            members.add(member);
        }
        req.setAttribute("members", members);

        req.setAttribute("today", new Date());

        req.getRequestDispatcher("/jstl_ex.jsp").forward(req, resp);
    }
}