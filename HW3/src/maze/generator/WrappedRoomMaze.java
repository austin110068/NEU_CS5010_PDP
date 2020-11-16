package maze.generator;

import java.util.List;

/**
 * Wrapped-RoomMaze.
 */
public class WrappedRoomMaze extends AbstractGenerator {
  private final boolean isPerfect = false;
  private final int remainWalls;

  public WrappedRoomMaze(int row, int col, int remainWalls) {
    super(row, col, remainWalls);

    /**
     * 0 <= removeEdges <= savedEdges.
     */
    if (remainWalls < 0 || remainWalls > super.getAllEdges().size() - row * col + 1) {
      throw new IllegalArgumentException("You have an Invalid remaining walls for a room maze.");
    }

    this.remainWalls = remainWalls;
  }

  @Override
  public void generate() {
    /**
     * Since it's a wrapped maze, we should add all border edges into allEdges while generating.
     */
    List<int[]> allEdges = super.getAllEdges();
    int row = super.getNumOfRows();
    int col = super.getNumOfCols();
    for (int i = 0; i < row; i++) {
      allEdges.add(new int[]{i, col - 1, i, 0});
    }
    for (int j = 0; j < col; j++) {
      allEdges.add(new int[]{row - 1, j, 0, j});
    }

    super.generateMaze(allEdges, isPerfect, this.remainWalls);
  }
}
