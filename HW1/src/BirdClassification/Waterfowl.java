package BirdClassification;

/**
 * Create abstract class for Waterfowl, which extends the abstract "Bird" class.
 */
abstract class Waterfowl extends Bird implements LiveNearWater{
  private String source;
  private String place;

  public Waterfowl(String classification, String type, String food, boolean isExtinct, int wings) {
    super(classification, type, food, isExtinct, wings);
  }

  @Override
  public void source(String source) {
    this.source = source;
  }

  @Override
  public void places(String place) {
    this.place = place;
  }
}
