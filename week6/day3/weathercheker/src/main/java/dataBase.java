import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by HP on 4/28/2017.
 */
public class dataBase {

  static List<String[]> fileReader() {
    try {
      FileReader path = new FileReader("src/main/resources/data.csv");
      CSVReader reader = new CSVReader(path, ';');
      List<String[]> lines = reader.readAll();
      return lines;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
