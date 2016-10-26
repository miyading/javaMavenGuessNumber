import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CompareNumberTest {
  @Test
  public void should_return_4A0B_when_get_tips_given_input_is_1234_and_answer_is_1234() {
    String input = "1234";
    String answer = "1234";
    
    CompareNumber compareNumber = new CompareNumber();
    String result = compareNumber.getTips(input, answer);
    
    assertThat(result).isEqualTo("4A0B");
  }
}
