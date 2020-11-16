package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for different question types.
 */
public interface Question extends Comparable<Question> {
  /**
   * Create question banks in different types.
   */
  List<Question> questions = new ArrayList<>();

  /**
   * Used for compareTo method.
   */
  String getQuestionType();

  /**
   * Getting specific question's text.
   */
  String getText();

  /**
   * Getting specific question's answer.
   */
  String answer(String userAnswer);
}
