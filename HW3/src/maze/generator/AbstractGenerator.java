package maze.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import maze.properties.Cell;

/**
 * Abstract class for Generator.
 */
abstract class AbstractGenerator implements Generator {
  private final int numOfRows;
  private final int numOfCols;
  private final int remainWalls;
  private final List<int[]> allEdges = new ArrayList<>();
  private final Cell[][] map;
  private List<int[]> showGold = new ArrayList<>();
  private List<int[]> showThief = new ArrayList<>();

  /**
   * Initialize Maze's Info.
   */
  public AbstractGenerator(int row, int col, int remainWalls) {
    if (row <= 0 || col <= 0) {
      throw new IllegalArgumentException("A maze should have positive number of row and columns.");
    }

    this.numOfRows = row;
    this.numOfCols = col;
    this.remainWalls = remainWalls;
    this.map = new Cell[row][col];
    this.setUp(row, col);

  }

  @Override
  public int getNumOfRows() {
    return this.numOfRows;
  }

  @Override
  public int getNumOfCols() {
    return this.numOfCols;
  }

  @Override
  public int getRemainWalls() {
    return this.remainWalls;
  }

  @Override
  public List<int[]> getAllEdges() {
    return this.allEdges;
  }

  @Override
  public void addThief() {
    Random random = new Random();
    random.setSeed(1);

    int numOfThiefRoom = (int)(0.1 * this.numOfRows * this.numOfCols);
    Set<int[]> thiefRoom = new HashSet<>();
    while (thiefRoom.size() < numOfThiefRoom) {
      int i = random.nextInt(this.numOfRows);
      int j = random.nextInt(this.numOfCols);
      thiefRoom.add(new int[]{i, j});
      showThief.add(new int[]{i, j});
    }

    for (int[] item : thiefRoom) {
      this.map[item[0]][item[1]].setThief();
    }
  }

  @Override
  public List<int[]> getThiefLoc() {
    return this.showThief;
  }

  @Override
  public void addGold() {
    Random random = new Random();
    random.setSeed(2);

    int numOfGoldRoom = (int)(0.2 * this.numOfRows * this.numOfCols);
    Set<int[]> goldRoom = new HashSet<>();
    while (goldRoom.size() < numOfGoldRoom) {
      int i = random.nextInt(this.numOfRows);
      int j = random.nextInt(this.numOfCols);
      goldRoom.add(new int[]{i, j});
      showGold.add(new int[]{i, j});
    }

    for (int[] item : goldRoom) {
      int gold = createGold();
      this.map[item[0]][item[1]].setGold(gold);
    }
  }

  @Override
  public List<int[]> getGoldLoc() {
    return this.showGold;
  }
  /**
   * Create certain amount of gold.
   */
  private int createGold() {
    Random random = new Random();
    random.setSeed(3);

    // Create gold between 0~10.
    return random.nextInt(10);
  }

  @Override
  public void setUp(int row, int col) {
    int LocID = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        Cell newCell = new Cell(new int[]{i, j});
        newCell.setID(LocID);
        this.map[i][j] = newCell;
        LocID += 1;
      }
    }

    /**
     * Initializing all edges.
     */
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col - 1; j++) {
        this.allEdges.add(new int[]{i, j, i, j + 1});
      }
    }
    for (int j = 0; j < col; j++) {
      for (int i = 0; i < row - 1; i++) {
        this.allEdges.add(new int[]{i, j, i + 1, j});
      }
    }
  }

  @Override
  public void generateMaze(List<int[]> allEdges, boolean isPerfect, int numOfRemainWalls) {
    Random random = new Random();
    random.setSeed(4);

    /**
     * Initializing sets for each cell.
     */
    List<Set<Integer>> edgeSet = new ArrayList<>();
    for (int i = 0; i < this.numOfRows; i++) {
      for (int j = 0; j < this.numOfCols; j++) {
        Set<Integer> newSet = new HashSet<>();
        newSet.add(this.getMap()[i][j].getID());
        edgeSet.add(newSet);
      }
    }

    /**
     * Start cutting edges and put them into sets.
     */
    int totalCounter = 0;
    int totalCells = this.numOfRows * this.numOfCols;
    // allEdges = removeEdges + savedEdges
    // We should remove totalCells - 1 edges.
    while (totalCounter < totalCells - 1) {
      int[] rmd = this.allEdges.get(random.nextInt(this.allEdges.size()));
      Cell targetOne = this.map[rmd[0]][rmd[1]];
      Cell targetTwo = this.map[rmd[2]][rmd[3]];
      Set<Integer> setTargetOne = edgeSet.get(targetOne.getID());
      Set<Integer> setTargetTwo = edgeSet.get(targetTwo.getID());

      if (!(setTargetOne.equals(setTargetTwo))) {
        /**
         * When encountering distinct sets, remove the edge from allEdge and update the current set.
         */
        setTargetOne.addAll(setTargetTwo);
        for (Integer index : setTargetOne) {
          edgeSet.set(index, setTargetOne);
        }
        this.allEdges.remove(rmd);
        totalCounter += 1;

        /**
         * Updating each cell's direction since there's a new direction for them.
         */
        if (rmd[0] < rmd[2] || rmd[0] > rmd[2]) {
          targetOne.setDirectionDown(targetTwo);
          targetTwo.setDirectionUp(targetOne);
        } else {
          targetOne.setDirectionRight(targetTwo);
          targetTwo.setDirectionLeft(targetOne);
        }
      }
    }

    /**
     * If it's a RoomMaze, we should keep removing edges until we reach the given remaining walls.
     */
    if (!isPerfect) {
      while (this.allEdges.size() > numOfRemainWalls) {
        /**
         * Remove edges from savedEdge.
         */
        int[] rmd = this.allEdges.get(random.nextInt(this.allEdges.size()));
        Cell remainOne = this.map[rmd[0]][rmd[1]];
        Cell remainTwo = this.map[rmd[2]][rmd[3]];

        this.allEdges.remove(rmd);

        /**
         * Updating each cell's direction since there's a new direction for them.
         */
        if (rmd[0] < rmd[2] || rmd[0] > rmd[2]) {
          remainOne.setDirectionDown(remainTwo);
          remainTwo.setDirectionUp(remainOne);
        } else {
          remainOne.setDirectionRight(remainTwo);
          remainTwo.setDirectionLeft(remainOne);
        }
      }
    }
    this.addGold();
    this.addThief();
  }

  @Override
  public Cell[][] getMap() {
    return this.map;
  }

  public abstract void generate();
}
