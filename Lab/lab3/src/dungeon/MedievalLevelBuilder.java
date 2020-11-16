package dungeon;

/**
 *  Created by Chien-Yu.
 */
public class MedievalLevelBuilder {
  private int roomNumber;
  private int monsterNumber;
  private int treasureNumber;
  private Level targetLevel;

  /**
   * Constructor that takes the number of the level that is being created,
   * since most games have many levels.
   */
  public MedievalLevelBuilder(int levelNumber, int roomNumber,
                               int monsterNumber, int treasureNumber) {
    this.roomNumber = roomNumber;
    this.monsterNumber = monsterNumber;
    this.treasureNumber = treasureNumber;
    this.targetLevel = new Level(levelNumber);

    if (roomNumber < 0 || monsterNumber < 0 || treasureNumber < 0) {
      throw new IllegalArgumentException("Values expected to be greater than 0.");
    }
  }

  /**
   * Add rooms to target level.
   */
  public MedievalLevelBuilder addRoom(String description) {
    if (targetLevel.getRooms().size() >= roomNumber) {
      throw new IllegalStateException("Too many rooms are added to the level.");
    }
    targetLevel.addRoom(description);

    return this;
  }

  /**
   * Add Goblins with specified numbers to specified room.
   */
  public MedievalLevelBuilder addGoblins(int targetRoom, int gobNums) {
    Monster goblin = new Monster("goblin", "mischievous and very unpleasant,"
        + " vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",
        7);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getMonsters().length + gobNums > monsterNumber) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < gobNums; i++) {
      targetLevel.addMonster(targetRoom, goblin);
    }

    return this;
  }

  /**
   * Add Orc to specified room.
   */
  public MedievalLevelBuilder addOrc(int targetRoom) {
    Monster orc = new Monster("orc", "brutish, aggressive, "
        + "malevolent being serving evil", 20);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getMonsters().length + 1 > monsterNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addMonster(targetRoom, orc);

    return this;
  }


  /**
   * Add Ogres to specified room.
   */
  public MedievalLevelBuilder addOgre(int targetRoom) {
    Monster ogre = new Monster("ogre", "large, " +
        "hideous man-like being that likes to eat humans for lunch", 50);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getMonsters().length + 1 > monsterNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addMonster(targetRoom, ogre);

    return this;
  }

  /**
   * Add Human with detailed information to specified room.
   */
  public MedievalLevelBuilder addHuman(int targetRoom, String name,
                                             String description, int hitpoints) {
    Monster human = new Monster(name, description, hitpoints);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getMonsters().length + 1 > monsterNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addMonster(targetRoom, human);

    return this;
  }

  /**
   * Add Potion to specified room.
   */
  public MedievalLevelBuilder addPotion(int targetRoom) {
    Treasure potion = new Treasure("a healing potion", 1);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getTreasures().length + 1 > treasureNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addTreasure(targetRoom, potion);

    return this;
  }

  /**
   * Add specified number of Gold to specified room.
   */
  public MedievalLevelBuilder addGold(int targetRoom, int goldValue) {
    Treasure gold = new Treasure("pieces of gold", goldValue);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getTreasures().length + 1 > treasureNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addTreasure(targetRoom, gold);

    return this;
  }

  /**
   * Add specified Weapon to specified room.
   */
  public MedievalLevelBuilder addWeapon(int targetRoom, String whatWeapon) {
    Treasure weapon = new Treasure(whatWeapon, 10);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getTreasures().length + 1 > treasureNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addTreasure(targetRoom, weapon);

    return this;
  }

  /**
   * Add specified Special to specified room.
   */
  public MedievalLevelBuilder addSpecial(int targetRoom, String description, int value) {
    Treasure special = new Treasure(description, value);

    try {
      Room r = targetLevel.getRooms().get(targetRoom);
    } catch (IllegalStateException e) {
      throw e;
    }

    if (targetLevel.getRooms().get(targetRoom).getTreasures().length + 1 > treasureNumber) {
      throw new IllegalArgumentException();
    }

    targetLevel.addTreasure(targetRoom, special);

    return this;
  }

  /**
   * Build function.
   * Should return the level only after it has been completely constructed.
   */
  public Level build() {
    int totalMonster = 0;
    int totalTreasure = 0;
    for (int i = 0; i < targetLevel.getRooms().size(); i++) {
      totalMonster += targetLevel.getRooms().get(i).getMonsters().length;
      totalTreasure += targetLevel.getRooms().get(i).getTreasures().length;
    }

    if (targetLevel.getRooms().size() != roomNumber ||
        totalMonster != monsterNumber || totalTreasure != treasureNumber) {
      throw new IllegalStateException("Building process are not done yet.");
    }

    return targetLevel;
  }
}
