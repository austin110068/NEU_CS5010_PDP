import transmission.AutomaticTransmission;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A JUnit test class for the AutomaticTransmission class.
 */
public class AutomaticTransmissionTest {
  private AutomaticTransmission vehicle;

  @Before
  public void setUp() {
    vehicle = new AutomaticTransmission(2, 4, 6,
        8, 10);
  }

  @Test
  public void testIncreaseSpeed() {
    vehicle.increaseSpeed();
    assertEquals(2, vehicle.getSpeed());
  }

  @Test
  public void testIncreaseGear() {
    vehicle.increaseSpeed();
    assertEquals(1, vehicle.getGear());
  }

  @Test
  public void testDecreaseSpeed() {
    vehicle.increaseSpeed();
    vehicle.increaseSpeed();
    vehicle.increaseSpeed();
    vehicle.decreaseSpeed();
    assertEquals(4, vehicle.getSpeed());
  }

  @Test
  public void testDecreaseGear() {
    vehicle.increaseSpeed();
    vehicle.increaseSpeed();
    vehicle.increaseSpeed();
    vehicle.decreaseSpeed();
    assertEquals(2, vehicle.getGear());
  }

  @Test
  public void testSpeedNeg() {
    try {
      vehicle.decreaseSpeed();
    } catch (IllegalArgumentException e) {
      fail();
    }
  }
}