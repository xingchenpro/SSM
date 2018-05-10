import com.hly.spring.pojo.springBean.ApplicationConfig;
//import com.hly.spring.pojo.springBean.PojoConfig;
        import com.hly.spring.pojo.springBean.Role;
import com.hly.spring.pojo.springIOC.JuiceMaker;
import com.hly.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/10
 */
@Component
public class BeanTest {
    @Autowired
    //@Qualifier("roleService2")
    RoleService  roleService;

    public void print(){

        // ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        //扫描包
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role role =  context.getBean(Role.class);
        roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo(role);
    }
    public static void main(String []y){
        BeanTest beanTest = new BeanTest();
        beanTest.print();

    }
}
