import dungeon.Level;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * MedievalLevelBuilderTest.
 */
public class MedievalLevelBuilderTest {
  private Level mlb;

  @Before
  public void setUp() {
    mlb = Level.getBuilder(1, 2, 8, 4)
        .addRoom("First Room.")
        .addRoom("Second Room.")
        .addGoblins(0, 5)
        .addOrc(1)
        .addOgre(1)
        .addHuman(1, "Player 1", "Newbie", 100)
        .addPotion(0)
        .addGold(1, 10)
        .addSpecial(1, "Fireball", 1000)
        .addWeapon(1, "Sword")
        .build();
  }

  @Test
  public void testLevel() {
    assertEquals(mlb.getLevelNumber(), 1);
  }
}

//    assertEquals(mlb..getMonsters()[0].getName(), "Goblin");