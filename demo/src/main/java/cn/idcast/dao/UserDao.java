package cn.idcast.dao;

import cn.idcast.domain.User;
import cn.idcast.utils.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

//操作数据库中users表的类
public class UserDao {

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return 该用户全部数据
     */

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){

        //sql
        String sql = "select * from users where username = ? and password = ?";
        //query
        User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                loginUser.getUsername(),loginUser.getPassword());
        return user;

    }
}
