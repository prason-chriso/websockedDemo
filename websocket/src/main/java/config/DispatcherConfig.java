package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {MyRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {myServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
