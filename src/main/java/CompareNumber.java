public class CompareNumber {
  public String getTips(String input, String answer) {
    int aCount = 0;
    for (int i = 0; i < input.length(); i++) {
      if (answer.charAt(i) == input.charAt(i)) {
        aCount++;
      }
    }
    
    int containCount = 0;
    for (int i = 0; i < input.length(); i++) {
      if (answer.contains(String.valueOf(input.charAt(i)))) {
        containCount++;
      }
    }
    
    return aCount + "A" + (containCount - aCount) + "B";
  }
}
