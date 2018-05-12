import com.hly.spring.SpringIOC.Util.ComponentConfig;
import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.pojo.BeanRoleScan;
import com.hly.spring.SpringIOC.service.ComponentRoleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :hly
 * @date :2018/5/12
 */
public class ComponentScanTest {

    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);
        BeanRole role = context.getBean(BeanRole.class);
        ComponentRoleService componentRoleService = context.getBean(ComponentRoleService.class);
        componentRoleService.printRoleInfo(role);
    }
}
