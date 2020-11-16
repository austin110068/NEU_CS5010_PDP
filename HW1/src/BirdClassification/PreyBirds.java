package BirdClassification;

/**
 * Create abstract class for Prey birds, which extends the abstract "Bird" class.
 */
abstract class PreyBirds extends Bird{
  public PreyBirds(String classification, String type, String food, boolean isExtinct, int wings) {
    super(classification, type, food, isExtinct, wings);
  }
}
