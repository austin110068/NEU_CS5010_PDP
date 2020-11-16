package roleplaying;

import java.util.ArrayList;
import java.util.List;

public class Battle {
  private Human player1, player2;
  private List<Clothing> optionsForP1, optionsForP2;

  public Battle (Clothing... options) {
    this.optionsForP1 = new ArrayList<Clothing>();
    this.optionsForP2 = new ArrayList<Clothing>();

    int counter = 0;
    for (Clothing option : options) {
      if (counter < 10) {
        counter++;
        this.optionsForP1.add(option);
      } else if (counter < 20) {
        counter++;
        this.optionsForP2.add(option);
      } else {
        break;
      }
    }
  }

  public String startBattle(Human p1, Human p2) {
    this.player1 = p1;
    this.player2 = p2;
    for (Clothing gear : optionsForP1) {
      p1.pickUpHeadGear(gear);
      p1.pickUpHandGear(gear);
      p1.pickUpFootwearGear(gear);
    }
    for (Clothing gear : optionsForP2) {
      p2.pickUpHeadGear(gear);
      p2.pickUpHandGear(gear);
      p2.pickUpFootwearGear(gear);
    }

    int p1Damage = p1.getTotalAttack() - p2.getTotalDefense();
    int p2Damage = p2.getTotalAttack() - p1.getTotalDefense();

    if (p1Damage > p2Damage) {
      return "Player 1 wins the match.";
    } else if (p1Damage < p2Damage){
      return "Player 2 wins the match.";
    } else {
      return "It's a tie match.";
    }
  }

  public Human getPlayer1() {
    return this.player1;
  }

  public Human getPlayer2() {
    return this.player2;
  }
}
