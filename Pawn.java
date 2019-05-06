public class Pawn extends ChessPiece {

    // Whether pawn has taken its first move
    boolean firstMove = true;

    public Pawn(int newDir) { super("p", newDir); }

    // Pawn can move 1 spot forward, or <= 2 if it's its first move
    public int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException{

        int[] newPos = {ChessBoard.xToCol(newX), ChessBoard.yToRow(newY)};

        int limit = direction;


        // Pawn can move 2 spots only on 1st move
        if (firstMove) { limit = 2; firstMove = false;}

        // Case: Moves horizontally, or moves more spaces than allowed,
        // or moves backwards
        // Note - (newY - y)/direction will always be > 1 as long as pawn
        // moves in given direction
        if (x != newX || Math.abs(newY - y) > limit || (newY - y)/direction > 1 ) {
                throw new IllegalChessMoveException("Error - Pawn can only move forward");
            }

        return newPos;
    }

    // Gets possible collision spots - only worry about <= 2
    public int[][] getPossibleCollisions (int x, int y, int newX, int newY) {
        int limit = Math.abs(y - newY);

        int[][] path = new int[limit][2];

        for (int index = 1; index <= limit; index++) {
            int nextCol = ChessBoard.xToCol(x);

            // For some reason pawn's path goes backwards unless I
            // multiply direction by -1 - honestly not even sure
            // if I needed this var

            int nextRow = ChessBoard.yToRow(y + index*direction*-1);

            int[] step = {nextCol, nextRow};
            path[index-1] = step;
        }

        return path;
    }
}
