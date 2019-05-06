public class King extends ChessPiece {
    public King(int newDir) {
        super("k", newDir);
    }


    // Moves 1 spot away, any direction
    public int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException {
        int[] newPos = {ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)};

        // Case - trying to move >1 spot away
        if (Math.abs(x-newX) > 1 || Math.abs(y-newY) > 1) {
            throw new IllegalChessMoveException("Error - King can only move" +
                    " one space at a time");
    }

        return newPos;

    }

    // Only moves 1 spot, so only need to worry about 1 possible
    // collision point - (newX, newY)
    public int[][] getPossibleCollisions (int x, int y, int newX, int newY) {
        int xDir = newX - x;
        int yDir = newY - y;

        int nextCol = ChessBoard.xToCol(x + xDir);
        int nextRow = ChessBoard.yToRow(y + yDir);

        int[][] path = {{nextCol, nextCol}};

        return path;
    }
}
