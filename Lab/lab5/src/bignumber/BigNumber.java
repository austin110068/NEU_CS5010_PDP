package bignumber;

/**
 * Defines Big Number operations with methods.
 */
public interface BigNumber {
  /**
   * Returns the number of digits in this number.
   */
  int length();

  /**
   * Takes the number of shifts as an argument and shifts this number to the left by that number.
   * A negative number of left-shifts will correspond to those many right shifts.
   */
  void shiftLeft(int shifts);

  /**
   * Takes the number of shifts as an argument and shifts this number to the right by that number.
   * The number 0 can be right-shifted any positive number of times, yielding the same number 0.
   * A negative number of right-shifts will correspond to those many left shifts.
   */
  void shiftRight(int shifts);

  /**
   * Takes a single digit as an argument and adds it to this number.
   * If the digit passed to it is not a single non-negative digit,
   * this method throws an IllegalArgumentException.
   */
  void addDigit(int digit);

  /**
   * Takes a position as an argument and returns the digit at that position.
   * Positions start at 0 (rightmost digit).
   * This method throws an IllegalArgumentException if an invalid position is passed.
   */
  int getDigitAt(int position);

  /**
   * Returns an identical and independent copy of this number.
   */
  BigNumber copy();

  /**
   * Takes another BigNumber and returns the sum of these two numbers.
   * This operation does not change either number.
   */
  BigNumber add(BigNumber target);

  /**
   * Compare two BigNumber objects for ordering.
   */
  int compareTo(BigNumber obj1);
}
