import java.security.cert.CertSelector;

public class Queen extends ChessPiece {

    public Queen(int newDir) {
        super("q", newDir);
    }

    // Queen can move anywhere in a straight line
    public int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException {
        int[] newPos = {ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)};

        // Case - Does not move in straight line
        if (newX != x && newY != y && newX - x != newY - y) {
            throw new IllegalChessMoveException("Error - Queen only moves in straight line");
        }

        return newPos;
    }

    // Gets possible collision spots
    public int[][] getPossibleCollisions (int x, int y, int newX, int newY) {
        int limit = Math.max(Math.abs(newX - x), Math.abs(newY - y));

        int[][] path = new int[limit][2];

        int xDir, yDir;

        // Determines whether queen asked to move up or down,
        // ...left or right
        if (newX > x) xDir = 1; else xDir = -1;
        if (newY > y) yDir = 1; else yDir = -1;

        // Takes path of queen moving from (x, y) to (newX, newY)
        for (int index = 1; index <= limit; index++) {
            int nextCol = ChessBoard.xToCol(x + index*xDir);
            int nextRow = ChessBoard.yToRow(y + index*yDir);

            int[] step = {nextCol, nextRow};

            path[index-1] = step;
        }

        return path;


    }
}