package transmission;

/**
 * Interface that represents a single car transmission.
 */
public interface Transmission {
  int getSpeed();

  int getGear();

  Transmission increaseSpeed();

  Transmission decreaseSpeed();
}
