import java.util.*;
public class AllChessPiecesDemo {

    // Tested EVERY piece type, because it's the only way
    // to be sure

    // Made this so I wouldn't have to type Arrays.toString()
    // as much
    public static void printMoveArray(int[] moveArray) {
        System.out.println(Arrays.toString(moveArray));
    }

    // Note: Formatting might be wonky for 1st few funcs, but
    // all funcs roughly follow this format:

    /*
    1) Print piece type

    Set piece = to ChessPiece of designated piece type

    Tests its move options (may have some meant to trigger
    board exceptions)

    Test getPossibleCollisions() for certain (x, y)
    Test printPossibleCollisions() for certain (x, y) - for
        printed array indices
    Test printPossibleCollisions() for certain (x, y) - for printed
        board coordinates
     */
    public static void testPawn() throws IllegalChessMoveException {
        System.out.println("PAWN: \n");
        ChessPiece b = new Pawn(ChessPiece.DOWN);

        int[][] bPath = b.getPossibleCollisions(2, 7, 2, 5);

        b.printPossibleCollisions(bPath, true);

        int[] b1 = {ChessBoard.xToCol(2), ChessBoard.yToRow(6)};
        int[] b2 = {ChessBoard.xToCol(2), ChessBoard.yToRow(5)};


        System.out.println("Expected: " + Arrays.toString(b1) + " " + Arrays.toString(b2));

        System.out.println(Arrays.toString(b.move(2, 7, 2, 5)));

        b.printPossibleCollisions(bPath, false);
        System.out.println("Expected: [2, 6], [2, 5]\n\n");
    }

    public static void testBishop() throws IllegalChessMoveException {
        System.out.println("BISHOP: \n");
        ArrayList<ChessPiece> pieces = new ArrayList<>();

        // Bishop
        pieces.add(new Bishop(ChessPiece.DOWN));
        System.out.println(Arrays.toString(pieces.get(0).move(5, 5, 7, 7)));
        int[][] path = pieces.get(0).getPossibleCollisions(5, 5, 7, 7);
        pieces.get(0).printPossibleCollisions(path, true);
        pieces.get(0).printPossibleCollisions(path, false);
        System.out.println("\n\n");

    }

    public static void testKing() throws IllegalChessMoveException {
        System.out.println("KING: \n");
        ChessPiece piece = new King(ChessPiece.DOWN);
        System.out.println("\n\n KING:");
        System.out.println(Arrays.toString(piece.move(5, 5, 5, 6)));
        System.out.println(Arrays.toString(piece.move(5, 5, 4, 5)));
        System.out.println(Arrays.toString(piece.move(5, 5, 6, 6)));

        // System.out.println(Arrays.toString(piece.move(5, 5, 3, 5))); To cause exception

        int[][] path = piece.getPossibleCollisions(5, 5, 6, 6);
        piece.printPossibleCollisions(path, true);
        System.out.println("Expected: [7, 1]");
        piece.printPossibleCollisions(path, false);
        System.out.println("Expected: [6, 6]\n\n");
    }

    public static void testKnight() throws IllegalChessMoveException{
        System.out.println("KNIGHT: \n");
        ChessPiece piece = new Knight(ChessPiece.DOWN);

        printMoveArray(piece.move(5, 5, 7, 6));
        printMoveArray(piece.move(5, 5, 7, 4));
        printMoveArray(piece.move(5, 5, 6, 7));
        printMoveArray(piece.move(5, 5, 4, 7));
        System.out.println("\n\n");

        int[][] path = piece.getPossibleCollisions(5, 5, 7, 6);
        piece.printPossibleCollisions(path, true);
        System.out.println("Expected: [" + ChessBoard.xToCol(7) + ", " + ChessBoard.yToRow(6) + "]");
        piece.printPossibleCollisions(path, false);
        System.out.println("Expected: [7, 6]\n\n");
    }

    public static void testQueen() throws IllegalChessMoveException {
        System.out.println("QUEEN: \n");
        ChessPiece piece = new Queen(ChessPiece.DOWN);

        printMoveArray(piece.move(5, 5, 7, 7));
        printMoveArray(piece.move(5, 5, 7, 5));
        printMoveArray(piece.move(5, 5, 5, 7));

        // printMoveArray(piece.move(5, 5, 4, 3)); Made to cause exception

        int[][] path = piece.getPossibleCollisions(3, 3, 7, 7);
        piece.printPossibleCollisions(path, true);
        System.out.println("Expected: [5, 3] -> [6, 2] -> [7, 1] -> [8, 0]");
        piece.printPossibleCollisions(path, false);
        System.out.println("Expected: [4, 4] -> [5, 5] -> [6, 6] -> [7, 7]\n\n");
    }

    public static void testRook() throws IllegalChessMoveException {
        System.out.println("ROOK: \n");
        ChessPiece piece = new Rook(ChessPiece.DOWN);

        printMoveArray(piece.move(5, 5, 5, 3));
        printMoveArray(piece.move(5, 5, 7, 5));
        printMoveArray(piece.move(5, 5, 3, 5));
        // printMoveArray(piece.move(5, 5, 5, 7)); Made to cause exception

        int[][] path = piece.getPossibleCollisions(5, 0, 5, 3);
        piece.printPossibleCollisions(path, true);
        System.out.println("Expected: [6, 6] -> [6, 5] -> [6, 4])");
        piece.printPossibleCollisions(path, false);
        System.out.println("Expected: [5, 1] -> [5, 2] -> [5, 3]\n\n");
    }
    public static void main(String[] args) throws IllegalChessMoveException {
        // All tested - take as many as you need out and try it out
        /* testPawn();
        testBishop();
        testKing();
        testKnight();
        testQueen();

        testRook();

         */








    }
}
