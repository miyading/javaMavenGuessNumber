import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AnswerGenerator {
  private final Set<String> historyGeneratedStrings;
  private Random random;
  
  public AnswerGenerator(Random random) {
    this.random = random;
    this.historyGeneratedStrings = new HashSet<String>();
  }
  
  public String generate() {
    StringBuilder result = new StringBuilder();
    while (result.length() < 4) {
      String digit = String.valueOf(random.nextInt(10));
      if (result.indexOf(digit) == -1) {
        result.append(digit);
      }
    }
    
    String resultStr = result.toString();
    if (historyGeneratedStrings.add(resultStr)) {
      return resultStr;
    } else {
      return null;
    }
  }
}
