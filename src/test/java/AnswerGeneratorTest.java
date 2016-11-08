import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Fail.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AnswerGeneratorTest {
  
  @Test
  public void should_generate_4_digits_string() {
    String result = new AnswerGenerator(new Random()).generate();
    
    assertThat(result.length()).isEqualTo(4);
  }
  
  @Test
  public void should_generate_number() {
    String result = new AnswerGenerator(new Random()).generate();
    try {
      Integer.parseInt(result);
    } catch (NumberFormatException e) {
      fail("result should be number");
    }
  }
  
  @Test
  public void should_generate_no_duplicate_digits_string() {
    String result = new AnswerGenerator(new Random()).generate();
    
    for (int i = 0; i < result.length(); i++) {
      char ch = result.charAt(i);
      assertThat(result.indexOf(ch)).isEqualTo(result.lastIndexOf(ch));
    }
  }
  
  @Test
  public void should_not_repeat_in_3_times() {
    Random random = mock(Random.class);
    given(random.nextInt(10))
      .willReturn(1, 2, 3, 4)
      .willReturn(1, 2, 3, 4)
      .willReturn(2, 3, 4, 5)
      .willReturn(6, 7, 8, 9);
    
    AnswerGenerator answerGenerator = new AnswerGenerator(random);
    List<String> results = new ArrayList<String>();
    results.add(answerGenerator.generate());
    results.add(answerGenerator.generate());
    results.add(answerGenerator.generate());
    results.add(answerGenerator.generate());
    
    assertThat(results.size()).isEqualTo(3);
  }
  
}
