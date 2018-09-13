package my.webConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by User on 10.09.2018.
 */
public class WebAppInitializator extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return  new Class[] {WebConfig.class};
    }
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
