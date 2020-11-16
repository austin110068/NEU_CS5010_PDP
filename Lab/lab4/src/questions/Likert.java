package questions;

/**
 * This type of question asks an opinion, so there is no "correct" answer.
 * Can be answered on a fixed, 5-point Likert scale,
 * (Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree).
 */
public class Likert implements Question, Comparable<Question> {
  private String questionText;
  private String questionType;

  /**
   * Constructor.
   * Create a sub-bank for Likert question.
   */
  public Likert(String questionText) {
    this.questionText = questionText;
    this.questionType = "Likert";
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

    if (userAnswer.equals("1") || userAnswer.equals("2") || userAnswer.equals("3")
        || userAnswer.equals("4") || userAnswer.equals("5")) {
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
