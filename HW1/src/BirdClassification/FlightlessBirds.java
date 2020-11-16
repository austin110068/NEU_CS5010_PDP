package BirdClassification;

/**
 * Create abstract class for Flightless Birds, which extends the abstract "Bird" class.
 */
abstract class FlightlessBirds extends Bird{

  public FlightlessBirds(String classification, String type, String food, boolean isExtinct,
                         int wings) {
    super(classification, type, food, isExtinct, wings);
  }
}
