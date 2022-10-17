package date1013.dao;

import date1013.domain.Hospital;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HospitalDao {

    public void add(List<Hospital> hospitals) throws SQLException, ClassNotFoundException, IOException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
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
}
