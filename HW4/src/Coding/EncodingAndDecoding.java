package Coding;

import java.util.Map;

/**
 * Concrete class to process encode & decode.
 */
public class EncodingAndDecoding extends AbstractCoding {
  public EncodingAndDecoding(Map<Character, Integer> frequencyTable, int symbolSets) {
    super(frequencyTable, symbolSets);
  }

  @Override
  public void startEncode() {
    super.startEncode();
  }

  @Override
  public void startDecode(String password) {
    super.startDecode(password);
  }

  @Override
  public String getDecodeContent() {
    return super.getDecodeContent();
  }
}
