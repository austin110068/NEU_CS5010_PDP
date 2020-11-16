package maze.properties;

import java.util.ArrayList;
import java.util.List;
import maze.item.Gold;
import maze.item.Item;
import maze.item.Thief;

/**
 * Characteristics for cells.
 */
public class Cell {
  private final int[] location;
  private int CellID;
  private Item thief;
  private Item goldVal;
  private Cell upCell;
  private Cell downCell;
  private Cell leftCell;
  private Cell rightCell;
  private boolean isVisited;
  private List<String> directions;

  /**
   * Initializing location and cells around.
   */
  public Cell(int[] location) {
    if (location[0] < 0 || location[1] < 0) {
      throw new IllegalArgumentException("No cell here.");
    }

    this.location = location;
    this.upCell = null;
    this.downCell = null;
    this.leftCell = null;
    this.rightCell = null;
    this.isVisited = false;
  }

  /**
   * Get Cell location.
   */
  public int[] getLocation() {
    return this.location;
  }

  /**
   * Set Cell ID.
   */
  public void setID(int ID) {
    this.CellID = ID;
  }

  /**
   * Get Cell ID.
   */
  public int getID() {
    return this.CellID;
  }

  /**
   * Set thief.
   */
  public void setThief() {
    this.thief = new Thief();
  }

  /**
   * Get thief.
   */
  public Item getThief() {
    return this.thief;
  }

  /**
   * Set gold.
   */
  public void setGold(int gold) {
    this.goldVal = new Gold(gold);
  }

  /**
   * Get gold.
   */
  public Item getGold() {
    return this.goldVal;
  }

  /**
   * Remove gold.
   */
  public void removeGold() {
    this.goldVal = null;
  }

  /**
   * Set up cell.
   */
  public void setDirectionUp(Cell upCell) {
    this.upCell = upCell;
  }

  /**
   * Set down cell.
   */
  public void setDirectionDown(Cell downCell) {
    this.downCell = downCell;
  }

  /**
   * Set left cell.
   */
  public void setDirectionLeft(Cell leftCell) {
    this.leftCell = leftCell;
  }

  /**
   * Set right cell.
   */
  public void setDirectionRight(Cell rightCell) {
    this.rightCell = rightCell;
  }

  /**
   * Get up cell.
   */
  public Cell getUpCell() {
    return this.upCell;
  }

  /**
   * Get down cell.
   */
  public Cell getDownCell() {
    return this.downCell;
  }

  /**
   *  Get left cell.
   */
  public Cell getLeftCell() {
    return this.leftCell;
  }

  /**
   *  Get right cell.
   */
  public Cell getRightCell() {
    return this.rightCell;
  }

  /**
   * Get Cell directions.
   */
  public List<String> getDirections() {
    directions = new ArrayList<>();

    if (this.upCell != null) {
      this.directions.add("up");
    }

    if (this.downCell != null) {
      this.directions.add("down");
    }

    if (this.leftCell != null) {
      this.directions.add("left");
    }

    if (this.rightCell != null) {
      this.directions.add("right");
    }

    return this.directions;
  }
}
