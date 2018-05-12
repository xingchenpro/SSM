

import com.hly.spring.SpringIOC.pojo.IOCJuiceMaker;
import com.hly.spring.SpringIOC.pojo.IOCSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @date :2018/5/9
 */
@Configuration
public class IOCJuiceTest {

    @Bean(name = "juiceMaker2", initMethod = "init", destroyMethod = "myDestroy")
    public IOCJuiceMaker juiceMaker() {
        IOCJuiceMaker juiceMaker2 = new IOCJuiceMaker();
        juiceMaker2.setBeverageShop("茶");
        IOCSource source = new IOCSource();
        source.setFruit("芒果");
        source.setSize(1);
        source.setSugar("无糖");
        juiceMaker2.setIOCSource(source);
        return juiceMaker2;

    }

    public static void main(String[] hly) {
        /*加载XML文件的*/
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-IOC-config.xml");
        /*加载Java类，AnnotationConfigApplicationContext这个容器是为注解方式设计的*/
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(IOCJuiceTest.class);
        IOCJuiceMaker juiceMaker = (IOCJuiceMaker) ctx.getBean("IOCJuiceMaker");
        System.out.println(juiceMaker.makeJuice());
        ctx.close();


    }
}
