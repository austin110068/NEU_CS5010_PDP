package weather;

import java.util.Scanner;

/**
 * Created by Chien-Yu.
 */

public class Main {
  /**
  * Given a list of arguments from the command line input,
  * populates them to the template specified,
  * and return the output in String form.
  *
  * @param args a list of arguments from the command line input
  */
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    int airTemperature = myObj.nextInt();
    int dewPoint = myObj.nextInt();
    int windSpeed = myObj.nextInt();
    int totalRain = myObj.nextInt();

    WeatherReading main = new WeatherReading(airTemperature, dewPoint, windSpeed, totalRain);

    System.out.println(main.toString());
  }
}
