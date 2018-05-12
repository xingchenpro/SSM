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
 * @date :2018/5/11
 */
public class SelectUser {
    public static void main(String []args){
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            //2..Map多参数查询
            Map<String, Object> MapSelect = new HashMap<String, Object>();
            MapSelect.put("userRegisterId", "1");
            MapSelect.put("userNickName", "n");
            List<User> users = userDao.findUserByMap(MapSelect);
            System.out.println("Map多参数查询:" + users);

            //3..@Param多参数
            List<User> ParamSelect = userDao.findUserBaseByParam("1", "n");
            System.out.println("Param多参数查询:" + ParamSelect);

            //4..JavaBean多参数查询
            User BeanSelect = new User();
            BeanSelect.setUserId("2");
            BeanSelect.setUserNickName("n");
            List<User> selectByBean = userDao.findUserByBean(BeanSelect);
            System.out.println("Bean多参数查询："+selectByBean);

            //5.混合查询
            PageParam pageParam = new PageParam();
            pageParam.setStart(2);
            pageParam.setLimit(1);
            List<User> userByMix = userDao.findByMix(BeanSelect, pageParam);
            System.out.println("混合查询：:" + userByMix);

            //RowBounds
            RowBounds rowBounds = new RowBounds(0,3);
            List<User> userList = userDao.findByRowBounds("nb",rowBounds);
            for(User user:userList)
            System.out.println("RowBounds查询:"+user);

            //resultMap
            List<User> resultMapSelect = userDao.getUserResultMap("1");
            System.out.println("resultMap查询:"+resultMapSelect);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
