package lookandsay;

import java.util.Iterator;

/**
 * Created by Chien-Yu.
 */
public interface RIterator<T> extends Iterator<T> {
  /**
   * Return the current number in the sequence and retreat to the previous number.
   */
  T prev();

  /**
   * Return true if it is possible to go back one step, false otherwise.
   */
  boolean hasPrevious();
}
