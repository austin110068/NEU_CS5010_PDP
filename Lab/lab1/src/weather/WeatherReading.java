package weather;

/**
 * Define readings that are used to calculate the different temperatures in weather report.
 */
public class WeatherReading {
  // 4 params (int type)
  private int airTemperature;  // Celsius
  private int dewPointTemperature;  // Celsius, can't be greater than air temp
  private int windSpeed;  // non-negative, miles per hour
  private int rainReceived;  // non-negative

  /**
  * Define constructor with Exceptions.
  */
  public WeatherReading(int airTemperature, int dewPointTemperature,
                        int windSpeed, int rainReceived) {
    if (windSpeed < 0 || rainReceived < 0) {
      throw new IllegalArgumentException("this cannot be negative.");
    }
    if (dewPointTemperature > airTemperature) {
      throw new IllegalArgumentException("dewPointTemperature must not be greater "
        + "than airTemperature.");
    }

    this.airTemperature = airTemperature;
    this.dewPointTemperature = dewPointTemperature;
    this.windSpeed = windSpeed;
    this.rainReceived = rainReceived;
  }

  // Method
  public int getTemperature() {
    return this.airTemperature;
  }

  public int getDewPoint() {
    return this.dewPointTemperature;
  }

  public int getWindSpeed() {
    return this.windSpeed;
  }

  public int getTotalRain() {
    return this.rainReceived;
  }

  public int getRelativeHumidity() {
    return 100 - 5 * (this.getTemperature() - this.getDewPoint());
  }

  /**
   * HeatIndex.
   */
  public int getHeatIndex() {
    double r = (double)this.getRelativeHumidity();
    double t = (double)this.getTemperature();
    double c1 = -8.78469475556;
    double c2 = 1.61139411;
    double c3 = 2.33854883889;
    double c4 = -0.14611605;
    double c5 = -0.012308094;
    double c6 = -0.0164248277778;
    double c7 = 0.002211732;
    double c8 = 0.00072546;
    double c9 = -0.000003582;

    double hi =  c1 + c2 * t + c3 * r + c4 * t * r + c5 * Math.pow(t, 2) + c6 * Math.pow(r, 2)
        + c7 * Math.pow(t, 2) * r + c8 * t * Math.pow(r, 2) + c9 * Math.pow(t, 2) * Math.pow(r, 2);

    // "floor" HeatIndex and change type to "int"
    return (int)Math.floor(hi);
  }

  /**
   * WindChill.
   */
  public int getWindChill() {
    double t = (double)(this.getTemperature() * 9 / 5 + 32);  // exchanging Fahrenheit to Celsius
    double v = (double)this.getWindSpeed();

    double wc = 35.74 + 0.6215 * t - 35.75 * Math.pow(v, 0.16) + 0.4275 * t * Math.pow(v, 0.16);

    // "floor" WindChill and change type to "int"
    return (int)Math.floor(wc);
  }

  /**
   * Readings' output.
   */
  public String toString() {
    return "Reading: T = " + this.getTemperature()
      + ", D = " + this.getDewPoint()
      + ", v = " + this.getWindSpeed()
      + ", rain = " + this.getTotalRain();
  }
}
