package maze.properties;

import maze.item.Item;

/**
 * Creating a player.
 */
public class Player {
  private int currentGold;

  /**
   * Each new player has no gold at first.
   */
  public Player() {
    this.currentGold = 0;
  }

  /**
   * Get player's current gold.
   */
  public int getCurrentGold() {
    return this.currentGold;
  }

  /**
   * Player pick up gold.
   */
  public void receiveGold(Item gold) {
    System.out.println("You've found gold!");
    this.currentGold = gold.takeEffect(this.currentGold);
  }

  /**
   * Player get robbed.
   */
  public void looseGold(Item thief) {
    System.out.println("You've been robbed!");
    this.currentGold = thief.takeEffect(this.currentGold);
  }
}
