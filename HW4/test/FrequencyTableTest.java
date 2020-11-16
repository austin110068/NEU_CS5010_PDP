import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * A Junit test class for FrequencyTable interface.
 */
public class FrequencyTableTest {
  FrequencyTable ft1;
  FrequencyTable ft2;
  FrequencyTable ft3;

  @Before
  public void setUp() {
    ft1 = new FrequencyTable("SHE SELLS SEA SHELLS BY THE SEA SHORE");
    ft2 = new FrequencyTable("ABCDEFGHIJKLMNOP");
    ft3 = new FrequencyTable("Test Special Character: :'?! &()*$");
  }

  @Test
  public void testFT1() {
    Map<Character, Integer> expected = new HashMap<>();
    expected.put('S', 8);
    expected.put('H', 4);
    expected.put('E', 7);
    expected.put(' ', 7);
    expected.put('A', 2);
    expected.put('O', 1);
    expected.put('B', 1);
    expected.put('R', 1);
    expected.put('T', 1);
    expected.put('Y', 1);
    expected.put('L', 4);

    assertEquals(expected, ft1.getFrequencyTable());
  }

  @Test
  public void testFT2() {
    Map<Character, Integer> expected = new HashMap<>();
    expected.put('A', 1);
    expected.put('B', 1);
    expected.put('C', 1);
    expected.put('D', 1);
    expected.put('E', 1);
    expected.put('F', 1);
    expected.put('G', 1);
    expected.put('H', 1);
    expected.put('I', 1);
    expected.put('J', 1);
    expected.put('K', 1);
    expected.put('L', 1);
    expected.put('M', 1);
    expected.put('N', 1);
    expected.put('O', 1);
    expected.put('P', 1);

    assertEquals(expected, ft2.getFrequencyTable());
  }

  @Test
  public void testFT3() {
    Map<Character, Integer> expected = new HashMap<>();
    expected.put(' ', 4);
    expected.put('a', 3);
    expected.put('!', 1);
    expected.put('c', 2);
    expected.put('C', 1);
    expected.put('$', 1);
    expected.put('e', 3);
    expected.put('&', 1);
    expected.put('\'', 1);
    expected.put('h', 1);
    expected.put('(', 1);
    expected.put(')', 1);
    expected.put('i', 1);
    expected.put('*', 1);
    expected.put('l', 1);
    expected.put('p', 1);
    expected.put('r', 2);
    expected.put('s', 1);
    expected.put('S', 1);
    expected.put('T', 1);
    expected.put('t', 2);
    expected.put(':', 2);
    expected.put('?', 1);

    assertEquals(expected, ft3.getFrequencyTable());
  }
}