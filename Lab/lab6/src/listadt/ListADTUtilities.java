package listadt;

import java.util.HashSet;
import java.util.Set;

/**
 * Using the ListADT implementation of our sequential structure,
 * implement each of the above methods in a ListADTUtilities class.
 */
public final class ListADTUtilities<T> extends ListADTImpl<T> {

  /**
   * Creates a new instance of the ListADT
   * Contains all of the specified elements in the order they appeared in elements.
   */
  public static <T> ListADT<T> toList(T[] elements) {
    ListADT obj = new ListADTImpl();
    for (T ele : elements) {
      if (ele == null) {
        throw new IllegalArgumentException();
      } else {
        obj.addBack(ele);
      }
    }

    return obj;
  }

  /**
   * Adds the specified elements to the end of the specified list.
   * Elements should be added in the same order they appear in elements.
   */
  public static <T> void addAll(ListADT<T> list, T... elements) {
    for (T ele : elements) {
      if (ele == null) {
        throw new IllegalArgumentException();
      } else {
        list.addBack(ele);
      }
    }
  }

  /**
   * Returns the number of elements in the specified list equal to the specified element.
   * More formally, it should return the number of elements in the list,
   * such that (o == null) ? e == null : o.equals(e)).
   */
  public static <T> int frequency(ListADT<T> list, T element) {
    int counter = 0;
    for (int i = 0; i < list.getSize(); i++) {
      if (list.get(i) == element) {
        counter += 1;
      }
    }

    return counter;
  }

  /**
   * Returns true if the two lists have no elements in common.
   * This method should throw a NullPointerException,
   * if either list is null or if either list contains a null element.
   */
  public static boolean disjoint(ListADT<?> one, ListADT<?> two) {
    return disjointHelper(one, two);
  }

  /**
   * Helper function to reference wildcard.
   */
  private static <T> boolean disjointHelper(ListADT<? extends T> one, ListADT<? extends T> two) {
    Set<T> setOne = new HashSet<>();

    if (one == null || two == null) {
      throw new IllegalArgumentException();
    }
    boolean hasSame = false;
    int oneSize = one.getSize();
    int twoSize = two.getSize();

    for (int i = 0; i < oneSize; i++) {
      if (one.get(i) == null) {
        throw new IllegalArgumentException();
      }

      setOne.add(one.get(i));
    }

    for (int i = 0; i < twoSize; i++) {
      if (two.get(i) == null) {
        throw new IllegalArgumentException();
      }

      if (setOne.contains(two.get(i))) {
        hasSame = true;
      }
    }

    return !hasSame;
  }

  /**
   * Returns true if the two lists are equal.
   * Two lists are equal if they have the same elements in the same order.
   * If either list is null, or if either list contains a null element,
   * this method should throw a NullPointerException.
   */
  public static boolean equals(ListADT<?> one, ListADT<?> two) {
    return equalsHelper(one, two);
  }

  /**
   * Helper function to reference wildcard.
   */
  private static <T> boolean equalsHelper(ListADT<? extends T> one, ListADT<? extends T> two) {
    String strOne = "";
    String strTwo = "";

    if (one == null || two == null) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < one.getSize(); i++) {
      if (one.get(i) == null) {
        throw new IllegalArgumentException();
      }

      strOne += one.get(i).toString();
    }

    for (int i = 0; i < two.getSize(); i++) {
      if (two.get(i) == null) {
        throw new IllegalArgumentException();
      }

      strTwo += two.get(i).toString();
    }


    return strOne.equals(strTwo);
  }

  /**
   * Reverses the order of the elements in the specified list.
   */
  public static void reverse(ListADT<?> list) {
    reverseHelper(list);
  }

  /**
   * Helper function to reference wildcard.
   */
  private static <T> void reverseHelper(ListADT<? extends T> list) {
    list.reverse();
  }

  /**
   * Swaps the elements at the specified position in the specified list.
   */
  public static void swap(ListADT<?> list, int i, int j) {
    swapHelper(list, i, j);
  }

  /**
   * Helper function to reference wildcard.
   */
  private static <T> void swapHelper(ListADT<? extends T> list, int i, int j) {
    if (i < 0 || j < 0 || i >= list.getSize() || j >= list.getSize()) {
      throw new IndexOutOfBoundsException();
    }

    list.swap(i, j);
  }
}
