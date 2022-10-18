package date1013.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private int emergency_room;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String category, int emergency_room, String name) {
        this.id = id;
        this.address = address;
        this.district = setDistrict(address);
        this.category = category;
        this.emergency_room = emergency_room;
        this.name = name;
        this.subdivision = setSubdivision(name);
    }

    public Hospital(String id, String address, String district, String category, int emergency_room, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergency_room = emergency_room;
        this.name = name;
        this.subdivision = subdivision;
    }

    public Hospital(String[] strRow) {
        this.id = strRow[0];
        this.address = strRow[1];
        this.district = setDistrict(strRow[1]);
        this.category = strRow[2];
        this.emergency_room = Integer.parseInt(strRow[6]);
        this.name = strRow[10];
        this.subdivision = setSubdivision(strRow[10]);
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergency_room() {
        return emergency_room;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    @Override
    public String toString() {
        return "('" + id +
                "', '" + address +
                "', '" + district +
                "', '" + category +
                "', '" + emergency_room +
                "', '"+ name +
                "', '" + subdivision + "')";
    }

    private String setDistrict(String address) {
        String[] temp = address.split(" ");
        return temp[0] + " " + temp[1];
    }

    private String setSubdivision(String name) {
        String[] nameCheck = {"내과", "외과", "소아", "피부", "성형", "정형외과", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "영유아", "안과", "가정의학과", "비뇨기과", "치과"};
        for (String s : nameCheck) {
            if (name.contains(s)){
                subdivision = s;
            }
        }
        return subdivision;
    }
}
