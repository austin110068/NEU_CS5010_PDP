package lookandsay;

import java.math.BigInteger;

/**
 * A look-and-say sequence is a sequence of numbers.
 * Given the current number, the next number is obtained by reading the current number out loud,
 * writing what we say.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {
  private final int largestDigitNum = 100;
  private final BigInteger start;
  private final BigInteger end;
  private BigInteger current;

  /**
   * The seed is the number at which the sequence must begin.
   * The iterator should not produce a number greater than the end value.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger endVal) {
    if (seed.compareTo(new BigInteger("0")) < 0) {
      throw new IllegalArgumentException("The seed is not positive");
    }

    if (seed.compareTo(endVal) >= 0) {
      throw new IllegalArgumentException("The seed is not less than the end.");
    }

    String check = seed.toString();
    for (int i = 1; i < check.length(); i++) {
      if (check.charAt(i) == '0') {
        throw new IllegalArgumentException("The seed has any zeroes in it.");
      }
    }

    this.start = seed;
    this.end = endVal;
    this.current = this.start;
  }


  /**
   * The seed is the number at which the sequence must begin.
   * The end value will be a number with 100 9s (the largest 100 digit number).
   */
  public LookAndSayIterator(BigInteger seed) {
    if (seed.compareTo(new BigInteger("0")) < 0) {
      throw new IllegalArgumentException("The seed is not positive.");
    }

    this.start = seed;
    this.end = this.buildLargestNum();

    if (this.start.compareTo(this.end) >= 0) {
      throw new IllegalArgumentException("The seed is not less than the end");
    }

    String check = seed.toString();
    for (int i = 1; i < check.length(); i++) {
      if (check.charAt(i) == '0') {
        throw new IllegalArgumentException("The seed has any zeroes in it.");
      }
    }

    this.current = this.start;
  }

  /**
   * This should start the sequence with a seed of 1.
   * e.g. calling next and an end value as a number with 100 9s (the largest 100 digit number).
   */
  public LookAndSayIterator() {
    this.start = new BigInteger("1");
    this.end = this.buildLargestNum();
    this.current = this.start;
  }

  /**
   * Building a number with 100 9s (the largest 100 digit number).
   */
  private BigInteger buildLargestNum() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < largestDigitNum; i++) {
      sb.append("9");
    }

    return new BigInteger(sb.toString());
  }

  /**
   * Helper function to operate iterator.
   */
  private BigInteger getNext() {
    StringBuilder sb = new StringBuilder();
    String currentVal = this.current.toString();
    int counter = 0;
    char c = currentVal.charAt(0);

    for (int i = 0; i < currentVal.length(); i++) {
      if (currentVal.charAt(i) == c) {
        counter += 1;
      } else {
        sb.append(counter);
        sb.append(c);
        counter = 1;
        c = currentVal.charAt(i);
      }
    }
    sb.append(counter);
    sb.append(c);

    return new BigInteger(sb.toString());
  }

  /**
   * Return true if the next number to be returned is still lesser than end
   * (specified in the constructors), false otherwise.
   */
  @Override
  public boolean hasNext() {
    return this.current.compareTo(this.end) <= 0;
  }

  /**
   * Return the current number in the sequence and advance to the next number.
   */
  @Override
  public BigInteger next() {
    BigInteger current = this.current;
    this.current = getNext();
    return current;
  }

  @Override
  public boolean hasPrevious() {
    return this.current.toString().length() % 2 == 0;
  }

  @Override
  public BigInteger prev() {
    if (!hasPrevious()) {
      return this.current;
    }

    BigInteger returnVal = this.current;
    StringBuilder sb = new StringBuilder();
    String currentVal = this.current.toString();

    for (int i = 0; i < currentVal.length(); i += 2) {
      int counter = currentVal.charAt(i) - '0';  // ascii transform
      for (int j = 0; j < counter; j++) {
        sb.append(currentVal.charAt(i + 1));
      }
    }

    this.current = new BigInteger(sb.toString());

    return returnVal;
  }
}
