package transmission;

/**
 * A class that automatically determines the current gear by the current speed of the car.
 */

public class AutomaticTransmission implements Transmission {
  public int thresholdOne;
  public int thresholdTwo;
  public int thresholdThree;
  public int thresholdFour;
  public int thresholdFive;
  public int speed;
  public int gear;

  /**
   * Define constructor with Exceptions.
   * The latter threshold should not be smaller than the former one.
   */
  public AutomaticTransmission(int thresholdOne, int thresholdTwo, int thresholdThree,
                               int thresholdFour, int thresholdFive) {
    this.thresholdOne = thresholdOne;
    this.thresholdTwo = thresholdTwo;
    this.thresholdThree = thresholdThree;
    this.thresholdFour = thresholdFour;
    this.thresholdFive = thresholdFive;

    if (thresholdOne <= 0) {
      throw new IllegalArgumentException("Threshold_1 should be bigger than 0.");
    } else if (thresholdTwo < thresholdOne) {
      throw new IllegalArgumentException("Threshold_2 should be bigger than Threshold_1");
    } else if (thresholdThree < thresholdTwo) {
      throw new IllegalArgumentException("Threshold_3 should be bigger than Threshold_2");
    } else if (thresholdFour < thresholdThree) {
      throw new IllegalArgumentException("Threshold_4 should be bigger than Threshold_3");
    } else if (thresholdFive < thresholdFour) {
      throw new IllegalArgumentException("Threshold_5 should be bigger than Threshold_4");
    }
  }

  /**
   * Check whether gear is in the proper status.
   */
  public int checkGear() {
    if (this.speed == 0) {
      this.gear = 0;
    } else if (this.speed > 0 && this.speed < this.thresholdOne) {
      this.gear = 1;
    } else if (this.speed >= this.thresholdOne && this.speed < this.thresholdTwo) {
      this.gear = 2;
    } else if (this.speed >= this.thresholdTwo && this.speed < this.thresholdThree) {
      this.gear = 3;
    } else if (this.speed >= this.thresholdThree && this.speed < this.thresholdFour) {
      this.gear = 4;
    } else if (this.speed >= this.thresholdFour && this.speed < this.thresholdFive) {
      this.gear = 5;
    } else if (this.speed >= this.thresholdFive) {
      this.gear = 6;
    }

    return this.gear;
  }

  /**
   * Increase speed by 2 and check whether the gear is in the proper status.
   * @return
   */
  @Override
  public Transmission increaseSpeed() {
    this.speed = this.speed + 2;
    this.gear = this.checkGear();
    return this;
  }

  /**
   * Decrease speed by 2 and check whether the gear is in the proper status.
   */
  @Override
  public Transmission decreaseSpeed() {
    if (this.speed - 2 < 0) {
      throw new IllegalStateException("A car cannot have a negative speed.");
    }
    this.speed = this.speed - 2;
    this.gear = this.checkGear();
    return this;
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public int getGear() {
    return this.gear;
  }

  /**
   * Readings' output.
   */
  public String toString() {
    return "Transmission (speed = " + this.getSpeed() + ", gear = " + this.getGear() + ")";
  }
}