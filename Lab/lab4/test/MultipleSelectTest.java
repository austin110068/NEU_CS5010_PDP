import static org.junit.Assert.assertEquals;
import questions.MultipleSelect;
import org.junit.Before;
import org.junit.Test;

/**
 * Testcase for MultipleSelect question.
 */
public class MultipleSelectTest {
  MultipleSelect obj;

  @Before
  public void setUp() {
    obj = new MultipleSelect("Please pick out vehicle with four wheels" +
        " in the following options.", "3 1",
        "1", "1 2", "3 4", "3 1", "1 2 3 4");
  }

  @Test
  public void testQuestionText() {
    assertEquals(obj.getText(),
        "Please pick out vehicle with four wheels in the following options.");
  }

  @Test
  public void testCorrectAnswer() {
    assertEquals(obj.answer("3 1"), "Correct");
  }

  @Test
  public void testWrongAnswer() {
    assertEquals(obj.answer("1"), "Incorrect");
    assertEquals(obj.answer("1 2"), "Incorrect");
    assertEquals(obj.answer("3 4"), "Incorrect");
    assertEquals(obj.answer("1 2 3 4"), "Incorrect");
  }

  @Test
  public void testInvalidAnswer() {
    assertEquals(obj.answer("Test"), "Incorrect");
    assertEquals(obj.answer("!@#$%^"), "Incorrect");
  }
}