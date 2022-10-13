package date1013.parser;

public class Exercise {
    public static void main(String[] args) {

        String str = "서울특별시 서초구 서초대로77길 59 강남역 2차 I'PARK 지하1층 3층 (서초동)";
        System.out.println(str);
        if (str.contains("'")){
            str = str.replace("'", "\\'");
            System.out.println("바뀝니다.");
        }
        System.out.println(str);
    }
}