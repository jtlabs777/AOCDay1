
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(new File(".").getAbsolutePath());

      File file = new File("data\\list.txt");
      Scanner scanner = new Scanner(file);
      StringBuilder firstAndLastNumbers = new StringBuilder();
      ArrayList<Integer> listOfNumbers = new ArrayList<>();


      while (scanner.hasNextLine()) {

          String text = scanner.nextLine();
          String[]  letters = text.split("");

          for (String character: letters) {
            int charCode = character.codePointAt(0);
            if (isANumber(charCode))
            {
                firstAndLastNumbers.append(character);
                break;// break loop;
            }
          }

          //reverse order
          for (int j = letters.length - 1; j >= 0; j--)
          {
              int charCode = letters[j].codePointAt(0);
              if (isANumber(charCode))
              {
                  firstAndLastNumbers.append(letters[j]);
                  break;// break loop;
              }
          }


           listOfNumbers.add(parseInt(String.valueOf(firstAndLastNumbers))); //covert to number
          firstAndLastNumbers.delete(0, firstAndLastNumbers.length()); //reset string

          }
      scanner.close();

      int sum = listOfNumbers.stream().mapToInt(Integer::intValue).sum();

      System.out.println(sum);

      }

      private static boolean isANumber(int charCode) {
          //check if 0 - 9
          return charCode >= 48 && charCode <= 57;
      }



}