import configs.ViewConfig;
import controllers.MainPageController;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MainConfig implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
        webApplicationContext.register( MainPageController.class,ViewConfig.class);
//        webApplicationContext.scan("controllers");

        DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic dynamic=servletContext.addServlet("dispatcher",dispatcherServlet);
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}


//http://qaru.site/questions/239850/no-mapping-found-for-http-request-with-uri-spring-mvc
//This is really important!!!
//Когда web.xml настроен так, как у вас есть вопрос, в частности:




//<servlet-mapping>
//<servlet-name>dispatcherServlet</servlet-name>
//<url-pattern>/*</url-pattern>
//</servlet-mapping>
//ВСЕ запросы, поступающие к вашему веб-приложению, будут направлены на DispatcherServlet. Сюда входят такие запросы, как /tasklist/, /tasklist/some-thing.html, /tasklist/WEB-INF/views/index.jsp.
//
//Из-за этого, когда ваш контроллер возвращает представление, указывающее на .jsp, вместо того, чтобы разрешить серверу сервера обслуживать этот запрос, DispatcherServlet перескакивает и начинает искать контроллер, который может обслуживать этот запрос, он не находит никаких и, следовательно, 404.


//    Самый простой способ решить - настроить URL-адрес вашего сервлета следующим образом:
//
//<servlet-mapping>
//<servlet-name>dispatcherServlet</servlet-name>
//<url-pattern>/</url-pattern>
//</servlet-mapping>
//        Обратите внимание на отсутствие *. Это сообщает контейнеру, что любой запрос, который не имеет в нем path info (URL-адреса без .xxx в конце), должен быть отправлен в DispatcherServlet. С этой конфигурацией, когда получен запрос xxx.jsp, DispatcherServlet не запрашивается, и ваш сервлет сервлета по умолчанию обслуживает запрос и представляет jsp, как ожидалось.
//
//        Надеюсь, что это поможет, я понимаю, что ваши предыдущие комментарии говорят о том, что проблема решена, но решение НЕ МОЖЕТ просто добавлять method=RequestMethod.GET к RequestMethod.