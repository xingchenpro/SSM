import com.hly.spring.SpringIOC.Util.ComponentConfig;
import com.hly.spring.SpringIOC.controller.AutowiredRoleController;
import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.service.ComponentRoleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @date :2018/5/12
 */
public class AutowiredTest {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);
        BeanRole role = context.getBean(BeanRole.class);
        AutowiredRoleController autowiredRoleController = context.getBean(AutowiredRoleController.class);
        autowiredRoleController.printRole();

    }
}
