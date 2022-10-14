package date1013.parser;

import date1013.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{
    @Override
    public Hospital parse(String strRow) {
        strRow = strRow.replaceAll("'","");
        String[] strArray = strRow.split(",");
        Hospital hospital = new Hospital(strArray[0], strArray[1], strArray[2], Integer.parseInt(strArray[6]), strArray[10]);
        return hospital;
    }
}
//0 1 2 6 10