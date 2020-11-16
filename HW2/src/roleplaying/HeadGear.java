package roleplaying;

/**
 * Creating HeadGear class for further implementation of concrete class.
 */
public class HeadGear implements Clothing{
  private String adjective;
  private String noun;
  private String type;
  private int defense;
  private int attack;

  public HeadGear(String adjective, String noun, int defense, int attack) {
    this.adjective = adjective;
    this.noun = noun;
    this.defense = defense;
    this.attack = 0;
    this.type = "HeadGear";
  }

  @Override
  public String getAdj() {
    return this.adjective;
  }

  @Override
  public String getNoun() {
    return this.noun;
  }

  @Override
  public int getDefense() {
    return this.defense;
  }

  @Override
  public int getAttack() {
    return this.attack;
  }

  @Override
  public String getType() {
    return this.type;
  }
}
