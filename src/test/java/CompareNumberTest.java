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
  
  @Test
  public void should_return_3A0B_when_get_tips_given_input_is_1234_and_answer_is_1235() {
    String input = "1234";
    String answer = "1235";
    
    CompareNumber compareNumber = new CompareNumber();
    String result = compareNumber.getTips(input, answer);
    
    assertThat(result).isEqualTo("3A0B");
  }
  
  @Test
  public void should_return_0A0B_when_get_tips_given_input_is_1234_and_answer_is_5678() {
    String input = "1234";
    String answer = "5678";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("0A0B");
  }
  
  @Test
  public void should_return_0A1B_when_get_tips_given_input_is_1234_and_answer_is_2678() {
    String input = "1234";
    String answer = "2678";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("0A1B");
  }
  
  @Test
  public void should_return_0A2B_when_get_tips_given_input_is_1234_and_answer_is_2178() {
    String input = "1234";
    String answer = "2178";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("0A2B");
  }
  
  @Test
  public void should_return_0A3B_when_get_tips_given_input_is_1234_and_answer_is_3127() {
    String input = "1234";
    String answer = "3127";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("0A3B");
  }
  
  @Test
  public void should_return_0A4B_when_get_tips_given_input_is_1234_and_answer_is_4321() {
    String input = "1234";
    String answer = "4321";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("0A4B");
  }
  
  @Test
  public void should_return_1A0B_when_get_tips_given_input_is_1234_and_answer_is_1789() {
    String input = "1234";
    String answer = "1789";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("1A0B");
  }
  
  @Test
  public void should_return_1A1B_when_get_tips_given_input_is_1567_and_answer_is_1872() {
    String input = "1567";
    String answer = "1872";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("1A1B");
  }
  
  @Test
  public void should_return_1A2B_when_get_tips_given_input_is_1234_and_answer_is_1328() {
    String input = "1234";
    String answer = "1328";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("1A2B");
  }
  
  @Test
  public void should_return_1A3B_when_get_tips_given_input_is_1234_and_answer_is_1423() {
    String input = "1234";
    String answer = "1423";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("1A3B");
  }
  
  @Test
  public void should_return_2A0B_when_get_tips_given_input_is_1234_and_answer_is_1289() {
    String input = "1234";
    String answer = "1289";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("2A0B");
  }
  
  @Test
  public void should_return_2A1B_when_get_tips_given_input_is_1234_and_answer_is_1249() {
    String input = "1234";
    String answer = "1249";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("2A1B");
  }
  
  @Test
  public void should_return_2A2B_when_get_tips_given_input_is_1234_and_answer_is_1243() {
    String input = "1234";
    String answer = "1243";
    
    String result = new CompareNumber().getTips(input, answer);
    
    assertThat(result).isEqualTo("2A2B");
  }
}