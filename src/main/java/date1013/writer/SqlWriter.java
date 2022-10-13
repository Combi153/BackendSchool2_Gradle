package date1013.writer;

import java.io.IOException;

public interface SqlWriter<T> {
    void createNewFile();
    void writeSql(T contents) throws IOException;
}
