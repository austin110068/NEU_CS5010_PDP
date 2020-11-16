import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import roleplaying.Clothing;
import roleplaying.Footwear;

public class FootwearTest {
  private Clothing obj;

  @Before
  public void setUp() {
    obj = new Footwear("Fireproof", "Boots", 1, 6);
  }

  @Test
  public void testCharacteristics() {
    assertEquals("Fireproof", obj.getAdj());
    assertEquals("Boots", obj.getNoun());
    assertEquals(1, obj.getDefense());
    assertEquals(6, obj.getAttack());
  }
}