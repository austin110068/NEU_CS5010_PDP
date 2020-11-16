package Coding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Abstract class to process all operations for encode & decode.
 */
public class AbstractCoding implements Coding {
  private final Map<Character, Integer> frequencyTable;
  private final Map<Character, String> codingTable;
  private final int symbolSets;
  private Node rootNode;
  private Queue<Pair> pq;
  private String decodeContent;

  public AbstractCoding(Map<Character, Integer> frequencyTable, int symbolSets) {
    this.frequencyTable = frequencyTable;
    this.codingTable = new HashMap<>();
    this.symbolSets = symbolSets;
  }

  @Override
  public Map<Character, String> getCodingTable() {
    return this.codingTable;
  }

  @Override
  public void startEncode() {
    this.buildingPriorityQueue();
    this.encodeHuffmanTree();
  }

  @Override
  public void startDecode(String password) {
    decodeContent(password);
  }

  @Override
  public String getDecodeContent() {
    return this.decodeContent;
  }

  /**
   * Pair class for setting up PQ and saving nodes in huffSet when building huffman tree.
   */
  static class Pair implements Comparable<Pair> {
    Integer frequency;
    String concat;

    public Pair(Integer frequency, String concat) {
      this.frequency = frequency;
      this.concat = concat;
    }


    // We first compare frequency, if equals then compare String lexicographically.
    @Override
    public int compareTo(Pair o) {
      if (frequency < o.frequency) {
        return -1;
      } else if (frequency > o.frequency) {
        return 1;
      } else {
        int str1_ch = this.concat.charAt(0);
        int str2_ch = o.concat.charAt(0);

        return str1_ch - str2_ch;
      }
    }
  }

  /**
   * Iterate through coding table to setup our Priority Queue.
   */
  public void buildingPriorityQueue() {
    this.pq = new PriorityQueue<>();

    for (Map.Entry<Character, Integer> e : this.frequencyTable.entrySet()) {
      this.pq.add(new Pair(e.getValue(), e.getKey().toString()));
    }
  }

  /**
   * Encode elements in PQ and construct the Huffman tree.
   */
  public void encodeHuffmanTree() {
    Map<String, Node> currHuffMap = new HashMap<>();  // use to record current constructed node
    Pair nextPair;
    String currentWord;
    int combinedFreq;
    StringBuilder combinedWord = null;

//  Keep constructing huffman tree until there's only 1 element left in our PQ.
    while (this.pq.size() > 1) {
      combinedFreq = 0;
      combinedWord = new StringBuilder();
      Node connectNode = new Node(this.symbolSets);

      for (int i = 0; i < this.symbolSets; i++) {
        if (this.pq.size() > 0) {
          nextPair = this.pq.poll();
          currentWord = nextPair.concat;
          combinedFreq += nextPair.frequency;
          combinedWord.append(currentWord);

          //Building our coding table to check up password in the future.
          buildCodingTable(i, currentWord);

          //
          if (!currHuffMap.containsKey(currentWord)) {
            Node leafNode = new Node();
            leafNode.setSymbolID(currentWord);
            connectNode.getChildren().set(i, leafNode);
          } else {
            Node tmp = currHuffMap.remove(currentWord);
            connectNode.getChildren().set(i, tmp);
          }
        }
      }

      connectNode.setSymbolID(combinedWord.toString());
      currHuffMap.put(combinedWord.toString(), connectNode);
      this.pq.add(new Pair(combinedFreq, combinedWord.toString()));
    }

    assert combinedWord != null;
    this.rootNode = currHuffMap.remove(combinedWord.toString());
  }

  private void buildCodingTable(int password, String currentWord) {
    if (password >= 10) {  // transferring to ascii code
      password += 87;
    } else {
      password += 48;
    }

    for (int i = 0; i < currentWord.length(); i++) {
      Character currTarget = currentWord.charAt(i);

      if (this.codingTable.containsKey(currTarget)) {
        this.codingTable.put(currTarget, (char) password + this.codingTable.get(currTarget));
      } else {
        this.codingTable.put(currTarget, Character.toString((char) password));
      }
    }
  }

  public void decodeContent(String password) {
    StringBuilder dc = new StringBuilder();
    Node tmp = this.rootNode;
    int childIndex;
    int cnt = 0;
    int nextWord = 0;

    while (password.length() != 0) {
      try {
        nextWord = password.charAt(cnt);
      } catch (StringIndexOutOfBoundsException e){
        System.out.println("Your password doesn't match in this Huffman tree.");
      }

      if (nextWord >= 97) {  // ascii code: 'a' -> 97, 'b' -> 98 ...
        childIndex = 10 + (nextWord - 97);
      } else {
        childIndex = nextWord - 48;  // ascii code: '0' -> 48, '1' -> 49 ...
      }
      cnt += 1;

      tmp = tmp.getChildren().get(childIndex);


      if (tmp.getIsWord()) {
        dc.append(tmp.getSymbolID());
        password = password.substring(cnt);
        tmp = this.rootNode;
        cnt = 0;
      }
    }

    this.decodeContent = dc.toString();
  }
}
