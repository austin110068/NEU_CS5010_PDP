package BirdClassification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Guest class.
 * Need a guest to look up birds' location.
 */
public class Guest {
  private String printMS = "";
  private String printI = "";

  /**
   * Print a sign for any given aviary that gives a description of the birds it houses,
   * and any interesting information that it may have about that animal.
   *
   * Print a “map” that lists all the aviaries by location and the birds they house.
   */
  public String printMapAndSign(Map<Integer, Aviary> conservatory) {
    for(Map.Entry<Integer, Aviary> c : conservatory.entrySet()) {
      this.printMS += "Aviary Location: " + c.getKey() +
          " -> " + c.getValue().getDescription();

      for(Map.Entry<Integer, Bird> a : c.getValue().getAviaryMap().entrySet()) {
        this.printMS += a.getValue().getType();
      }
    }

    return this.printMS;
  }

  /**
   * Print index that lists all birds in the conservatory in alphabetical order and their location.
   */
  public String printIndex(Map<Integer, Aviary> conservatory) {
    Map<String, List<Integer>> totalBird = new HashMap<>();
    for(Map.Entry<Integer, Aviary> e : conservatory.entrySet()) {
      for(Map.Entry<Integer, Bird> b : e.getValue().getAviaryMap().entrySet()) {
        if(!totalBird.containsKey(b.getValue().getType())) {
          totalBird.put(b.getValue().getType(),
              new ArrayList<Integer>(Arrays.asList(e.getValue().getAviaryLocation())));
        }else if(totalBird.containsKey(b.getValue().getType()) &&
            !totalBird.get(b.getValue().getType()).contains(e.getValue().getAviaryLocation())) {
          totalBird.get(b.getValue().getType()).add(e.getValue().getAviaryLocation());
        }
      }
    }

    TreeMap<String, List<Integer>> conservatoryIndex = new TreeMap<>(totalBird);

    printI += "Conservatory Index:";
    for(Map.Entry<String, List<Integer>> ci : conservatoryIndex.entrySet()) {
      printI += "There's a " + ci.getKey() + " in aviary " + ci.getValue();
    }

    return printI;
  }
}
