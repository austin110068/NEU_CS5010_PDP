package questions;

/**
 * This type of question may have at least 3 options, but no more than 8,
 * only one of which is correct.
 */
public class MultipleChoice implements Question, Comparable<Question> {
  private String questionText;
  private String correctAnswer;
  private String questionType;

  /**
   * Constructor that takes three options for Multiple Choice question.
   */
  public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                        String optionTwo, String optionThree) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "Multiple choice";
  }

  /**
   * Constructor that takes four options for Multiple Choice question.
   */
  public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                        String optionTwo, String optionThree, String optionFour) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "Multiple choice";
  }

  /**
   * Constructor that takes five options for Multiple Choice question.
   */
  public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                        String optionTwo, String optionThree, String optionFour,
                        String optionFive) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "Multiple choice";
  }

  /**
   * Constructor that takes six options for Multiple Choice question.
   */
  public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                        String optionTwo, String optionThree, String optionFour,
                        String optionFive, String optionSix) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "Multiple choice";
  }

  /**
   * Constructor that takes seven options for Multiple Choice question.
   */
  public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                        String optionTwo, String optionThree, String optionFour, String optionFive,
                        String optionSix, String optionSeven) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "Multiple choice";
  }

  /**
   * Constructor that takes eight options for Multiple Choice question.
   */
  public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                        String optionTwo, String optionThree, String optionFour, String optionFive,
                        String optionSix, String optionSeven, String optionEight) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.questionType = "Multiple choice";
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
