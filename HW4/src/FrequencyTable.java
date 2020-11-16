import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete class to build up Frequency Table.
 */
public class FrequencyTable {
  private final Map<Character, Integer> ftMap;

  public FrequencyTable(String terminalInput) {
    ftMap = new HashMap<>();
    countFrequency(terminalInput);
  }

  public FrequencyTable(File file) throws Exception {
    ftMap = new HashMap<>();
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;

    while ((st = br.readLine()) != null) {
      countFrequency(st);
    }
  }

  public void countFrequency(String input) {
    for (int i = 0; i < input.length(); i++) {
      char next = input.charAt(i);

      if (!this.ftMap.containsKey(next)) {
        this.ftMap.put(next, 1);
      } else {
        this.ftMap.put(next, this.ftMap.get(next) + 1);
      }
    }
  }

  public Map<Character, Integer> getFrequencyTable() {
    return this.ftMap;
  }
}
