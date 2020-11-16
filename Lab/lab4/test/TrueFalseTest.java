import static org.junit.Assert.assertEquals;
import questions.TrueFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * Testcase for TrueFalse question.
 */
public class TrueFalseTest {
  TrueFalse obj;

  @Before
  public void setUp() {
    obj = new TrueFalse("Is emus extinct or not?", "True");
  }

  @Test
  public void testQuestionText() {
    assertEquals(obj.getText(), "Is emus extinct or not?");
  }

  @Test
  public void testCorrectAnswer() {
    assertEquals(obj.answer("True"), "Correct");
  }

  @Test
  public void testWrongAnswer() {
    assertEquals(obj.answer("False"), "Incorrect");
  }

  @Test
  public void testInvalidAnswer() {
    assertEquals(obj.answer("Test"), "Incorrect");
    assertEquals(obj.answer("!@#$%"), "Incorrect");
  }
}