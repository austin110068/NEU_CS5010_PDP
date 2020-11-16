package BirdClassification;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Chien-Yu.
 *
 * This project creates a conservatory which have aviaries for birds to live in,
 * each aviary has its own restriction,
 * each bird is classified by multiple conditions.
 */
public class Driver {
  private Map<Integer, Aviary> conservatory;
  private Guest guest;
  private int aviaryLocation;
  private boolean rescued;

  /**
   * Driver constructor.
   *
   * Setting a new guest to look up for bird.
   * Setting aviary location to 1, and increases gradually until 20.
   * Setting whether bird is rescued to false.
   */
  public Driver() {
    this.conservatory = new HashMap<Integer, Aviary>();
    this.guest = new Guest();
    this.aviaryLocation = 1;
    this.rescued = false;
  }

  /**
   * Getting the conservatory.
   *
   * @return conservatory map.
   */
  public Map<Integer, Aviary> getConservatory() {
    return this.conservatory;
  }

  /**
   * Rescue new birds and bring them into conservatory.
   *
   * Check first if the bird is extinct or not.
   * If the bird is extinct, then we can't put the bird inside the conservatory.
   *
   * Then compare the bird's classification with the aviary's description,
   * since some birds' classification cannot be mixed with others'.
   * If the pattern match and there's still space in that aviary, then add the bird.
   *
   * If we fail rescuing the bird, then there are two condition.
   * condition 1: bird cannot be added to current conservatory because there aren't enough aviaries.
   * condition 2: bird cannot be added to current conservatory because the conservatory is full.
   *
   * dealing condition 1: add new aviary
   * dealing condition 2: throw IllegalArgumentException.
   *
   * @param bird target bird.
   */
  public void rescue(Bird bird) throws IllegalArgumentException {
    rescued = false;
    if (bird.getIsExtinct()) {
      System.out.println("Extinct species cannot be in conservatory.");
      rescued = true;
    } else if (this.conservatory.size() <= 20) {  // put bird in current aviary
      for (Map.Entry<Integer, Aviary> e : this.conservatory.entrySet()) {
        if (e.getValue().getDescription() == "FlightlessBirds" &&
            bird.getClassification() == "FlightlessBirds" &&  // Exclusive aviary for Flightless birds.
            e.getValue().getAviaryMap().size() < 5) {
          e.getValue().getAviaryMap().put(e.getValue().getBirdLocation(), bird);
          e.getValue().setFood(bird.eat(), 1);
          rescued = true;
          break;
        } else if (e.getValue().getDescription() == "PreyBirds" &&
            bird.getClassification() == "PreyBirds" &&  // Exclusive aviary for Birds of Prey.
            e.getValue().getAviaryMap().size() < 5) {
          e.getValue().getAviaryMap().put(e.getValue().getBirdLocation(), bird);
          e.getValue().setFood(bird.eat(), 1);
          rescued = true;
          break;
        } else if (e.getValue().getDescription() == "Waterfowl" &&
            bird.getClassification() == "Waterfowl" &&  // Exclusive aviary for Flightless birds.
            e.getValue().getAviaryMap().size() < 5) {
          e.getValue().getAviaryMap().put(e.getValue().getBirdLocation(), bird);
          e.getValue().setFood(bird.eat(), 1);
          rescued = true;
          break;
        } else if (e.getValue().getDescription() == "Mixed" &&  // Mixed aviary.
            bird.getClassification() != "FlightlessBirds" &&
            bird.getClassification() != "PreyBirds" &&
            bird.getClassification() != "Waterfowl" &&
            e.getValue().getAviaryMap().size() < 5) {
          e.getValue().getAviaryMap().put(e.getValue().getBirdLocation(), bird);
          e.getValue().setFood(bird.eat(), 1);
          rescued = true;
          break;
        }
      }
    }

    // if bird hasn't been rescued and conservatory is not full, add to new aviary.
    if (rescued == false &&
        this.conservatory.size() < 20) {
      if (bird.getClassification() == "FlightlessBirds") {
        Aviary newAviary = new Aviary(this.aviaryLocation,
            "FlightlessBirds", false);
        newAviary.setFood(bird.eat(), 1);
        newAviary.setAviary(newAviary.getBirdLocation(), bird);
        conservatory.put(this.aviaryLocation++, newAviary);
        rescued = true;
      } else if (bird.getClassification() == "PreyBirds") {
        Aviary newAviary = new Aviary(this.aviaryLocation,
            "PreyBirds", false);
        newAviary.setFood(bird.eat(), 1);
        newAviary.setAviary(newAviary.getBirdLocation(), bird);
        conservatory.put(this.aviaryLocation++, newAviary);
        rescued = true;
      } else if (bird.getClassification() == "Waterfowl") {
        Aviary newAviary = new Aviary(this.aviaryLocation,
            "Waterfowl", false);
        newAviary.setFood(bird.eat(), 1);
        newAviary.setAviary(newAviary.getBirdLocation(), bird);
        conservatory.put(this.aviaryLocation++, newAviary);
        rescued = true;
      } else {
        Aviary newAviary = new Aviary(this.aviaryLocation,
            "Mixed", true);
        newAviary.setFood(bird.eat(), 1);
        newAviary.setAviary(newAviary.getBirdLocation(), bird);
        conservatory.put(this.aviaryLocation++, newAviary);
        rescued = true;
      }
    }

    if (!rescued)
      throw new IllegalArgumentException();
  }
  /**
   * Have a guest look up which aviary a bird is in.
   * Print out a map & sign listing every aviaries and birds with location.
   */
  public String findBird() {
    return guest.printMapAndSign(this.conservatory);
  }

  /**
   * Have a guest look up which aviary a bird is in.
   * print out an index that lists all birds in the conservatory,
   * in alphabetical order and their location.
   */
  public String printConservatory() {
    return guest.printIndex(this.conservatory);
  }
}


