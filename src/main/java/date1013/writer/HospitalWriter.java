package date1013.writer;

import date1013.domain.Hospital;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HospitalWriter implements SqlWriter<List<Hospital>>{

    File file;

    public HospitalWriter(String fileName) {
        this.file = new File(fileName);
        createNewFile();
    }

    @Override
    public void createNewFile() {
        try {
            if(file.createNewFile()){
                System.out.println("File created");
            } else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeSql(List<Hospital> contents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        String insertStatement = """
                INSERT INTO `likelion-hospital`.`seoul-hospital`
                (`hospital_id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)
                VALUES""";

           writer.write(insertStatement);
        for (int i = 0; i < contents.size(); i++) {
            Hospital content = contents.get(i);
            writer.newLine();
            writer.write(content.toString());
            if (i < contents.size() - 1) {
                writer.write(",");
            }
        }
        writer.flush();
        writer.close();
        System.out.println("파일이 생성되었습니다.");
    }
}
