import com.hly.spring.pojo.JuiceMaker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @date :2018/5/9
 */
public class Juice {
    public static void main(String []hly){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
        JuiceMaker juiceMaker = (JuiceMaker)ctx.getBean("juiceMaker");
        System.out.println(juiceMaker.makeJuice());
        ctx.close();

    }
}
