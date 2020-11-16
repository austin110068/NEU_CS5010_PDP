import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;
import BirdClassification.Bird;
import BirdClassification.Driver;
import BirdClassification.Duck;
import BirdClassification.Emus;
import BirdClassification.GrayParrot;
import BirdClassification.GreakAuk;
import BirdClassification.Hawks;
import BirdClassification.hornedPuffin;
import org.junit.Before;
import org.junit.Test;

/**
 * Driver test code;
 */
public class test {
  private Driver obj;
  private Bird hawks;
  private Bird emus;
  private Bird grayParrot;
  private Bird greatAuk;
  private Bird duck;
  private Bird hornedPuffin;

  /**
   * Setting up target bird classes that need to classify.
   */
  @Before
  public void setUp() {
    obj = new Driver();
    hawks = new Hawks("PreyBirds", "Hawk", "Meat",
        false, 2);
    emus = new Emus("FlightlessBirds", "Emus", "Insects",
        true, 0);
    grayParrot = new GrayParrot("Parrots", "Gray Parrot", "Nuts",
        false, 2);
    greatAuk = new GreakAuk("ShoreBirds", "Great Auk", "Fish",
        true, 0);
    duck  = new Duck("Waterfowl", "Duck", "Worms",
        false, 2);
    hornedPuffin = new hornedPuffin("ShoreBirds", "Horned Puffin", "Fish",
        false, 2);
  }

  /**
   * Testing if Hawk is successfully rescued by checking the given information.
   * All other birds will be tested as the same way.
   */
  @Test
  public void testHawk() {
    obj.rescue(hawks);

    assertEquals(obj.getConservatory().get(1).getAviaryMap().get(1).getClassification(),
        "PreyBirds");
    assertEquals(obj.getConservatory().get(1).getAviaryMap().get(1).getType(),
        "Hawk");
    assertEquals(obj.getConservatory().get(1).getAviaryMap().get(1).eat(),
        "Meat");
    assertFalse(obj.getConservatory().get(1).getAviaryMap().get(1).getIsExtinct());
    assertEquals(obj.getConservatory().get(1).getAviaryMap().get(1).getWings(),
        2);
  }

  /**
   * Testing if different kind of birds are rescued and allocated in appropriate position.
   */
  @Test
  public void testRescueBird() {
    obj.rescue(emus);
    obj.rescue(hawks);
    obj.rescue(duck);
    obj.rescue(grayParrot);
    obj.rescue(greatAuk);
    obj.rescue(hornedPuffin);

    assertEquals(obj.getConservatory().get(1).getAviaryMap().get(1), hawks);
    assertEquals(obj.getConservatory().get(2).getAviaryMap().get(1), duck);
    assertEquals(obj.getConservatory().get(3).getAviaryMap().get(1), grayParrot);
    assertEquals(obj.getConservatory().get(3).getAviaryMap().get(2), hornedPuffin);
  }

  /**
   * Testing when exclusive aviary is full.
   */
  @Test
  public void testMaxNumBirdForExclusiveAviary() {
    obj.rescue(hawks);
    obj.rescue(hawks);
    obj.rescue(hawks);
    obj.rescue(hawks);
    obj.rescue(hawks);
    obj.rescue(hawks);


    assertEquals(obj.getConservatory().get(1).getAviaryMap().get(5), hawks);
    assertEquals(obj.getConservatory().get(2).getAviaryMap().get(1), hawks);
  }

  /**
   * Testing whether food is added properly.
   */
  @Test
  public void testFood() {
    obj.rescue(hawks);
    Map<String, Integer> food = new HashMap<>();
    food.put("Meat", 1);
    assertEquals(obj.getConservatory().get(1).getFood(), food);

    obj.rescue(hawks);
    food.put("Meat", 2);
    assertEquals(obj.getConservatory().get(1).getFood(), food);

    obj.rescue(duck);
    Map<String, Integer> food1 = new HashMap<>();
    food1.put("Worms", 1);
    assertEquals(obj.getConservatory().get(2).getFood(), food1);
  }

  /**
   * Testing if there's not enough aviary for new birds.
   */
  @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughAviary() throws Exception {
    for(int i = 0; i < 100; i++) {
      obj.rescue(hawks);
    }

    obj.rescue(hawks);
  }

  /**
   * Testing whether birds are allocated in proper position with sign at every aviary.
   */
  @Test
  public void testPrintMapAndSign() {
    String expected = "Aviary Location: 1 -> PreyBirds";
    expected += "Hawk";

    String expected2 = "Aviary Location: 2 -> Waterfowl";
    expected2 += "Duck";
    expected += expected2;

    obj.rescue(hawks);
    obj.rescue(duck);

    assertEquals(obj.findBird(), expected);
  }

  /**
   * Testing whether birds are listed in alphabetical order in index.
   */
  @Test
  public void testPrintIndex() {
    String expected = "Conservatory Index:";
    expected += "There's a Duck in aviary [3]";
    expected += "There's a Hawk in aviary [1, 2]";

    for(int i = 0; i < 6; i++)
      obj.rescue(hawks);
    obj.rescue(duck);

    assertEquals(obj.printConservatory(), expected);
  }
}