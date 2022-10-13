package date1013.parser.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private int emergency_room;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String district, String category, int emergency_room, String name, String subdivision) {
        this.id = id;
        this.address = address;
        String[] temp = district.split(" ");
        this.district = temp[0] + " " + temp[1];
        this.category = category;
        this.emergency_room = emergency_room;
        this.name = name;
        //this.subdivision = subdivision;
    }

    public Hospital(String[] strRow) {
        this.id = escapeApostrophe(strRow[0]);
        this.address = escapeApostrophe(strRow[1]);
        String[] temp = strRow[1].split(" ");
        this.district = escapeApostrophe(temp[0] + " " + temp[1]);
        this.category = escapeApostrophe(strRow[2]);
        this.emergency_room = Integer.parseInt(escapeApostrophe(strRow[6]));
        this.name = escapeApostrophe(strRow[10]);
        //this.subdivision = strRow[10];
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

    private String escapeApostrophe(String str){
        if (str.contains("'")){
            return str.replace("'", "\\'");
        }
        return str;
    }
}
