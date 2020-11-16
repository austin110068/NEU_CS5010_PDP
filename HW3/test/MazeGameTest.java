import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import maze.generator.Generator;
import maze.generator.PerfectMaze;
import maze.properties.MazeGame;
import org.junit.Before;
import org.junit.Test;

public class MazeGameTest {
  MazeGame newGame;
  int[] startingPoint;
  int[] finishingPoint;
  Generator maze;

  @Before
  public void setUp() {
    startingPoint = new int[]{0, 0};
    finishingPoint = new int[]{3, 5};
    maze = new PerfectMaze(4, 6, 0);
    maze.generate();
    newGame = new MazeGame(startingPoint, finishingPoint, maze.getMap());
  }

  @Test
  public void testPlayerLocation() {
    assertEquals(0, newGame.getPlayerLocation()[0]);
    assertEquals(0, newGame.getPlayerLocation()[1]);
    newGame.move("down");
    assertEquals(1, newGame.getPlayerLocation()[0]);
    assertEquals(0, newGame.getPlayerLocation()[1]);
    newGame.move("right");
    assertEquals(1, newGame.getPlayerLocation()[0]);
    assertEquals(1, newGame.getPlayerLocation()[1]);
  }

  @Test
  public void testOptions() {
    List<String> test = new ArrayList<>();
    test.add("down");
    assertEquals(test, newGame.getOptions());
  }

  @Test
  public void testCurrentGold() {
    newGame.move("down");
    assertEquals(4, newGame.getCurrentGold());
  }

  @Test
  public void testFinished() {
    assertFalse(newGame.checkFinished());
    finishingPoint = new int[]{1, 0};
    maze = new PerfectMaze(4, 6, 0);
    maze.generate();
    newGame = new MazeGame(startingPoint, finishingPoint, maze.getMap());

    newGame.move("down");
    assertTrue(newGame.checkFinished());
  }
}