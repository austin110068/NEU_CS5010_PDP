import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import roleplaying.Clothing;
import roleplaying.HeadGear;

public class HeadGearTest {
  private Clothing obj;

  @Before
  public void setUp() {
    obj = new HeadGear("Big", "StrawHat", 1, 0);
  }

  @Test
  public void testCharacteristics() {
    assertEquals("Big", obj.getAdj());
    assertEquals("StrawHat", obj.getNoun());
    assertEquals(1, obj.getDefense());
    assertEquals(0, obj.getAttack());
  }

  @Test
  public void testInvalidAttack() {
    obj = new HeadGear("Super", "Helmets", 5, 6);
    assertEquals(0, obj.getAttack());
  }
}