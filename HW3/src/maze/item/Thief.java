package maze.item;

/**
 * Player gets robbed.
 * Gold amount will decrease 10%.
 */
public class Thief extends AbstractItem {
  public Thief() {
    // 10% loss
    super(0, 0.1f);
  }

  @Override
  public int takeEffect(int currentGold) {
    return (int) (currentGold * (1 - this.factor));
  }
}
