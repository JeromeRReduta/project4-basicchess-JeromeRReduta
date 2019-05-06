import java.nio.file.Path;

public class NewExceptionDemo {
    public static void main(String[] args) throws OutofBoardException, IllegalChessMoveException, PathwayException {

        OutofBoardException outOfBoard = new OutofBoardException("Piece moving off of board");
        IllegalChessMoveException illegalChessMove = new IllegalChessMoveException("Piece moving incorrectly");
        PathwayException badPathway = new PathwayException("Another piece in the way of this piece");


        // Uncomment to test as desired:

        // throw outOfBoard;
        // throw illegalChessMove;
        // throw badPathway;


    }
}
