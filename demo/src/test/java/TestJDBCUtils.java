import cn.idcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCUtils {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //在数据库连接池里拿个连接
            conn = JDBCUtils.getConnection();
            //定义sql
            String sql = "insert into users values(3,?,?)";
            //执行sql对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"deep");
            pstmt.setString(2,"dark");
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            JDBCUtils.close(conn,pstmt);

        }
    }
}
