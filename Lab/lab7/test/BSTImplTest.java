import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import bst.BST;
import bst.BSTImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing BST functions.
 */
public class BSTImplTest {
  BST<Integer> obj;

  @Before
  public void setUp() {
    obj = new BSTImpl<Integer>();
  }

  @Test
  public void testAdd() {
    obj.add(Integer.valueOf(5));
    obj.add(Integer.valueOf(4));
    obj.add(Integer.valueOf(6));
    obj.add(Integer.valueOf(1));

    assertTrue(obj.present(Integer.valueOf(5)));
    assertTrue(obj.present(Integer.valueOf(4)));
    assertTrue(obj.present(Integer.valueOf(6)));
    assertTrue(obj.present(Integer.valueOf(1)));
    assertFalse(obj.present(Integer.valueOf(7)));

    assertEquals("[1 4 5 6]", obj.toString());
    assertEquals(4, obj.size());
  }

  @Test
  public void testHeight() {
    obj.add(Integer.valueOf(5));
    obj.add(Integer.valueOf(4));
    obj.add(Integer.valueOf(6));
    obj.add(Integer.valueOf(1));

    assertEquals(3, obj.height());
  }

  @Test
  public void testMaxMin() {
    obj.add(Integer.valueOf(5));
    obj.add(Integer.valueOf(4));
    obj.add(Integer.valueOf(6));
    obj.add(Integer.valueOf(1));

    assertEquals(Integer.valueOf(1), obj.minimum());
    assertEquals(Integer.valueOf(6), obj.maximum());
  }

  @Test
  public void testPresent() {
    Random generator = new Random();
    BST<Integer> tree = new BSTImpl<>();
    List<Integer> expected = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      expected.add(generator.nextInt(1000) + 1000);
    }

    for (Integer e : expected) {
      tree.add(e);
    }

    for (int i = -1000; i <= 1000; i++) {
      assertEquals(expected.contains(i), tree.present(i));
    }
  }

  @Test(timeout = 3000)
  public void testTraversals() {
    BST<Integer> tree = new BSTImpl<>();
    tree.add(7);
    tree.add(3);
    tree.add(10);
    tree.add(1);
    tree.add(8);
    tree.add(9);
    tree.add(12);

    assertEquals("[7 3 1 10 8 9 12]", tree.preOrder());
    assertEquals("[1 3 7 8 9 10 12]", tree.inOrder());
    assertEquals("[1 3 9 8 12 10 7]", tree.postOrder());
  }

}