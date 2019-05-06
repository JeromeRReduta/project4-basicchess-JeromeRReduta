public class Rook extends ChessPiece {


    public Rook(int newDir) {
        super("r", newDir);
    }

    // Rook can move any # of spaces exclusively forward or sideways
    public int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException {
        int[] newPos = {ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)};


        // Case - Moving horizontally AND sideways or moving backwards
        // Note: (newY - y)/direction always > 1 whenever rook
        // goes in its designated direction
        if ((x != newX && y != newY) ||(newY - y)/direction > 1) {

            throw new IllegalChessMoveException("Error - Rook " +
                    "can only move forward and sideways.");
        }

        return newPos;
    }

    // Gets possible collision spots - all spots in straight line
    // ... between (x, y) and (newX, newY)
    public int[][] getPossibleCollisions (int x, int y, int newX, int newY) {
        int limit = Math.max(Math.abs(newX - x), Math.abs(newY - y));

        int[][] path = new int[limit][2];

        int xDir = 0;
        int yDir = 0;

        if (newX > x) {
            xDir = 1;
        }

        else if (newX < x) {
            xDir = -1;
        }

        if (newY > y) {
            yDir = 1;
        }

        else if (newY < y) {
            yDir = -1;
        }

        for (int index = 1; index <= limit; index++) {
            int newCol = ChessBoard.xToCol(x + index*xDir);
            int newRow = ChessBoard.yToRow(y + index*yDir);

            int[] step = {newCol, newRow};

            path[index-1] = step;
        }
        return path;
    }

}
