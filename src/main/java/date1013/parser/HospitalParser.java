package date1013.parser;

import date1013.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{
    @Override
    public Hospital parse(String strRow) {
        String[] strArray = strRow.split(",");
        Hospital hospital = new Hospital(strArray);
        return hospital;
    }
}