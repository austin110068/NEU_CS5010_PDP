package listadt;

/**
 * Created by Chien-Yu.
 */
public interface ListADT<T> {
  /**
   * Add an object to the front of this list.
   * @param b the object to be added to the front of this list
   */
  void addFront(T b);

  /**
   * Add an object to the back of this list (so it is the last object in the
   * list.
   * @param b the object to be added to the back of this list
   */
  void addBack(T b);

  /**
   * Add an object to this list so that it occupies the provided index. Index
   * begins with 0.
   * @param index the index to be occupied by this object, beginning at 0
   * @param b the object to be added to the list
   */
  void add(int index, T b);

  /**
   * Return the number of objects currently in this list.
   * @return the size of the list
   */
  int getSize();

  /**
   * Remove the first instance of this object from this list.
   * @param b the object to be removed
   */
  void remove(T b);

  /**
   * Get the (index)th object in this list.
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  T get(int index) throws IllegalArgumentException;

  GenericListADTNode<T> getHead();

  void setHead(GenericListADTNode<T> newHead);

  void reverse();

  void swap(int leftIndex, int rightIndex);
}
