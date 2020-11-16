package maze.item;

/**
 * Abstract class for Item.
 */
public class AbstractItem implements Item {
  protected final int goldVal;
  protected final double factor;

  /**
   * Initialize gold amount and factor of different items.
   */
  public AbstractItem(int gold, double factor) {
    this.goldVal = gold;
    this.factor = factor;
  }

  @Override
  public int takeEffect(int currentGold) {
    return 0;
  }
}
