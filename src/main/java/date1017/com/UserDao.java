package date1017.com;

import date1017.com.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {

    private String dbHost;
    private String dbUser;
    private String dbPassword;

    public UserDao() {
        Map<String, String> env = System.getenv();
        this.dbHost = env.get("DB_HOST");
        this.dbUser = env.get("DB_USER");
        this.dbPassword = env.get("DB_PASSWORD");
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        return conn;
    }

    public void add (User user) {

        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES (?, ?, ?)");

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            int status = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(String id) {

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement ("SELECT * FROM users WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            rs.close();
            ps.close();
            conn.close();
            return user;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        /*User user = new User("7", "김창환", "1234");
        userDao.add(user);*/
        System.out.println(userDao.findById("7"));
    }
}
