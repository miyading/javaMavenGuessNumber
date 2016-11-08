import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.inOrder;

public class GameProcessTest {
  
  private PrintStream out;
  private GameProcess game;
  private BufferedReader bufferedReader;
  private CompareNumber compareNumber;
  private AnswerGenerator answerGenerator;
  private InOrder inOrder;
  
  @Before
  public void setUp() throws IOException {
    out = mock(PrintStream.class);
    
    bufferedReader = mock(BufferedReader.class);
    compareNumber = new CompareNumber();
    answerGenerator = mock(AnswerGenerator.class);
    given(bufferedReader.readLine()).willReturn("1234");
    given(answerGenerator.generate()).willReturn("4321");
    
    game = new GameProcess(out, bufferedReader, compareNumber, answerGenerator);
    
    inOrder = inOrder(out);
    
  }
  
  @Test
  public void should_print_welcome_when_game_start() throws IOException {
    
    verify(out, never()).println("welcome");
    game.start();
    verify(out).println("welcome");
  }
  
  @Test
  public void should_print_please_input_after_game_start() throws IOException {
    
    game.start();
    
    inOrder.verify(out).println("welcome");
    inOrder.verify(out).println("please input your number: ");
  }
  
  @Test
  public void should_reduce_one_chance_when_guess_wrong() throws IOException {
    
    game.start();
    
    inOrder.verify(out).println("welcome");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
  }
  
  @Test
  public void should_reduce_chances_one_by_one_until_game_over() throws IOException {
    game.start();
    
    inOrder.verify(out).println("welcome");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("game over");
  }
  
  @Test
  public void should_congratulate_when_input_is_right() throws IOException {
    given(answerGenerator.generate()).willReturn("1234");
    
    game.start();
    
    inOrder.verify(out).println("welcome");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out, never()).println("4A0B");
    inOrder.verify(out).println("congratulation");
  }
  
  @Test
  public void should_congratulate_when_input_is_right_on_second_round() throws IOException {
    given(bufferedReader.readLine()).willReturn("1234").willReturn("4321");
    
    game.start();
    
    inOrder.verify(out).println("welcome");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out, never()).println("4A0B");
    inOrder.verify(out, never()).println("game over");
  }
  
  @Test
  public void should_congratulate_when_input_is_right_on_last_round() throws IOException {
    given(bufferedReader.readLine()).willReturn("1234", "1234", "1234", "1234", "1234")
      .willReturn("4321");
    
    game.start();
    
    inOrder.verify(out).println("welcome");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out).println("0A4B");
    inOrder.verify(out).println("please input your number: ");
    inOrder.verify(out, never()).println("4A2B");
    inOrder.verify(out, never()).println("game over");
  }
}
