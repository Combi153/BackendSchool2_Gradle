package date1017.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void add () throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.ch.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://ec2-3-37-29-229.ap-northeast-2.compute.amazonaws.com/likelion","root", "12345678"
        );
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES(?, ?, ?)"
        );
        ps.setString(1, "0");
        ps.setString(2, "chanmin");
        ps.setString(3, "1233");

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao.add();
    }
}
