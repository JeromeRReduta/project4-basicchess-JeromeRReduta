import java.io.*;
import java.util.*;

public class ChessGame {



  public static void main(String[] args) throws IOException {
    // Given starter code by Prof. Leese, edited by me

    // Make stuff
    Scanner scan = new Scanner(new File("complete_board.txt"));
    String line;
    String[] lineSegment;
    ChessBoard board = new ChessBoard();




    // Create board states that reflect what given file asks it
    // to do

    // Makes piece when asked to, moves piece when asked to
    while(scan.hasNextLine()) {

      // Takes line as input (skips line if empty)
      line = scan.nextLine();
      if (line.isEmpty()) line = scan.nextLine();

      // Creates String[] by splitting line into Strings
      lineSegment = line.split(" ");

      // Update and print board
      board.update(lineSegment);
      System.out.println(board + "\n--------------------------------------------\n\n\n");
    }
  }
}
