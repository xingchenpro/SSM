import com.hly.spring.pojo.springIOC.JuiceMaker;
import com.hly.spring.pojo.springIOC.Source;
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
public class Juice {

    @Bean(name = "juiceMaker2",initMethod = "init",destroyMethod = "myDestroy")
    public JuiceMaker juiceMaker(){
        JuiceMaker juiceMaker2 = new JuiceMaker();
        juiceMaker2.setBeverageShop("茶");
        Source source = new Source();
        source.setFruit("芒果");
        source.setSize(1);
        source.setSugar("无糖");
        juiceMaker2.setSource(source);
        return juiceMaker2;

    }
    public static void main(String []hly){
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
        //AnnotationConfigApplicationContext这个容器是为注解方式设计的
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Juice.class);
        JuiceMaker juiceMaker = (JuiceMaker)ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker.makeJuice());
        //ctx.close();


    }
}
