package maze.generator;

/**
 * In the non-perfect maze, each cell in the grid also represent a location in the maze,
 * but there can be multiple paths between any two cells.
 * This form is useful in several applications.
 * Computer games, for instance, use this kind of maze to create a map of the world
 * by giving locations in the maze different characteristics.
 */
public class RoomMaze extends AbstractGenerator {
  private final boolean isPerfect = false;
  private final int remainWalls;

  public RoomMaze(int row, int col, int remainWalls) {
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
    super.generateMaze(this.getAllEdges(), isPerfect, this.remainWalls);
  }
}
