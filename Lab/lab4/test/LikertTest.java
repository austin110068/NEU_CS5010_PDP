import static org.junit.Assert.assertEquals;
import questions.Likert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testcase for Liker question.
 */
public class LikertTest {
  Likert obj;

  @Before
  public void setUp() {
    obj = new Likert("Do you enjoy coding?");
  }

  @Test
  public void testQuestionText() {
    assertEquals(obj.getText(), "Do you enjoy coding?");
  }

  @Test
  public void testCorrectAnswer() {
    assertEquals(obj.answer("1"), "Correct");
    assertEquals(obj.answer("2"), "Correct");
    assertEquals(obj.answer("3"), "Correct");
    assertEquals(obj.answer("4"), "Correct");
    assertEquals(obj.answer("5"), "Correct");
  }

  @Test
  public void testInvalidAnswer() {
    assertEquals(obj.answer("0"), "Incorrect");
    assertEquals(obj.answer("6"), "Incorrect");
  }

}