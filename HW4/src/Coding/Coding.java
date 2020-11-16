package Coding;

import java.util.Map;

/**
 * Interface for encode & decode.
 */
public interface Coding {
  /**
   * Get Coding Table.
   */
  Map<Character, String> getCodingTable();

  /**
   * Start Encoding.
   */
  void startEncode();

  /**
   * Start Decoding.
   */
  void startDecode(String password);

  /**
   * Get decode content from given password.
   */
  String getDecodeContent();
}
