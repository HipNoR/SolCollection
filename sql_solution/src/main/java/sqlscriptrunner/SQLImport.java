package sqlscriptrunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Класс работает с SQL скриптом.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.10.2018
 */
public class SQLImport {

     /**
     * Метод считывает из файла SQL скрипты и выполняет их в виде запросов к подсоединенной бд.
     * @param connection соединение с бд.
     * @param file текстовый файл с сскриптами.
     * @throws SQLException if exception.
     * @throws FileNotFoundException if exception.
     */
    private void importSQL(Connection connection, File file) throws SQLException, FileNotFoundException {
        FileInputStream is = new FileInputStream(file);
        try (Scanner s = new Scanner(is);
             Statement st = connection.createStatement()) {
            s.useDelimiter(";");
            while (s.hasNext()) {
                String line = s.next();
                if (line.trim().length() > 0) {
                    st.execute(line);
                }
            }
        }
    }
}
