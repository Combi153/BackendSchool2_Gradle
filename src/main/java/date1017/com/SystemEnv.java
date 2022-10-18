package date1017.com;

import java.util.Map;

public class SystemEnv {
    public static void main(String[] args) {
        /*
        * 환경변수 설정과 내용 보기
        * Edit Configurations.. 클릭
        * Environment Variables 추가
        * */
        Map<String, String> env = System.getenv();

        for (String s : env.keySet()) {
            System.out.printf("key : %s value : %s\n", s, env.get(s));
        }
    }
}
