import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import roleplaying.Clothing;
import roleplaying.Footwear;
import roleplaying.HandGear;
import roleplaying.HeadGear;
import roleplaying.Human;

public class HumanTest {
  private Human player1;
  private Clothing headObj;
  private Clothing headObj2;
  private Clothing headObj3;
  private Clothing handObj;
  private Clothing handObj2;
  private Clothing handObj3;
  private Clothing handObj4;
  private Clothing footObj;
  private Clothing footObj2;
  private Clothing footObj3;
  private Clothing footObj4;
  private Clothing headTmp;
  private Clothing handTmp;
  private Clothing handTmp2;
  private Clothing footTmp;
  private Clothing footTmp2;


  @Before
  public void setUp() {
    player1 = new Human(10, 12);

    headObj = new HeadGear("Big", "StrawHat", 1, 0);
    headObj2 = new HeadGear("Super", "Helmets", 3, 0);
    headObj3 = new HeadGear("Cool", "Visors", 2, 0);

    handObj = new HandGear("Multifunction", "Glove", 0, 3);
    handObj2 = new HandGear("Long", "Sword", 0, 3);
    handObj3 = new HandGear("Powerful", "Shield", 0, 7);
    handObj4 = new HandGear("Double-Handed", "Guns", 0, 11);

    footObj = new Footwear("Fireproof", "Boots", 1, 6);
    footObj2 = new Footwear("Modern", "Sneakers", 3, 4);
    footObj3 = new Footwear("Incredible", "Hoverboard", 10, 10);
    footObj4 = new Footwear("Invisible", "Heels", 20, 1);

    player1.pickUpHeadGear(headObj);
    player1.pickUpHandGear(handObj);
    player1.pickUpHandGear(handObj2);
    player1.pickUpFootwearGear(footObj);
    player1.pickUpFootwearGear(footObj2);

    headTmp = player1.getCurrentHeadGear().get(0);
    handTmp = player1.getCurrentHandGear().get(0);
    handTmp2 = player1.getCurrentHandGear().get(1);
    footTmp = player1.getCurrentFootwearGear().get(0);
    footTmp2 = player1.getCurrentFootwearGear().get(1);
  }

  @Test
  public void testPickUpGear() {
    // Test HeadGear
    assertEquals("Big StrawHat", headTmp.getAdj() + " " + headTmp.getNoun());

    // Test HandGear
    assertEquals("Multifunction Glove", handTmp.getAdj() + " " + handTmp.getNoun());
    assertEquals("Long Sword", handTmp2.getAdj() + " " + handTmp2.getNoun());

    // Test Footwear
    assertEquals("Fireproof Boots", footTmp.getAdj() + " " + footTmp.getNoun());
    assertEquals("Modern Sneakers", footTmp2.getAdj() + " " + footTmp2.getNoun());

    // Test Values
    assertEquals(10, player1.getBasicAttack());
    assertEquals(12, player1.getBasicDefense());
    assertEquals(26, player1.getTotalAttack());
    assertEquals(17, player1.getTotalDefense());
  }

  @Test
  public void testPickUpExtraGear() {
    // Test exchanging HeadGear for greater defense value
    player1.pickUpHeadGear(headObj2);
    headTmp = player1.getCurrentHeadGear().get(0);
    assertEquals("Super Helmets", headTmp.getAdj() + " " + headTmp.getNoun());
    assertEquals(12, player1.getBasicDefense());
    assertEquals(19, player1.getTotalDefense());

    // Test don't exchange HeadGear when getting lower defense value
    player1.pickUpHeadGear(headObj3);
    headTmp = player1.getCurrentHeadGear().get(0);
    assertEquals("Super Helmets", headTmp.getAdj() + " " + headTmp.getNoun());
    assertEquals(12, player1.getBasicDefense());
    assertEquals(19, player1.getTotalDefense());

    // Test exchanging HandGear for greater attack value
    player1.pickUpHandGear(handObj3);
    handTmp = player1.getCurrentHandGear().get(0);
    assertEquals("Powerful Shield", handTmp.getAdj() + " " + handTmp.getNoun());
    assertEquals(10, player1.getBasicAttack());
    assertEquals(30, player1.getTotalAttack());
    player1.pickUpHandGear(handObj4);
    handTmp2 = player1.getCurrentHandGear().get(1);
    assertEquals("Double-Handed Guns", handTmp2.getAdj() + " " + handTmp2.getNoun());
    assertEquals(10, player1.getBasicAttack());
    assertEquals(38, player1.getTotalAttack());

    // Test exchanging Footwear for greater strength, attack is preferred over defense
    // ex: currentFootwear[0] = att:4/def:3, target = att:6/def:1 -> exchanged

    // If two items in currentFootwear have the same strength sum, higher attack will be picked
    // ex: currentFootwear[0] = att:4/def:3, currentFootwear[1] = att:5/def:2
    // target = att:10/def:10 -> currentFootwear[1] will be exchanged
    player1.pickUpFootwearGear(footObj3);
    footTmp2 = player1.getCurrentFootwearGear().get(1);
    assertEquals("Incredible Hoverboard",
        footTmp2.getAdj() + " " + footTmp2.getNoun());
    assertEquals(10, player1.getBasicAttack());
    assertEquals(12, player1.getBasicDefense());
    assertEquals(44, player1.getTotalAttack());
    assertEquals(26, player1.getTotalDefense());

    player1.pickUpFootwearGear(footObj4);
    footTmp = player1.getCurrentFootwearGear().get(0);
    assertEquals("Invisible Heels", footTmp.getAdj() + " " + footTmp.getNoun());
    assertEquals(10, player1.getBasicAttack());
    assertEquals(12, player1.getBasicDefense());
    assertEquals(39, player1.getTotalAttack());
    assertEquals(45, player1.getTotalDefense());
  }

  @Test
  public void testToString() {
    assertEquals("Big StrawHat\n" + "Multifunction, Long Glove\n"
        + "Fireproof, Modern Boots\n" + "-> Att: 26 / Def: 17",
        player1.toString(player1.getCurrentHeadGear(),
            player1.getCurrentHandGear(), player1.getCurrentFootwearGear()));
  }
}