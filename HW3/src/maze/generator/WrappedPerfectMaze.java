package maze.generator;

import java.util.List;

/**
 * Wrapped PerfectMaze.
 */
public class WrappedPerfectMaze extends AbstractGenerator {
  private final boolean isPerfect = true;

  public WrappedPerfectMaze(int row, int col, int remainWalls) {
    super(row, col, remainWalls);
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

    super.generateMaze(allEdges, isPerfect, 0);
  }
}
