import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.pojo.BeanRoleScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author :hly
 * @date :2018/5/12
 */
public class BeanRoleTest {
    public  static  void  main(String [] hly){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanRoleScan.class);
        BeanRole role = context.getBean(BeanRole.class);
        System.out.println(role.getRoleName());
    }
}
