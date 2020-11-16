package BirdClassification;

/**
 * Create abstract class for Parrots, which extends the abstract "Bird" class.
 */
abstract class Parrots extends Bird{
  private int numsOfVoc;
  private String favSaying;

  public Parrots(String classification, String type, String food, boolean isExtinct, int wings) {
    super(classification, type, food, isExtinct, wings);
  }

  /**
   * Set up number of voices that the parrot can make.
   */
  public void numsOfVoc(int numsOfVoc) {
    this.numsOfVoc = numsOfVoc;
  }

  /**
   * Set up the favorite saying for the parrot.
   */
  public void favSaying(String favSaying) {
    this.favSaying = favSaying;
  }
}
