package date1017.com;

import date1013.domain.Hospital;
import date1013.parser.HospitalParser;
import date1013.parser.LineReader;
import date1017.com.domain.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao2 {
    public void add() throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, "2");
        ps.setString(2, "chanmin");
        ps.setString(3, "11234");

        ps.executeUpdate();
        ps.close();
        conn.close();
        System.out.println("삽입이 완료되었습니다.");
    }
    public void select() throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        String sql = "SELECT * FROM users";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String pw = rs.getString("password");
            System.out.printf("아이디 : %s \n비밀번호 : %s\n이름 : %s \n", id, name, pw );
        }

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM users WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
        rs.close();
        ps.close();
        conn.close();
        return user;
    }

    public List<User> findAll() throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<>();
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            users.add(new User(rs.getString("id"), rs.getString("name"), rs.getString("password")));
        };

        rs.close();
        ps.close();
        conn.close();
        return users;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao2 userDao2 = new UserDao2();
//        userDao2.add();
//        userDao2.select();
//        User user = userDao2.get("1");
//        System.out.println(user.getName());

        List<User> users = userDao2.findAll();
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}
