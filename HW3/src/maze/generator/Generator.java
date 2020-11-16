package maze.generator;

import java.util.List;
import maze.properties.Cell;

/**
 * Generate a maze.
 * We have 4 maze here, which are Perfect / Room with Wrapped / not-Wrapped mazes.
 */
public interface Generator {
  /**
   * Get row number.
   */
  int getNumOfRows();

  /**
   * Get col number.
   */
  int getNumOfCols();

  /**
   * Get remaining walls.
   */
  int getRemainWalls();

  /**
   * Add gold.
   */
  void addGold();

  /**
   * Show gold location for test case.
   */
  List<int[]> getGoldLoc();

  /**
   * Add thief.
   */
  void addThief();

  /**
   * Show gold location for test case.
   */
  List<int[]> getThiefLoc();

  /**
   * Get row number.
   */
  List<int[]> getAllEdges();

  /**
   * Generate a maze after giving inputs.
   */
  void generate();

  /**
   * Start generating the maze.
   */
  void generateMaze(List<int[]> allEdges, boolean isPerfect, int numOfRemainWalls);

  /**
   * Initialing the maze.
   * Setting up all the edges.
   */
  void setUp(int row, int col);

  /**
   * Getting the maze map.
   */
  Cell[][] getMap();
}
