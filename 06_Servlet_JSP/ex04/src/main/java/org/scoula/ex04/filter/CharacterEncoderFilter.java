package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CharacterEncoderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 모든 요청에 대해 charset을 UTF-8로 설정
        servletRequest.setCharacterEncoding("UTF-8");

        // filterChain : 체인에서 다음 필터를 호출하는 데 사용
        //               만약 마지막 체인인 경우 체인의 끝에서 리소스(Servlet/JSP 등) 호출
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
