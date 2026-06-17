package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
// 새로 추가한 ex03.controller를 스캔 경로에 추가
@ComponentScan(basePackages = {"org.scoula.controller", "org.scoula.ex03.controller"})
public class ServletConfig implements WebMvcConfigurer {
    // 스프링 내부에서 사용하는 서블릿(or JSP)와 관련된 설정을 하는 파일


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // jsp에서 사용할 프론트용 자원들(js, css, img 위치와 접근 주소 설정)
        registry.addResourceHandler("/resources/**") // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/"); // webapp/resources/경로 로 맵핑
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 서버의 결과를 넣을 jsp위치와 전체 경로를 설정
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);
    }
}
