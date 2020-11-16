import static org.junit.Assert.assertEquals;
import maze.item.Gold;
import maze.item.Thief;
import maze.properties.Player;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  Player player;

  @Before
  public void setUp() {
    player = new Player();
  }

  @Test
  public void testGetCurrentGold() {
    assertEquals(0, player.getCurrentGold());
  }

  @Test
  public void testAddGold() {
    Gold gold = new Gold(5);
    player.receiveGold(gold);
    assertEquals(5, player.getCurrentGold());
  }

  @Test
  public void testGetRobbed() {
    Gold gold = new Gold(5);
    player.receiveGold(gold);
    Thief thief = new Thief();
    player.looseGold(thief);
    assertEquals(4, player.getCurrentGold());
  }

}