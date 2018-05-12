import com.hly.spring.SpringIOC.Util.ComponentConfig;
import com.hly.spring.SpringIOC.Util.PropertyBeanDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author :hly
 * @date :2018/5/12
 */
public class PropertyTest {
    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-IOC-config.xml");
       // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class, PropertyBeanDataSource.class);
        String url = context.getEnvironment().getProperty("url");
        System.out.println("url:"+url);
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println("dataSource:"+dataSource);
    }
}
