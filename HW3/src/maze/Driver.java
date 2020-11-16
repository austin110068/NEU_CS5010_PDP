package maze;

import java.util.List;
import java.util.Scanner;
import maze.generator.Generator;
import maze.generator.PerfectMaze;
import maze.generator.RoomMaze;
import maze.generator.WrappedPerfectMaze;
import maze.generator.WrappedRoomMaze;
import maze.properties.MazeGame;

/**
 * Created by Chien-Yu.
 */
public class Driver {
  private static int row;
  private static int col;
  private static int numOfRemainWalls;
  private static boolean isPerfect;
  private static boolean isWrapped;
  private static int[] startingPoint;
  private static int[] finishingPoint;
  private static Generator maze;
  private static MazeGame newGame;

  /**
   * We have 4 steps to finish the whole processing.
   * 1. Feed the map input.
   * 2. Use the input to build the maze. (4 types)
   * 3. Build a game in specific maze type.
   * 4. Start playing.
   */
  public static void main(String[] args) {
    initializeMazeInfo();
    buildMaze();
    buildGame();
    playGame();
  }

  /**
   * Initializing Maze info.
   */
  private static void initializeMazeInfo() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("---------- Maze Game ----------");
    System.out.println("\nPlease insert your Maze's information.");
    System.out.println("Rows: ");
    row = getNumber(scanner);
    System.out.println("Columns: ");
    col = getNumber(scanner);
    System.out.println("Is the maze perfect? (Y/N): ");
    isPerfect = getBoolean(scanner);
    if (!isPerfect) {
      // max num for saved edges
      int upperbound = (row - 1) * col + (col - 1) * row - row * col + 1;
      System.out.println("Remaining walls(0 - " + upperbound + "): ");
      numOfRemainWalls = getNumber(scanner);
    }
    System.out.println("Is the maze wrapped? (Y/N): ");
    isWrapped = getBoolean(scanner);
    System.out.println("\tReceiving inputs......");
  }

  /**
   * Build Maze.
   */
  private static void buildMaze() {
    System.out.println("\tBuilding maze......");

    if (isPerfect && isWrapped) {
      maze = new WrappedPerfectMaze(row, col, 0);
    } else if (isPerfect) {
      maze = new PerfectMaze(row, col, 0);
    } else if (isWrapped) {
      maze = new WrappedRoomMaze(row, col, numOfRemainWalls);
    } else {
      maze = new RoomMaze(row, col, numOfRemainWalls);
    }
    maze.generate();
    System.out.println("\tYou have successfully built a maze.\n");
  }

  /**
   * Build Game.
   */
  private static void buildGame() {
    System.out.println("---------- Let's build a game! ----------");
    System.out.println("\t\t---------------------------");
    System.out.println("\t\t| Maze Info               |");
    System.out.println("\t\t| Row : " + row + "                 |");
    System.out.println("\t\t| Col : " + col + "                 |");

    if (isPerfect) {
      System.out.println("\t\t| Perfect : True          |");
    } else {
      System.out.println("\t\t| Perfect : False         |");
    }

    if (isWrapped) {
      System.out.println("\t\t| Wrapped : True          |");
    } else {
      System.out.println("\t\t| Wrapped : False         |");
    }
    System.out.println("\t\t---------------------------");

    Scanner scanner = new Scanner(System.in);
    int startRow;
    int startCol;
    int finishRow;
    int finishCol;
    System.out.println("Insert a row for starting point: ");
    startRow = getNumber(scanner);
    System.out.println("Insert a column for starting point: ");
    startCol = getNumber(scanner);
    System.out.println("Insert a row for finishing point: ");
    finishRow = getNumber(scanner);
    System.out.println("Insert a column for finishing point: ");
    finishCol = getNumber(scanner);
    startingPoint = new int[]{startRow, startCol};
    finishingPoint = new int[]{finishRow, finishCol};

    newGame = new MazeGame(startingPoint, finishingPoint, maze.getMap());

    System.out.println("You have successfully built a game.\n");
  }

  /**
   * Game time!
   */
  private static void playGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("---------- Game Time ----------");
    while (true) {
      System.out.println("You're currently at: [" + newGame.getPlayerLocation()[0] + " "
                          + newGame.getPlayerLocation()[1] + "]");
      String nextMoveOptions = "Where do you want to go?  ---->  ";
      List<String> directions = newGame.getOptions();
      for (String dir : directions) {
        nextMoveOptions += dir;
        nextMoveOptions += ", ";
      }
      nextMoveOptions = nextMoveOptions.substring(0, nextMoveOptions.length()-2);
      System.out.println(nextMoveOptions);
      System.out.println("Move to: ");
      String nextMove = getDirection(scanner);

      newGame.move(nextMove);
      if (newGame.checkFinished()) {
        System.out.println("------------------------------------");
        System.out.println("|   Hooray! You've find an exit!   |");
        System.out.println("------------------------------------");
        System.out.println("\tResult: ");
        System.out.println("\tYou've collected " + newGame.getCurrentGold() + " Gold in total.");
        System.exit(0);
      }
    }
  }

  /**
   * Helper function to get number from scanner.
   */
  private static int getNumber(Scanner scanner) {
    String answer = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    int number;
    while (true) {
      try {
        number = Integer.parseInt(answer);
        if (number < 0) {
          System.out.println("\tInvalid input. Please insert an integer greater than 0.");
          answer = scanner.nextLine();
        } else {
          break;
        }
      } catch (IllegalArgumentException e) {
        System.out.println("\tInvalid input. Please insert an integer greater than 0.");
        answer = scanner.nextLine();
      }
    }
    return number;
  }

  /**
   * Helper function to get boolean from scanner.
   */
  private static boolean getBoolean(Scanner scanner) {
    String answer = scanner.nextLine().toUpperCase().replaceAll(" ", "");
    while (!(answer.equals("Y")) && !(answer.equals("N"))) {
      System.out.println("\tInvalid input. Please insert (Y/N).");
      answer = scanner.nextLine().toUpperCase().replaceAll(" ", "");
    }
    return (answer.equals("Y"));
  }

  /**
   * Helper function to get direction from scanner.
   */
  private static String getDirection(Scanner scanner) {
    String direction = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    while (!(direction.equals("up")) && !(direction.equals("down"))
            && !(direction.equals("left")) && !(direction.equals("right"))) {
      System.out.println("\tInvalid input. Please insert (up/down/left/right).");
      direction = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    }

    return direction;
  }
}
