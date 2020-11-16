package bignumber;

/**
 * Creating a new node for double linked-list.
 */
public class Node {
  int value;
  Node next;
  Node prev;

  /**
   * Using double linked list can reduce time complexity for Big Number.
   */
  public Node() {
    this.value = 0;
    this.next = null;
    this.prev = null;
  }
}