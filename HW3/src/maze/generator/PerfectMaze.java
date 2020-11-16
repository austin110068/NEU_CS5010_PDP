package maze.generator;

/**
 * A perfect maze is the simplest type of maze for a computer to generate and solve.
 * It is defined as a maze which has one and only one path from any point in the maze
 * to any other point in the maze. This means that the maze has no inaccessible sections,
 * no circular paths, no open areas.
 */
public class PerfectMaze extends AbstractGenerator {
  private final boolean isPerfect = true;

  public PerfectMaze(int row, int col, int remainWalls) {
    super(row, col, remainWalls);
  }

  @Override
  public void generate() {

    super.generateMaze(super.getAllEdges(), this.isPerfect, 0);
  }
}
