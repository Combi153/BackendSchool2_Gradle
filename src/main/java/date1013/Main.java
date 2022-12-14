package date1013;

import date1013.dao.HospitalDao;
import date1013.domain.Hospital;
import date1013.parser.HospitalParser;
import date1013.parser.LineReader;
import date1013.writer.HospitalWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser(), true);
        String filename = "C:\\Users\\chanmin\\Desktop\\서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);

        /*String targetName = "hospital.txt";
        HospitalWriter writer = new HospitalWriter(targetName);
        writer.writeSql(hospitals);*/
        HospitalDao hospitalDao = new HospitalDao();
//        hospitalDao.add(hospitals);
        System.out.println(hospitalDao.getById("A1100006"));
    }
}
