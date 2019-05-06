public class Knight extends ChessPiece {
    public Knight(int newDir) {super("h", newDir);}

    // Moves in horizontal L shape (2 spots horizontally, 1 spot vertically
    // or in vertical L shape (1 spot horizontally, 2 spots vertically)
    public int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException{

        int[] newPos = {ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)};

        // Case - Does not make "Horizontal L:" two spaces horiz, one space vert.
        boolean notHorizL = Math.abs(x - newX) != 2 || Math.abs(y - newY)!= 1;

        // Case - Does not make "Vertical L:" one space horiz, two spaceas vert.
        boolean notVertL = Math.abs(x-newX) != 1 || Math.abs(y - newY) != 2;

// Case - Does not make either type of L
        if (notHorizL && notVertL) {
            throw new IllegalChessMoveException("Error - Knight can only move in L shape");
        }

        return newPos;

    }

    // Knight allowed to jump over pieces, so only potential collision
    // spot is (newX, newY)
    public int[][] getPossibleCollisions (int x, int y, int newX, int newY) {
        int[][] path = {{ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)}};

        return path;
    }
}

