package org.scoula.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Autowired
    private Environment env;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        return new Filter[]{filter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        MultipartConfigElement multipartConfig =
                new MultipartConfigElement(
                        env.getProperty("upload.location"),
                        Long.parseLong(env.getProperty("upload.maxFileSize")),
                        Long.parseLong(env.getProperty("upload.maxRequestSize")),
                        Integer.parseInt(env.getProperty("upload.fileSizeThreshold"))
                );

        registration.setMultipartConfig(multipartConfig);

        registration.setInitParameter(
                "throwExceptionIfNoHandlerFound",
                "true"
        );
    }
}