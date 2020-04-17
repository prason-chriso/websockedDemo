package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages ={"controller"})
@EnableWebMvc
public class myServletConfig implements WebMvcConfigurer{

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("/res/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public ViewResolver resolver(){
        InternalResourceViewResolver resolvr = new InternalResourceViewResolver();
        resolvr.setViewClass(JstlView.class);
        resolvr.setPrefix("/WEB-INF/views/");
        resolvr.setSuffix(".jsp");
        return resolvr;
    }
}
