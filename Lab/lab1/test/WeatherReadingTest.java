import org.junit.Before;
import org.junit.Test;
import weather.WeatherReading;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A JUnit test class for the WeatherReading class.
 */
public class WeatherReadingTest {

  private WeatherReading wrt;

  @Before
  public void setUp() {
    wrt = new WeatherReading(23, 12, 3, 12);
  }

  @Test
  public void testRelativeHumidity() {
    assertEquals(23, wrt.getTemperature());
  }

  @Test
  public void testHeatIndex() {
    assertEquals(25, wrt.getHeatIndex());
  }

  @Test
  public void testWindChill() {
    assertEquals(75, wrt.getWindChill());
  }

  @Test
  public void setWindSpeedNeg() {
    try {
      wrt = new WeatherReading(23, 12, -3, 12);
    } catch (IllegalArgumentException e) {
      fail();
    }
  }

  @Test
  public void setRainReceivedNeg() {
    try {
      wrt = new WeatherReading(23, 12, 3, -12);
    } catch (IllegalArgumentException e) {
      fail();
    }
  }

  @Test
  public void setDewTempBiggerThanAirTemp() {
    try {
      wrt = new WeatherReading(23, 30, 3, 12);
    } catch (IllegalArgumentException e) {
      fail();
    }
  }
}