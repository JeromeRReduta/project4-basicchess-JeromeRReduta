import java.security.cert.CertSelector;

public class Bishop extends ChessPiece {

   public Bishop(int newDir) {super("b", newDir);}

   // Moves diagonally - throws error if asked to move otherwise
   public int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException {

       int[] newPos = {ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)};
       if (x - newX != y - newY) {
           throw new IllegalChessMoveException("Error - Bishop can only move" +
                   " straight diagonally");
       }

       return newPos;
   }

   // Gets array of [col, row] in between (x, y) and newLocation (newX, newY),
    // ... including (newX, newY) - moving diagonally
    public int[][] getPossibleCollisions(int x, int y, int newX, int newY) {
       int limit = Math.abs(x - newX);

       int[][] path = new int[limit][2];

       int xDir, yDir;

       if (newX > x) xDir = 1; else xDir = -1;

       if (newY > y) yDir = 1; else yDir = -1;

       for (int index = 1; index <= limit; index++) {
           int nextCol = ChessBoard.xToCol(x + index * xDir);
           int nextRow = ChessBoard.yToRow(y + index * yDir);

           int[] next = {nextCol, nextRow};
           path[index-1] = next;
       }

       return path;
   }
}