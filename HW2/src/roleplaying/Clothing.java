package roleplaying;

/**
 * Interface for three types of equipments.
 */
public interface Clothing {
  /**
   * Get item's adjective;
   */
  String getAdj();

  /**
   * Get item's noun;
   */
  String getNoun();

  /**
   * Get item's defense value;
   */
  int getDefense();

  /**
   * Get item's attack value;
   */
  int getAttack();

  /**
   * Get item's type;
   */
  String getType();
}
