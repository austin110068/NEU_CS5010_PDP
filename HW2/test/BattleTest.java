import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import roleplaying.Battle;
import roleplaying.Clothing;
import roleplaying.Footwear;
import roleplaying.HandGear;
import roleplaying.HeadGear;
import roleplaying.Human;

public class BattleTest {
  private Battle match;
  private Human player1;
  private Human player2;
  private Human player3;
  private Human player4;
  private Clothing headObj;
  private Clothing headObj2;
  private Clothing headObj3;
  private Clothing headObj4;
  private Clothing headObj5;
  private Clothing handObj;
  private Clothing handObj2;
  private Clothing handObj3;
  private Clothing handObj4;
  private Clothing handObj5;
  private Clothing footObj;
  private Clothing footObj2;
  private Clothing footObj3;
  private Clothing footObj4;
  private Clothing footObj5;

  @Before
  public void setUp() {
    player1 = new Human(10, 12);
    player2 = new Human(9, 15);
    player3 = new Human(10, 10);
    player4 = new Human(10, 10);

    headObj = new HeadGear("Big", "StrawHat", 1, 0);
    headObj2 = new HeadGear("Super", "Helmets", 3, 0);
    headObj3 = new HeadGear("Cool", "Visors", 2, 0);
    headObj4 = new HeadGear("Dark", "BucketHat", 10, 0);
    headObj5 = new HeadGear("Vintage", "Cap", 7, 0);

    handObj = new HandGear("Multifunction", "Glove", 0, 3);
    handObj2 = new HandGear("Long", "Sword", 0, 3);
    handObj3 = new HandGear("Powerful", "Shield", 0, 7);
    handObj4 = new HandGear("Double-Handed", "Guns", 0, 11);
    handObj5 = new HandGear("Piercing", "Spear", 0, 13);

    footObj = new Footwear("Fireproof", "Boots", 1, 6);
    footObj2 = new Footwear("Modern", "Sneakers", 3, 4);
    footObj3 = new Footwear("Incredible", "Hoverboard", 10, 10);
    footObj4 = new Footwear("Invisible", "Heels", 20, 1);
    footObj5 = new Footwear("Ultimate", "WheelShoes", 13, 12);
  }

  @Test
  public void testMatchP1() {
    match = new Battle(headObj, headObj2, headObj5, handObj, handObj3, handObj4, footObj,
        footObj2, footObj3, footObj5, headObj, headObj3, headObj4, handObj2, handObj5, footObj,
        footObj2, footObj3, footObj4, footObj);

    assertEquals("Player 1 wins the match.", match.startBattle(player1, player2));
    assertEquals(50, match.getPlayer1().getTotalAttack());
    assertEquals(42, match.getPlayer1().getTotalDefense());
    assertEquals(36, match.getPlayer2().getTotalAttack());
    assertEquals(55, match.getPlayer2().getTotalDefense());
    assertEquals("Vintage Cap\n" +
        "Double-Handed, Powerful Guns\n" +
        "Ultimate, Incredible WheelShoes\n" +
        "-> Att: 50 / Def: 42", player1.toString(player1.getCurrentHeadGear(),
        player1.getCurrentHandGear(), player1.getCurrentFootwearGear()));
    assertEquals("Dark BucketHat\n" +
        "Long, Piercing Sword\n" +
        "Invisible, Incredible Heels\n" +
        "-> Att: 36 / Def: 55", player2.toString(player2.getCurrentHeadGear(),
        player2.getCurrentHandGear(), player2.getCurrentFootwearGear()));
  }

  @Test
  public void testMatchP2() {
    match = new Battle(headObj, headObj2, headObj5, handObj, handObj3, handObj4, footObj,
        footObj2, footObj3, footObj5, headObj, headObj3, headObj4, handObj2, handObj5, footObj,
        footObj2, footObj3, footObj4, footObj5);

    assertEquals("Player 2 wins the match.", match.startBattle(player1, player2));
    assertEquals(50, match.getPlayer1().getTotalAttack());
    assertEquals(42, match.getPlayer1().getTotalDefense());
    assertEquals(38, match.getPlayer2().getTotalAttack());
    assertEquals(58, match.getPlayer2().getTotalDefense());
    assertEquals("Vintage Cap\n" +
        "Double-Handed, Powerful Guns\n" +
        "Ultimate, Incredible WheelShoes\n" +
        "-> Att: 50 / Def: 42", player1.toString(player1.getCurrentHeadGear(),
        player1.getCurrentHandGear(), player1.getCurrentFootwearGear()));
    assertEquals("Dark BucketHat\n" +
        "Long, Piercing Sword\n" +
        "Invisible, Ultimate Heels\n" +
        "-> Att: 38 / Def: 58", player2.toString(player2.getCurrentHeadGear(),
        player2.getCurrentHandGear(), player2.getCurrentFootwearGear()));
  }

  @Test
  public void testMatchTie() {
    match = new Battle(headObj, headObj, headObj, handObj, handObj3, handObj4, footObj,
        footObj2, footObj, footObj, headObj, headObj, headObj, handObj3, handObj4, footObj,
        footObj2, footObj, footObj, footObj);

    assertEquals("It's a tie match.", match.startBattle(player3, player4));
    assertEquals(40, match.getPlayer1().getTotalAttack());
    assertEquals(13, match.getPlayer1().getTotalDefense());
    assertEquals(40, match.getPlayer2().getTotalAttack());
    assertEquals(13, match.getPlayer2().getTotalDefense());
    assertEquals("Big StrawHat\n" +
        "Double-Handed, Powerful Guns\n" +
        "Fireproof, Fireproof Boots\n" +
        "-> Att: 40 / Def: 13", player3.toString(player3.getCurrentHeadGear(),
        player3.getCurrentHandGear(), player3.getCurrentFootwearGear()));
    assertEquals("Big StrawHat\n" +
        "Powerful, Double-Handed Shield\n" +
        "Fireproof, Fireproof Boots\n" +
        "-> Att: 40 / Def: 13", player4.toString(player4.getCurrentHeadGear(),
        player4.getCurrentHandGear(), player4.getCurrentFootwearGear()));
  }
}