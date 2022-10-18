package date1013.dao;

import date1013.domain.Hospital;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class HospitalDao {

    private String dbHost;
    private String dbUser;
    private String dbPassword;

    public HospitalDao() {
        Map<String, String> env = System.getenv();
        this.dbHost = env.get("DB_HOST");
        this.dbUser = env.get("DB_USER");
        this.dbPassword = env.get("DB_PASSWORD");
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        return conn;
    }

    public void add(List<Hospital> hospitals) throws SQLException, ClassNotFoundException, IOException {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO hospital(hospital_id, address, district, category, emergency_room, name, subdivision) VALUES(?, ?, ?, ?, ?, ?, ?)");

        for (Hospital hospital : hospitals) {
            ps.setString(1, hospital.getId());
            ps.setString(2, hospital.getAddress());
            ps.setString(3, hospital.getDistrict());
            ps.setString(4, hospital.getCategory());
            ps.setInt(5, hospital.getEmergency_room());
            ps.setString(6, hospital.getName());
            ps.setString(7, hospital.getSubdivision());
            ps.executeUpdate();
        }
        ps.close();
        conn.close();
        System.out.println("삽입이 완료되었습니다.");
    }

    public Hospital getById(String id) {

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM hospital WHERE hospital_id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Hospital hospital = new Hospital(rs.getString("hospital_id"), rs.getString("address"), rs.getString("district"),
                    rs.getString("category"), Integer.parseInt(rs.getString("emergency_room")), rs.getString("name"), rs.getString("subdivision"));
            rs.close();
            ps.close();
            conn.close();
            return hospital;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
