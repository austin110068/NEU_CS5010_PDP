import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import roleplaying.Clothing;
import roleplaying.HandGear;


public class HandGearTest {
  private Clothing obj;

  @Before
  public void setUp() {
    obj = new HandGear("Multifunction", "Glove", 0, 3);
  }

  @Test
  public void testCharacteristics() {
    assertEquals("Multifunction", obj.getAdj());
    assertEquals("Glove", obj.getNoun());
    assertEquals(0, obj.getDefense());
    assertEquals(3, obj.getAttack());
  }

  @Test
  public void testInvalidDefense() {
    obj = new HandGear("Long", "Sword", 5, 3);
    assertEquals(0, obj.getDefense());
  }
}