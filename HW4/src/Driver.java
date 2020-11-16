import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Coding.Coding;
import Coding.EncodingAndDecoding;

/**
 * Created by Chien-Yu.
 */
public class Driver {
  private static String message;
  private static File file;
  private static boolean isTerminal;
  private static FrequencyTable ft;
  private static int base;
  private static Coding huffmanCoding;

  public static void main(String[] args) throws Exception {
    gettingInput();
    initializeFrequencyTable();
    encodingPhase();
    decodingPhase();
  }

  public static void gettingInput() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("------------------Huffman Code------------------");
    System.out.println("How do you want to build coding table? (Terminal / File) : ");
    isTerminal = getInputType(scanner);
    if (isTerminal) {
      System.out.println("\nPlease insert the message that you want to encode.");
      System.out.println("Message: ");
      message = scanner.nextLine();
    } else {
      System.out.println("\nDo you want to read file or create a new file? (Read / Write) : ");
      boolean isRead = getFileAction(scanner);
      if (isRead) {
        System.out.println("\nPlease insert the file name that you want to encode.");
        System.out.println("File name(ex: Huffman.txt): ");
        String fileName = scanner.nextLine();
        file = new File(fileName);
      } else {
        try {
          System.out.println("\nPlease insert your filename: (test.txt) : ");
          while (true) {
            file = new File(getFileName(scanner));

            if (file.createNewFile()) {
              FileWriter myWriter = new FileWriter(file.getName());
              System.out.println("Please insert your message: ");
              myWriter.write(scanner.nextLine());
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
              break;
            } else {
              System.out.println("File already exists. Please use another filename.");
            }
          }
        } catch (IOException e) {
          System.out.println("An error occurred while writing file.");
          e.printStackTrace();
        }
      }
    }

    System.out.println("\nPlease insert number of symbol sets(base) " +
        "for your Huffman Tree. (2~16) : ");
    base = Integer.parseInt(scanner.nextLine());
    System.out.println("\nGetting input......\n");
  }

  public static void initializeFrequencyTable() throws Exception {
    System.out.println("------------------Frequency Table------------------");
    System.out.println("Initializing Frequency Table......");
    if (isTerminal) {
      ft = new FrequencyTable(message);
    } else {
      ft = new FrequencyTable(file);
    }

    System.out.println("\nHere's your Frequency Table:");
    System.out.println(ft.getFrequencyTable());
  }

  public static void encodingPhase() {
    System.out.println("\n------------------Encoding Phase------------------");
    System.out.println("Start encoding your input......");
    huffmanCoding = new EncodingAndDecoding(ft.getFrequencyTable(), base);
    huffmanCoding.startEncode();
    System.out.println("\nHere's your Coding Table:");
    System.out.println(huffmanCoding.getCodingTable());
  }

  public static void decodingPhase() throws IOException {
    Scanner scanner = new Scanner(System.in);
    String password = "";
    System.out.println("\n------------------Decoding Phase------------------");
    try {
      System.out.println("Please insert your filename that you want to decode: (test.txt) : ");
      while (true) {
        file = new File(getFileName(scanner));

        if (file.createNewFile()) {
          FileWriter myWriter = new FileWriter(file.getName());
          System.out.println("\nPlease insert your encoding password according " +
              "to the coding table: ");
          password = getPassword(scanner);
          myWriter.write(password);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
          break;
        } else {
          System.out.println("File already exists. Please use another filename.");
        }
      }
    } catch (IOException e) {
      System.out.println("An error occurred while writing file.");
      e.printStackTrace();
    }

    System.out.println("\nStart decoding your password......");
    huffmanCoding.startDecode(password);
    System.out.println("\nHere's your decoded message: ");
    System.out.println(huffmanCoding.getDecodeContent());

    System.out.println("\nPlease insert your filename for your result: (test.txt) : ");
    file = new File(getFileName(scanner));
    if (file.createNewFile()) {
      FileWriter myWriter = new FileWriter(file.getName());
      myWriter.write(huffmanCoding.getDecodeContent());
      myWriter.close();
      System.out.println("Successfully create result file.");
    } else {
      System.out.println("File already exists. Please use another filename.");
    }
  }

  private static String getFileName(Scanner scanner) {
    String fileName = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    while (!(fileName.endsWith(".txt"))) {
      System.out.println("\tInvalid file. Please implement in txt file");
      fileName = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    }

    return fileName;
  }

  /**
   * Helper function to get direction from scanner.
   */
  private static boolean getFileAction(Scanner scanner) {
    String action = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    while (!(action.equals("read")) && !(action.equals("write"))) {
      System.out.println("\tInvalid Input. Please insert (Read / Write).");
      action = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    }
    return action.equals("read");
  }

  /**
   * Helper function to get direction from scanner.
   */
  private static boolean getInputType(Scanner scanner) {
    String type = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    while (!(type.equals("terminal")) && !(type.equals("file"))) {
      System.out.println("\tInvalid Input. Please insert (Terminal / File).");
      type = scanner.nextLine().toLowerCase().replaceAll(" ", "");
    }
    return (type.equals("terminal"));
  }

  /**
   * Helper function to get direction from scanner.
   */
   private static String getPassword(Scanner scanner) {
     String password;
     boolean isValid;
     do {
       password = scanner.nextLine().toLowerCase().replaceAll(" ", "");
       isValid = true;

       for (int i = 0; i < password.length(); i++) {
         char tmp = password.charAt(i);
         if (!((tmp >= 97 && tmp <= 104) || (tmp >= 48 && tmp <= 57))) {
           System.out.println("\tInvalid password."); // we restricted our coding symbol sets to 16.
           isValid = false;
           break;
         }
       }
     } while (!isValid);

     return password;
   }
}
