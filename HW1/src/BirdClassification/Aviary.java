package BirdClassification;

import java.util.Map;
import java.util.HashMap;

/**
 * Aviary class.
 * Each aviary class has its own bird-map and each bird has its own birdLocation.
 */
public class Aviary {
  private Map<Integer, Bird> birds;
  private Map<String, Integer> food;
  private String description;
  private int aviaryLocation;
  private int birdLocation;
  private boolean isMixed;

  /**
   * Aviary constructor.
   *
   * @param aviaryLocation each bird has its own location.
   * @param description describe the aviary. (Mixed, PreyBird exclusive...etc)
   * @param isMixed whether the aviary is mixed.
   */
  public Aviary(int aviaryLocation, String description, boolean isMixed) {
    this.birds = new HashMap<Integer, Bird>();
    this.food = new HashMap<String, Integer>();
    this.description = description;
    this.aviaryLocation = aviaryLocation;
    this.birdLocation = 1;
    this.isMixed = isMixed;
  }

  /**
   * Set up aviary.
   *
   * @param birdLocation location for bird in each aviary.
   * @param target target bird.
   */
  public void setAviary(int birdLocation, Bird target) {
    this.birds.put(birdLocation, target);
  }

  /**
   * Set up food type and quantity.
   *
   * @param foodType Birds' food.
   * @param foodQuantity Quantity for each bird.
   */
  public void setFood(String foodType, int foodQuantity) {
    if(!this.food.containsKey(foodType))
      this.food.put(foodType, foodQuantity);
    else
      this.food.put(foodType, this.food.get(foodType) + foodQuantity);
  }

  /**
   * Get aviary's description.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Get bird location in each aviary.
   */
  public int getBirdLocation() {
    return this.birdLocation++;
  }

  /**
   * Get aviary location in conservatory.
   */
  public int getAviaryLocation() {
    return this.aviaryLocation;
  }

  /**
   * Get aviary's food collection.
   */
  public Map<String, Integer> getFood() {
    return this.food;
  }

  /**
   * Get bird map.
   */
  public Map<Integer, Bird> getAviaryMap() {
    return this.birds;
  }
}
