package roleplaying;

import java.util.ArrayList;
import java.util.List;

/**
 * Creating Human class for further new players implementations.
 */
public class Human {
  private final int defense;
  private final int attack;
  private List<Clothing> currentHandGear;
  private List<Clothing> currentHeadGear;
  private List<Clothing> currentFootwearGear;

  private final int MAX_FOOT = 2;

  /**
   * Have basic attack and defense value.
   * Have 3 list for three types of clothing respectively.
   */
  public Human(int attack, int defense) {
    this.attack = attack;
    this.defense = defense;
    this.currentHeadGear = new ArrayList<Clothing>();
    this.currentHandGear = new ArrayList<Clothing>();
    this.currentFootwearGear = new ArrayList<Clothing>();
  }

  /**
   * Compare attack.
   */
  public void pickUpHeadGear(Clothing target) {
    if (target.getType() == "HeadGear") {
      //check strength before adding into list
      if (this.currentHeadGear.isEmpty()) {
        this.currentHeadGear.add(target);
      } else {
        Clothing current = this.currentHeadGear.get(0);
        if (current.getDefense() < target.getDefense()) {
          this.currentHeadGear.set(0, target);
        }
      }
    }
  }

  /**
   * Compare defense.
   */
  public void pickUpHandGear(Clothing target) {
    if (target.getType() == "HandGear") {
      //check strength before adding into list
      if (this.currentHandGear.size() < 2) {
        this.currentHandGear.add(target);
      } else {
        Clothing tmp = target;
        int minVal = target.getAttack();
        int minValIndex = 0;
        for (Clothing gear : this.currentHandGear) {
          if (gear.getAttack() < minVal) {
            tmp = gear;
            minVal = gear.getAttack();
            minValIndex = this.currentHandGear.indexOf(gear);
          }
        }

        if (tmp != target) {
          this.currentHandGear.set(minValIndex, target);
        }
      }
    }
  }

  /**
   *  Compare the total strength, then compare attack.
   */
  public void pickUpFootwearGear(Clothing target) {
    if (target.getType() == "Footwear") { //enum
      //check strength before adding into list
      if (this.currentFootwearGear.size() < 2) {
        this.currentFootwearGear.add(target);
      } else {
        Clothing tmp = target;
        int minVal = target.getAttack() + target.getDefense();
        int minAtt = target.getAttack();
        int minValIndex = 0;
        for (Clothing gear : this.currentFootwearGear) {
          if (gear.getAttack() + gear.getDefense() < minVal) {
            tmp = gear;
            minVal = gear.getAttack() + gear.getDefense();
            minAtt = gear.getAttack();
            minValIndex = this.currentFootwearGear.indexOf(gear);
          } else if (gear.getAttack() + gear.getDefense() == minVal
              && gear.getAttack() < minAtt) {
            tmp = gear;
            minVal = gear.getAttack() + gear.getDefense();
            minAtt = gear.getAttack();
            minValIndex = this.currentFootwearGear.indexOf(gear);
          }
        }

        if (tmp != target) {
//          System.out.println("test");
          this.currentFootwearGear.set(minValIndex, target);
        }
      }
    }
  }

  /**
   * Return basic attack value;
   */
  public int getBasicAttack() {
    return this.attack;
  }

  /**
   * Return basic defense value;
   */
  public int getBasicDefense() {
    return this.defense;
  }

  /**
   * Return total attack value;
   */
  public int getTotalAttack() {
    int total = this.attack;

    for (Clothing gear : this.currentHeadGear) {
      total += gear.getAttack();
    }

    for (Clothing gear : this.currentHandGear) {
      total += gear.getAttack();
    }

    for (Clothing gear : this.currentFootwearGear) {
      total += gear.getAttack();
    }

    return total;
  }

  /**
   * Return total defense value;
   */
  public int getTotalDefense() {
    int total = this.defense;

    for (Clothing gear : this.currentHeadGear) {
      total += gear.getDefense();
    }

    for (Clothing gear : this.currentHandGear) {
      total += gear.getDefense();
    }

    for (Clothing gear : this.currentFootwearGear) {
      total += gear.getDefense();
    }

    return total;
  }

  /**
   * Return current HeadGear equipment.
   */
  public List<Clothing> getCurrentHeadGear() {
    return this.currentHeadGear;
  }

  /**
   * Return current HandGear equipment.
   */
  public List<Clothing> getCurrentHandGear() {
    return this.currentHandGear;
  }

  /**
   * Return current Footwear equipment.
   */
  public List<Clothing> getCurrentFootwearGear() {
    return this.currentFootwearGear;
  }

  /**
   * Return current equipments that the player is wearing.
   * Followed by the total attack/defense value.
   */
  public String toString(List<Clothing> head, List<Clothing> hand, List<Clothing> foot) {
    String combinedAdj = "";
    for (Clothing cur : hand) {
      combinedAdj += cur.getAdj();
      combinedAdj += ", ";
    }
    combinedAdj = combinedAdj.substring(0, combinedAdj.length()-2);

    String combinedAdj2 = "";
    for (Clothing cur : foot) {
      combinedAdj2 += cur.getAdj();
      combinedAdj2 += ", ";
    }
    combinedAdj2 = combinedAdj2.substring(0, combinedAdj2.length()-2);

    return head.get(0).getAdj() + " " + head.get(0).getNoun() + "\n"
        + combinedAdj + " " + hand.get(0).getNoun() + "\n"
        + combinedAdj2 + " " + foot.get(0).getNoun() + "\n"
        + "-> " + "Att: " + this.getTotalAttack() + " / Def: " + this.getTotalDefense();
  }
}
