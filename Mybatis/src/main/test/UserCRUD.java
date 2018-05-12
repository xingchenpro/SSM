import com.learn.mybatis.dao.UserDao;
import com.learn.mybatis.pojo.PageParam;
import com.learn.mybatis.pojo.User;
import com.learn.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author :hly
 * @date :2018/5/4
 */
public class UserCRUD {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            //sqlSession.insert("insertUser",user);
            //sqlSession.commit();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //插入
           /* User user = new User("3", "123", "nb");
            userDao.insertUser(user);*/
            //统计
            int userCount = userDao.userCount();
            System.out.println("统计:" + userCount);

            //1.查询
            User user1 = userDao.getUser("1");
            System.out.println("查询:" + user1);

            /*//2..Map多参数查询
            Map<String, Object> IdAndNickMap = new HashMap<String, Object>();
            IdAndNickMap.put("userRegisterId", "1");
            IdAndNickMap.put("userNickName", "n");
            List<User> users = userDao.findUserIdAndNick(IdAndNickMap);
            System.out.println("Map多参数查询:" + users);

            //3..@Param多参数
            List<User> userParam = userDao.findUserBaseIdANDNick("1", "n");
            System.out.println("userParam:" + userParam);

            //4..JavaBean多参数查询
            User userBean = new User();
            userBean.setUserId("2");
            userBean.setUserNickName("n");
            List<User> userByBean = userDao.findUserByBean(userBean);
            System.out.println("userByBean:" + userByBean);

            //5.混合查询
            PageParam pageParam = new PageParam();
            pageParam.setStart(2);
            pageParam.setLimit(1);
            List<User> userByMix = userDao.findByMix(userBean, pageParam);
            System.out.println("userByMix:" + userByMix);*/

            //resultMap
            List<User> resultMao = userDao.getUserResultMap("4");
            System.out.println("resultMap:"+resultMao);

            /*List<User> userNick = userDao.findUser("nb");
            for(User usernick:userNick)
                System.out.println("usernick:"+usernick);*/


            //RowBounds
            /*RowBounds rowBounds = new RowBounds(0,3);
            List<User> userList = userDao.findByRowBounds("nb",rowBounds);
            for(User users:userList)
            System.out.println("userList:"+users);*/

            //更新
            /*User upUser = new User();
            upUser.setUserNickName("yun");
            upUser.setUserId("1");
            userDao.updateUser(upUser);*/

            //删除
            //userDao.deleteUser("3");

            /*CRUD只有查找不需要提交事务*/
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
