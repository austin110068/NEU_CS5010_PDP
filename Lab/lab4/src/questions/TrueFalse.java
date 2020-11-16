package questions;

/**
 * This type of question has "True" or "False" for its answer.
 */
public class TrueFalse implements Question, Comparable<Question> {
  private String questionText;
  private String correctAnswer;
  private String questionType;

  /**
   * Constructor.
   * Create a sub-bank for True False question.
   */
  public TrueFalse(String questionText, String correctAnswer) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "TrueFalse";
  }

  @Override
  public String getQuestionType() {
    return this.questionType;
  }

  @Override
  public String getText() {
    return this.questionText;
  }

  @Override
  public String answer(String userAnswer) {

    if (userAnswer.equals(this.correctAnswer)) {
      return "Correct";
    } else {
      return "Incorrect";
    }
  }

  @Override
  public int compareTo(Question ele) {
    int type = ele.getQuestionType().compareTo(this.getQuestionType());

    return type == 0 ? this.getText().compareTo(ele.getText()) : type;
  }
}

