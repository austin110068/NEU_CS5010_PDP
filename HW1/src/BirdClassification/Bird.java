package BirdClassification;

/**
 * Abstract class for every type of bird.
 */
public abstract class Bird {
  private String classification;
  private String type;
  private String food;
  private boolean isExtinct;
  private int numOfWings;

  /**
   * Bird constructor.
   *
   * @param classification Bird classification. (PreyBird, Waterfowl...etc)
   * @param type Bird type. (Hawk, Duck...etc)
   * @param food Bird food. (Meat, Insects...etc)
   * @param isExtinct Bird extinct or not.
   * @param numOfWings Bird's wings.
   */
  public Bird(String classification, String type, String food, boolean isExtinct, int numOfWings) {
    this.classification = classification;
    this.type = type;
    this.food = food;
    this.isExtinct = isExtinct;
    this.numOfWings = numOfWings;
  }

  /**
   * return what the bird eats.
   * @return
   */
  public String eat() {
    return this.food;
  }

  /**
   * Get bird's classification.
   */
  public String getClassification() {
    return this.classification;
  }

  /**
   * Get bird's type.
   */
  public String getType() {
    return this.type;
  }

  /**
   * Get whether bird extincts.
   */
  public boolean getIsExtinct() {
    return this.isExtinct;
  }

  /**
   * Get number of bird's wings.
   */
  public int getWings() {
    return this.numOfWings;
  }
}
