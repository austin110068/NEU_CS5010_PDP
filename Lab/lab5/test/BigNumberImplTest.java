import static org.junit.Assert.assertEquals;
import bignumber.BigNumberImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing big number implementation.
 */
public class BigNumberImplTest {
  BigNumberImpl obj;
  BigNumberImpl objBig;

  @Before
  public void setUp() {
    objBig = new BigNumberImpl("8439218801072071490007697342667740830987036744088140652" +
        "887263262791573603242695416632423718762610810597454795874992598245675878231" +
        "170087820296462513062151001915052812466094165387548674112830847072356271120" +
        "176769050311966414860124273158849713349639856746278961899348470380980357986" +
        "778511438839667407450843475705180004152102225251906442202177515521891284577" +
        "9698705085508208507277863171553109865579265193016969566979289829265882564705" +
        "848618863160367270742969754940238700054624004659315355613843176614869");
    obj = new BigNumberImpl("32411");
  }

  @Test
  public void testNumberLength() {
    assertEquals(5, obj.length());
    assertEquals(500, objBig.length());
  }

  @Test
  public void testLeftShift() {
    obj.shiftLeft(1);
    assertEquals("324110", obj.toString());
    obj.shiftLeft(2);
    assertEquals("32411000", obj.toString());
    obj.shiftLeft(-7);
    assertEquals("3", obj.toString());
    obj.shiftLeft(0);
    assertEquals("3", obj.toString());
    obj.shiftLeft(-1);
    assertEquals("0", obj.toString());
    obj.shiftLeft(-7);
    assertEquals("0", obj.toString());
    obj.shiftLeft(3);
    assertEquals("0", obj.toString());
  }

  @Test
  public void testRightShift() {
    obj.shiftRight(1);
    assertEquals("3241", obj.toString());
    obj.shiftRight(-2);
    assertEquals("324100", obj.toString());
    obj.shiftRight(6);
    assertEquals("0", obj.toString());
    obj.shiftRight(1);
    assertEquals("0", obj.toString());
    obj.shiftRight(-5);
    assertEquals("0", obj.toString());
  }

  @Test
  public void testAddDigit() {
    obj.addDigit(5);
    assertEquals("32416", obj.toString());
    obj.addDigit(9);
    assertEquals("32425", obj.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTwoDigits() {
    obj.addDigit(12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddNegDigit() {
    obj.addDigit(-9);
  }

  @Test
  public void testGetDigitAt() {
    assertEquals(1, obj.getDigitAt(0));
    assertEquals(3, obj.getDigitAt(4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetInvalidDigit() {
    obj.getDigitAt(6);
  }

  @Test
  public void testCopy() {
    assertEquals("8439218801072071490007697342667740830987036744088140652" +
        "887263262791573603242695416632423718762610810597454795874992598245675878231" +
        "170087820296462513062151001915052812466094165387548674112830847072356271120" +
        "176769050311966414860124273158849713349639856746278961899348470380980357986" +
        "778511438839667407450843475705180004152102225251906442202177515521891284577" +
        "9698705085508208507277863171553109865579265193016969566979289829265882564705" +
        "848618863160367270742969754940238700054624004659315355613843176614869"
        , objBig.copy().toString());
  }

  @Test
  public void testAdd() {
    assertEquals("8439218801072071490007697342667740830987036744088140652" +
        "887263262791573603242695416632423718762610810597454795874992598245675878231" +
        "170087820296462513062151001915052812466094165387548674112830847072356271120" +
        "176769050311966414860124273158849713349639856746278961899348470380980357986" +
        "778511438839667407450843475705180004152102225251906442202177515521891284577" +
        "9698705085508208507277863171553109865579265193016969566979289829265882564705" +
        "848618863160367270742969754940238700054624004659315355613843176647280"
        , obj.add(objBig).toString());
  }

  @Test
  public void testCompare() {
    assertEquals(-1, obj.compareTo(objBig));
    assertEquals(0, objBig.compareTo(objBig));
    assertEquals(1, objBig.compareTo(obj));
  }
}