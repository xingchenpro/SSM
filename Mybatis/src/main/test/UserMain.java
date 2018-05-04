import com.learn.mybatis.dao.UserDao;
import com.learn.mybatis.pojo.User;
import com.learn.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author :hly
 * @date :2018/5/4
 */
public class UserMain {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User(4, "123", "nb");
            //sqlSession.insert("insertUser",user);
            userDao.insertUser(user);
            User user1 = userDao.getUser(1);
            sqlSession.commit();
            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
