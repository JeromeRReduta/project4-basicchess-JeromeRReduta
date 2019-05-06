import java.util.*;

public class ChessBoardDemo {

    public static void main(String[] args) throws OutofBoardException, PathwayException, IllegalChessMoveException {
         ChessBoard a = new ChessBoard();

        System.out.println(a + "\n\n");
        System.out.println(ChessBoard.xToCol(7) + "" + ChessBoard.yToRow(7));



    }
}
