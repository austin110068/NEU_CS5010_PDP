import static org.junit.Assert.assertEquals;
import listadt.ListADT;
import listadt.ListADTImpl;
import listadt.ListADTUtilities;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing Utilities.
 */
public class ListUtilitiesTest<T> {
  ListADTUtilities<Integer> obj;
  ListADT<Integer> target;

  @Before
  public void setUp() {
    obj = new ListADTUtilities<>();
    target = new ListADTImpl<>();
  }

  @Test
  public void testToList() {
    target.addFront(Integer.valueOf(5));
    target.addFront(Integer.valueOf(4));
    target.addFront(Integer.valueOf(3));
    target.addFront(Integer.valueOf(2));
    target.addFront(Integer.valueOf(1));

    Integer[] list = new Integer[]{1, 2, 3, 4, 5};

    assertEquals(target.toString(), obj.toList(list).toString());
  }
}