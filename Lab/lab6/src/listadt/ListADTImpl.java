package listadt;

/**
 * This is the implementation of a generic list. Specifically it implements
 * the ListADT interface.
 * This is a placeholder for the actual data type.
 * @param <T> the type of data that will work with this list as a generic parameter.
 */
public class ListADTImpl<T> implements ListADT<T> {
  private GenericListADTNode<T> head;

  // a private constructor that is used internally (see map)
  private ListADTImpl(GenericListADTNode<T> head) {
    this.head = head;
  }

  public ListADTImpl() {
    head = new GenericEmptyNode<>();
  }

  public GenericListADTNode<T> getHead() {
    return head;
  }

  public void setHead(GenericListADTNode<T> newHead) {
    head = newHead;
  }

  @Override
  public void addFront(T b) {
    head = head.addFront(b);
  }

  @Override
  public void addBack(T b) {
    head = head.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    head = head.add(index, b);
  }

  @Override
  public int getSize() {
    return head.count();
  }

  @Override
  public void remove(T b) {
    head = head.remove(b);
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if ((index >= 0)) {
      return head.get(index);
    } else {
      throw new IllegalArgumentException("Invalid index");
    }
  }

  @Override
  public void reverse() {
    this.head = head.reverse(new GenericEmptyNode<T>());
  }

  @Override
  public void swap(int leftIndex, int rightIndex) {
    this.head = head.swap(leftIndex, rightIndex);
  }

  @Override
  public String toString() {
    return "(" + head.toString() + ")";
  }
}