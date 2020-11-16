import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import java.util.Random;
import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;
import org.junit.Test;

/**
 * Test case for LookAndSayIterator.
 */
public class LookAndSayIteratorTest {
  @Test
  public void testDefaultSeed() {
    RIterator<BigInteger> iterator = new LookAndSayIterator();
    BigInteger previous = new BigInteger("1");
    iterator.next(); // burn off the first one
    while (iterator.hasNext()) {
      BigInteger b = iterator.next();
      assertTrue("Number " + previous.toString() + " cannot be read as " + b.toString(),
          decode(previous, b));
      previous = b;
    }
    previous = iterator.next();
    assertTrue("The iterator ended but the last number was not more than " + "100 digits long",
        previous.toString().length() > 100);
  }

  @Test
  public void testCustomValidSeed() {
    Random r = new Random(10);
    for (int j = 0; j < 200; j++) {
      int seed = r.nextInt(20000);
      if (Integer.toString(seed).indexOf('0') == -1) {
        RIterator<BigInteger> iterator = new LookAndSayIterator(new BigInteger("" + seed));
        BigInteger previous = new BigInteger("" + seed);
        iterator.next(); // burn off the first one
        while (iterator.hasNext()) {
          BigInteger b = iterator.next();
          assertTrue("Number " + previous.toString() + " cannot be read as " + b.toString(),
              decode(previous, b));
          previous = b;
        }
        previous = iterator.next();
        assertTrue("The iterator ended but the last number was not more than " + "100 digits long",
            previous.toString().length() > 100);
      }
    }
  }


  private boolean decode(BigInteger previous, BigInteger current) {
    String currentString = current.toString();
    StringBuilder soln = new StringBuilder();

    for (int i = 0; i < currentString.length(); i += 2) {
      int freq = Character.digit(currentString.charAt(i), 10);
      int num = Character.digit(currentString.charAt(i + 1), 10);
      for (int j = 0; j < freq; j++) {
        soln.append(num);
      }
    }
    return soln.toString().equals(previous.toString());
  }

  @Test
  public void testBasicReverse() {
    BigInteger seed = new BigInteger("123");
    // seed
    // 123
    RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
    // seed, iterator
    //    123
    BigInteger num1 = iterator.next();
    // seed,num1   iterator
    // 123          111213
    BigInteger num2 = iterator.next();
    // seed,num1       num2        iterator
    //  123          111213        31121113
    BigInteger num3 = iterator.next();
    // seed,num1   num2   num3     iterator
    // 123         111213 31121113 1321123113
    BigInteger num4 = iterator.next();
    // seed,num1.  num2.     num3      num4        iterator
    // 123         111213    31121113. 1321123113. 1113122112132113
    iterator.prev();
    // seed,num1.    num2.     num3        num4,iterator   unused return value by prev()
    // 123           111213    31121113.   1321123113.     1113122112132113
    assertEquals("2nd call to prev() should return same as last call to next()",
        num4, iterator.prev());
    // seed num1.    num2.     num3,iterator      num4,returned by prev()
    // 123           111213    31121113.           1321123113              1113122112132113
    assertEquals("prev() not as expected", num3, iterator.prev());
    assertEquals("prev() not as expected", num2, iterator.prev());
    assertEquals("prev() not as expected", num1, iterator.prev());
    assertFalse("hasPrevious() should return false", iterator.hasPrevious());
  }
}