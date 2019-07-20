package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
//WebMvcConfigurer
@Configuration
@EnableWebMvc
@ComponentScan
public class ViewConfig extends WebMvcConfigurerAdapter  {


//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp().viewClass(JstlView.class)
//        .prefix("/WEB-INF/view/")
//        .suffix(".jsp");
//    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
//    @Bean
//    public InternalResourceViewResolver getViewResolver(){
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/view/");
//        bean.setSuffix(".jsp");
//        return bean;
//    }

}
