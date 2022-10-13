package date1013.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {

    Parser<T> parser;
    boolean isRemoveColumnName = false;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    public List<T> readLines(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<T> dataList = new ArrayList<>();
        String str;
        if (isRemoveColumnName) {
            br.readLine();
        }
        while ((str = br.readLine()) != null){
            dataList.add(parser.parse(str));
        }
        return dataList;
    }
}
