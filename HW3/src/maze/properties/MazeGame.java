package maze.properties;

import java.util.List;

/**
 * Creating a game.
 */
public class MazeGame {
  private Player player;
  private final int[] finishingPoint;
  private int[] playerLocation;
  private final Cell[][] map;
  private boolean isFinished = false;

  /**
   * Initializing game's info.
   */
  public MazeGame(int[] startingPoint, int[] finishingPoint, Cell[][] map) {
    // Starting point out of bound
    if (startingPoint[0] < 0 || startingPoint[0] >= map.length
        || startingPoint[1] < 0 || startingPoint[1] >= map[0].length) {
      throw new IllegalArgumentException("Starting point doesn't exist on the map.");
    }

    // Finishing point out of bound
    if (finishingPoint[0] < 0 || finishingPoint[0] >= map.length
        || finishingPoint[1] < 0 || finishingPoint[1] >= map[0].length) {
      throw new IllegalArgumentException("Finishing point doesn't exist on the map.");
    }

    this.player = new Player();
    this.playerLocation = startingPoint;
    this.finishingPoint = finishingPoint;
    this.map = map;
  }

  /**
   * Get player's location.
   */
  public int[] getPlayerLocation() {
    return this.playerLocation;
  }

  /**
   * Get player's current gold.
   */
  public int getCurrentGold() {
    return this.player.getCurrentGold();
  }

  /**
   * Get player's direction options.
   */
  public List<String> getOptions() {
    return this.map[this.playerLocation[0]][this.playerLocation[1]].getDirections();
  }

  /**
   * Let player move.
   * Then update the game info (get gold, get robbed...)
   */
  public void move(String nextMove) {
    // If nextMove not in the options.
    if (!this.getOptions().contains(nextMove)) {
      throw new IllegalArgumentException("Invalid input for next direction.");
    }

    int[] loc = this.getPlayerLocation();
    Cell currCell = this.map[loc[0]][loc[1]];
    Cell newCell;
    switch (nextMove) {
      case "up":
        newCell = currCell.getUpCell();
        break;
      case "down":
        newCell = currCell.getDownCell();
        break;
      case "left":
        newCell = currCell.getLeftCell();
        break;
      case "right":
        newCell = currCell.getRightCell();
        break;
      default:
        newCell = currCell;
        System.out.println("Something's wrong while moving to the next direction.");
    }

    update(newCell);
  }

  /**
   * Update info.
   */
  public void update(Cell newCell) {
    this.playerLocation = newCell.getLocation();


    // Check gold or not.
    if (newCell.getGold() != null) {
      this.player.receiveGold(newCell.getGold());
      newCell.removeGold();
    }

    // Check thief or not.
    if (newCell.getThief() != null) {
      this.player.looseGold(newCell.getThief());
    }

    System.out.println("You have " + this.getCurrentGold() + " Gold now.");
    // Check finish or not.
    if (this.playerLocation[0] == this.finishingPoint[0]
        && this.playerLocation[1] == this.finishingPoint[1]) {
      this.isFinished = true;
    }
  }

  /**
   * Check player arrived the finish point or not.
   */
  public boolean checkFinished() {
    return this.isFinished;
  }
}
