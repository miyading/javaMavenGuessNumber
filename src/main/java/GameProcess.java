import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class GameProcess {
  private PrintStream out;
  private final BufferedReader bufferedReader;
  private final CompareNumber compareNumber;
  private final AnswerGenerator answerGenerator;
  
  public GameProcess(PrintStream out, BufferedReader bufferedReader, CompareNumber compareNumber, AnswerGenerator answerGenerator) {
    this.out = out;
    this.bufferedReader = bufferedReader;
    this.compareNumber = compareNumber;
    this.answerGenerator = answerGenerator;
  }
  
  public void start() throws IOException {
    out.println("welcome");
    int roundCount = 6;
    
    String answer = answerGenerator.generate();
    String tips = "";
    while (roundCount > 0) {
      out.println("please input your number: ");
      String input = bufferedReader.readLine();
      tips = compareNumber.getTips(input, answer);
      if("4A0B".equals(tips)) {
        break;
      }
      
      out.println(tips);
      roundCount--;
    }
    if ("4A0B".equals(tips)) {
      out.println("congratulation");
      return;
    }
    
    out.println("game over");
  }
}
