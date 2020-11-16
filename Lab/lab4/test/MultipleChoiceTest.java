import static org.junit.Assert.assertEquals;
import questions.MultipleChoice;
import org.junit.Before;
import org.junit.Test;

/**
 * Testcase for MultipleChoice question.
 */
public class MultipleChoiceTest {
  MultipleChoice obj;

  @Before
  public void setUp() {
    obj = new MultipleChoice("Please calculate 8/4.", "2",
        "1", "2", "3", "4", "5");
  }

  @Test
  public void testQuestionText() {
    assertEquals(obj.getText(), "Please calculate 8/4.");
  }

  @Test
  public void testCorrectAnswer() {
    assertEquals(obj.answer("2"), "Correct");
  }

  @Test
  public void testWrongAnswer() {
    assertEquals(obj.answer("1"), "Incorrect");
    assertEquals(obj.answer("3"), "Incorrect");
    assertEquals(obj.answer("4"), "Incorrect");
    assertEquals(obj.answer("5"), "Incorrect");
  }

  @Test
  public void testInvalidAnswer() {
    assertEquals(obj.answer("Test"), "Incorrect");
    assertEquals(obj.answer("@#$%"), "Incorrect");
  }
}