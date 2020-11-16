import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import Coding.Coding;
import Coding.EncodingAndDecoding;
import org.junit.Before;
import org.junit.Test;

/**
 * A Junit test class for Coding interface.
 */
public class EncodingAndDecodingTest {
  Coding huff1;
  Coding huff2;
  Coding huff3;
  FrequencyTable ft1;
  FrequencyTable ft2;
  FrequencyTable ft3;

  @Before
  public void setUp() {
    ft1 = new FrequencyTable("SHE SELLS SEA SHELLS BY THE SEA SHORE");
    ft2 = new FrequencyTable("ABCDEFGHIJKLMNOP");
    ft3 = new FrequencyTable("Test Special Character: :'?! &()*$");
    huff1 = new EncodingAndDecoding(ft1.getFrequencyTable(), 2);
    huff2 = new EncodingAndDecoding(ft2.getFrequencyTable(), 16);
    huff3 = new EncodingAndDecoding(ft3.getFrequencyTable(), 10);
  }

  @Test
  public void testHuff1() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put(' ', "110");
    expectedCT.put('A', "0001");
    expectedCT.put('B', "00100");
    expectedCT.put('R', "00110");
    expectedCT.put('S', "10");
    expectedCT.put('T', "00111");
    expectedCT.put('E', "111");
    expectedCT.put('H', "010");
    expectedCT.put('Y', "0000");
    expectedCT.put('L', "011");
    expectedCT.put('O', "00101");

    huff1.startEncode();
    assertEquals(expectedCT, huff1.getCodingTable());

    huff1.startDecode("010001010110000");  // HOLY
    assertEquals("HOLY", huff1.getDecodeContent());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testHuff1IllegalPassword() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put(' ', "110");
    expectedCT.put('A', "0001");
    expectedCT.put('B', "00100");
    expectedCT.put('R', "00110");
    expectedCT.put('S', "10");
    expectedCT.put('T', "00111");
    expectedCT.put('E', "111");
    expectedCT.put('H', "010");
    expectedCT.put('Y', "0000");
    expectedCT.put('L', "011");
    expectedCT.put('O', "00101");

    huff1.startEncode();
    huff1.startDecode("2");
  }

  @Test(expected = StringIndexOutOfBoundsException.class)
  public void testHuff1IllegalPassword2() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put(' ', "110");
    expectedCT.put('A', "0001");
    expectedCT.put('B', "00100");
    expectedCT.put('R', "00110");
    expectedCT.put('S', "10");
    expectedCT.put('T', "00111");
    expectedCT.put('E', "111");
    expectedCT.put('H', "010");
    expectedCT.put('Y', "0000");
    expectedCT.put('L', "011");
    expectedCT.put('O', "00101");

    huff1.startEncode();
    huff1.startDecode("1101");
  }

  @Test
  public void testHuff2() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put('A', "0");
    expectedCT.put('B', "1");
    expectedCT.put('C', "2");
    expectedCT.put('D', "3");
    expectedCT.put('E', "4");
    expectedCT.put('F', "5");
    expectedCT.put('G', "6");
    expectedCT.put('H', "7");
    expectedCT.put('I', "8");
    expectedCT.put('J', "9");
    expectedCT.put('K', "a");
    expectedCT.put('L', "b");
    expectedCT.put('M', "c");
    expectedCT.put('N', "d");
    expectedCT.put('O', "e");
    expectedCT.put('P', "f");

    huff2.startEncode();
    assertEquals(expectedCT, huff2.getCodingTable());

    huff2.startDecode("0123456789abcdef");  // A~Z
    assertEquals("ABCDEFGHIJKLMNOP", huff2.getDecodeContent());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testHuff2IllegalPassword() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put('A', "0");
    expectedCT.put('B', "1");
    expectedCT.put('C', "2");
    expectedCT.put('D', "3");
    expectedCT.put('E', "4");
    expectedCT.put('F', "5");
    expectedCT.put('G', "6");
    expectedCT.put('H', "7");
    expectedCT.put('I', "8");
    expectedCT.put('J', "9");
    expectedCT.put('K', "a");
    expectedCT.put('L', "b");
    expectedCT.put('M', "c");
    expectedCT.put('N', "d");
    expectedCT.put('O', "e");
    expectedCT.put('P', "f");

    huff2.startEncode();
    huff2.startDecode("g");
    huff2.startDecode("-1");
    huff2.startDecode(" ");
  }

  @Test
  public void testHuff3() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put(' ', "2");
    expectedCT.put('a', "0");
    expectedCT.put('!', "30");
    expectedCT.put('c', "47");
    expectedCT.put('C', "38");
    expectedCT.put('$', "31");
    expectedCT.put('e', "1");
    expectedCT.put('&', "32");
    expectedCT.put('\'', "33");
    expectedCT.put('h', "41");
    expectedCT.put('(', "34");
    expectedCT.put(')', "35");
    expectedCT.put('i', "42");
    expectedCT.put('*', "36");
    expectedCT.put('l', "43");
    expectedCT.put('p', "44");
    expectedCT.put('r', "48");
    expectedCT.put('s', "45");
    expectedCT.put('S', "39");
    expectedCT.put('T', "40");
    expectedCT.put('t', "49");
    expectedCT.put(':', "46");
    expectedCT.put('?', "37");

    huff3.startEncode();
    assertEquals(expectedCT, huff3.getCodingTable());

    huff3.startDecode("343804033454641040374635");  // (CaT's:haT?:)
    assertEquals("(CaT's:haT?:)", huff3.getDecodeContent());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testHuff3IllegalPassword() {
    Map<Character, String> expectedCT = new HashMap<>();
    expectedCT.put(' ', "2");
    expectedCT.put('a', "0");
    expectedCT.put('!', "30");
    expectedCT.put('c', "47");
    expectedCT.put('C', "38");
    expectedCT.put('$', "31");
    expectedCT.put('e', "1");
    expectedCT.put('&', "32");
    expectedCT.put('\'', "33");
    expectedCT.put('h', "41");
    expectedCT.put('(', "34");
    expectedCT.put(')', "35");
    expectedCT.put('i', "42");
    expectedCT.put('*', "36");
    expectedCT.put('l', "43");
    expectedCT.put('p', "44");
    expectedCT.put('r', "48");
    expectedCT.put('s', "45");
    expectedCT.put('S', "39");
    expectedCT.put('T', "40");
    expectedCT.put('t', "49");
    expectedCT.put(':', "46");
    expectedCT.put('?', "37");

    huff3.startEncode();
    huff3.startDecode("A");
    huff3.startDecode("a");
    huff3.startDecode("0");
  }
}