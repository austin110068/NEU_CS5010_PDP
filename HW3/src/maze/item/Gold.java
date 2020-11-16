package maze.item;

/**
 * Player gets Gold.
 */
public class Gold extends AbstractItem {
  public Gold(int g) {
    super(g, 0);

  }

  @Override
  public int takeEffect(int currentGold) {
    return currentGold + this.goldVal;
  }
}
