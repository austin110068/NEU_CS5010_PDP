package Coding;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private List<Node> children;
  private String symbolID;
  private final boolean isWord;

  /**
   * Leaf Node.
   */
  public Node() {
    this.isWord = true;
  }

  /**
   * Normal Node.
   */
  public Node(int symbolSets) {
    this.children = new ArrayList<>();
    this.isWord = false;

    // all children node is default to null.
    for (int i = 0; i < symbolSets; i++) {
      this.children.add(null);
    }
  }

  public void setSymbolID(String id) {
    this.symbolID = id;
  }

  public String getSymbolID() {
    return this.symbolID;
  }

  public List<Node> getChildren() {
    return this.children;
  }

  public boolean getIsWord() {
    return this.isWord;
  }
}
