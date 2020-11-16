import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import maze.generator.Generator;
import maze.generator.PerfectMaze;
import maze.generator.RoomMaze;
import org.junit.Before;
import org.junit.Test;

public class AbstractGeneratorTest {
  Generator obj1;
  Generator obj2;

  @Before
  public void setUp() {
    obj1 = new PerfectMaze(4, 6, 0);
    obj2 = new RoomMaze(5, 3, 4);
    obj1.generate();
    obj2.generate();
  }

  @Test
  public void testInfo() {
    assertEquals(4, obj1.getNumOfRows());
    assertEquals(6, obj1.getNumOfCols());

    assertEquals(5, obj2.getNumOfRows());
    assertEquals(3, obj2.getNumOfCols());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInfo() {
    Generator obj3 = new PerfectMaze(-1, -2, 4);
  }

  @Test
  public void testRemainWalls() {
    assertEquals(4, obj2.getRemainWalls());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemainWalls() {
    Generator obj3 = new PerfectMaze(5, 3, 9);  // 0~8
  }

  @Test
  public void testGoldLoc() {
    assertEquals(2, obj1.getGoldLoc().get(0)[0]);
    assertEquals(0, obj1.getGoldLoc().get(0)[1]);
    assertEquals(3, obj1.getGoldLoc().get(1)[0]);
    assertEquals(1, obj1.getGoldLoc().get(1)[1]);
    assertEquals(1, obj1.getGoldLoc().get(2)[0]);
    assertEquals(0, obj1.getGoldLoc().get(2)[1]);
    assertEquals(3, obj1.getGoldLoc().get(3)[0]);
    assertEquals(3, obj1.getGoldLoc().get(3)[1]);
  }

  @Test
  public void testThiefLoc() {
    assertEquals(2, obj1.getGoldLoc().get(0)[0]);
    assertEquals(0, obj1.getGoldLoc().get(0)[1]);
    assertEquals(3, obj1.getGoldLoc().get(1)[0]);
    assertEquals(1, obj1.getGoldLoc().get(1)[1]);
  }
}