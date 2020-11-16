package bignumber;

/**
 * Created by Chien-Yu.
 * This implementation represents non-negative numbers of arbitrary lengths.
 */
public class BigNumberImpl implements BigNumber {
  private String directInputNumber;
  private Node head;
  private Node tail;

  /**
   * Constructor with no parameters that creates the number 0.
   */
  public BigNumberImpl() {
    this.head = new Node();
    this.tail = this.head;
  }

  /**
   * Takes a number as a string and represents it.
   * This constructor should throw an IllegalArgumentException,
   * if the string passed to it does not represent a valid number.
   */
  public BigNumberImpl(String number) throws IllegalArgumentException {
    this.head = new Node();
    this.tail = this.head;

    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      if (c - '0' < 0 || c - '0' >= 10) {
        throw new IllegalArgumentException();
      }
      this.addDigit(c - '0');
      this.shiftLeft(1);
    }
    this.delTailNode();
  }

  /**
   * Get the head node.
   */
  public Node getHead() {
    return this.head;
  }

  /**
   * Add a new node at the tail.
   */
  public void addNewNode() {
    Node newNode = new Node();
    if (this.tail.prev == null && this.tail.value == 0) {
      return;
    }
    this.tail.next = newNode;

    Node dummy = this.tail;
    this.tail = newNode;
    this.tail.prev = dummy;
  }

  /**
   * Delete tail node.
   */
  public void delTailNode() {
    if (this.tail == this.head) {
      this.tail.value = 0;
    } else {
      this.tail = this.tail.prev;
      this.tail.next = null;
    }
  }

  @Override
  public int length() {
    Node tmp = this.head;
    int counter = 1;

    while (tmp.next != null) {
      tmp = tmp.next;
      counter++;
    }

    return counter;
  }

  @Override
  public void shiftLeft(int shifts) {
    if (shifts >= 0) {
      for (int i = 0; i < shifts; i++) {
        addNewNode();
      }
    } else {
      for (int i = 0; i < -shifts; i++) {
        delTailNode();
      }
    }
  }

  @Override
  public void shiftRight(int shifts) {
    if (shifts >= 0) {
      for (int i = 0; i < shifts; i++) {
        delTailNode();
      }
    } else {
      for (int i = 0; i < -shifts; i++) {
        addNewNode();
      }
    }
  }

  @Override
  public void addDigit(int digit) throws IllegalArgumentException {
    if (digit >= 10 || digit < 0) {
      throw new IllegalArgumentException();
    } else {
      int sum = this.tail.value + digit;
      if (sum < 10) {
        this.tail.value = sum;
      } else {
        Node ptr = this.tail;
        while (sum >= 10) {
          if (ptr == this.head) {
            ptr.value = sum % 10;
            Node newNode = new Node();
            newNode.value = 1;
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
            break;
          }

          ptr.value = sum % 10;
          ptr.prev.value += 1;
          sum = ptr.prev.value;
          ptr = ptr.prev;
        }
      }
    }
  }

  @Override
  public int getDigitAt(int position) throws IllegalArgumentException {
    if (position >= this.length() || position < 0) {
      throw new IllegalArgumentException();
    }

    Node target = this.tail;
    for (int i = 0; i < position; i++) {
      target = target.prev;
    }

    return target.value;
  }

  @Override
  public BigNumber copy() {
    BigNumberImpl copied = new BigNumberImpl();
    Node target = this.head;
    while (target != null) {
      copied.addNewNode();
      copied.addDigit(target.value);
      target = target.next;
    }

    return copied;
  }

  @Override
  public BigNumber add(BigNumber target) {
    Node ptr = this.head;
    BigNumberImpl newList = new BigNumberImpl();
    int difference = 0;

    if (this.length() > target.length()) {
      difference = this.length() - target.length();
      for (int i = 0; i < difference; i++) {
        newList.addDigit(this.getDigitAt(this.length() - i - 1));
        newList.shiftLeft(1);
      }
      for (int i = 0; i < target.length(); i++) {
        newList.addDigit(this.getDigitAt(target.length() - i - 1));
        newList.addDigit(target.getDigitAt(target.length() - i - 1));
        newList.shiftLeft(1);
      }
      newList.delTailNode();
    } else if (this.length() < target.length()) {
      difference = target.length() - this.length();
      for (int i = 0; i < difference; i++) {
        newList.addDigit(target.getDigitAt(target.length() - i - 1));
        newList.shiftLeft(1);
      }
      for (int i = 0; i < this.length(); i++) {
        newList.addDigit(target.getDigitAt(this.length() - i - 1));
        newList.addDigit(this.getDigitAt(this.length() - i - 1));
        newList.shiftLeft(1);
      }
      newList.delTailNode();
    } else {
      for (int i = 0; i < target.length(); i++) {
        newList.addDigit(this.getDigitAt(this.length() - i - 1));
        newList.addDigit(target.getDigitAt(this.length() - i - 1));
        newList.shiftLeft(1);
      }
      newList.delTailNode();
    }

    return newList;
  }

  @Override
  public int compareTo(BigNumber obj1) {
    if (obj1.length() == this.length()) {
      for (int i = 0; i < obj1.length(); i++) {
        if (obj1.getDigitAt(this.length() - i - 1)
            < this.getDigitAt(this.length() - i - 1)) {
          return 1;
        } else if (obj1.getDigitAt(this.length() - i - 1)
            > this.getDigitAt(this.length() - i - 1)) {
          return -1;
        } else if (i == obj1.length() - 1
            && obj1.getDigitAt(this.length() - i - 1)
            == this.getDigitAt(this.length() - i - 1)) {
          return 0;
        }
      }
    }

    return obj1.length() > this.length() ? -1 : 1;
  }


  /**
   * Returns a string representation of this number, as simply the number itself.
   */
  @Override
  public String toString() {
    String res = "";
    Node tmp = this.head;

    while (tmp != null) {
      res += tmp.value;
      tmp = tmp.next;
    }

    return res;
  }
}
