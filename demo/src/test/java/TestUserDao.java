import cn.idcast.dao.UserDao;
import cn.idcast.domain.User;
import org.junit.Test;

public class TestUserDao {

    @Test
    public void testDaoTest(){
        User loginuser = new User();
        loginuser.setUsername("sb");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }

}
