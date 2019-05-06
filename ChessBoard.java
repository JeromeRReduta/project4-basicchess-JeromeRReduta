import java.util.*;

public class ChessBoard {
    ChessPiece[][] board = new ChessPiece[9][9];

    public ChessBoard() { }

    //IMPORTANT: X, Y = coordinates as listed by board
    //        Col, Row = indices as taken by array

    /*
    Converts coordinates (x, y) as listed by board
    to indices array[index][i] taken by array

    Probably don't really need these but I kept getting
    confused with how to convert them so making these just
    made my life easier
     */
    public static int xToCol(int x) {
        return x + 1;
    }

    public static int colToX(int col) {
        return col - 1;
    }

    public static int yToRow(int y) {
        return 7 - y;
    }

    public static int rowToY(int row) {
        return 7 - row;
    }

    /* Given input, if input has > 3 strings, will move piece from
        first (x, y) to new (x, y)

        Else, makes piece at given (x, y)
     */
    public void update(String[] input) {
        printScannedLine(input);

        String word = input[0];
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);


        if (input.length > 3) {
            int newX = Integer.parseInt(input[3]);
            int newY = Integer.parseInt(input[4]);

            movePiece(x, y, newX, newY);
        }

        else {
            makePiece(word, x, y);
        }
    }

    // Prints scanned lineSegment, depending on length of
    // lineSegment
    private static void printScannedLine(String[] lineSegment) {

        // Case - asking piece to move (lineSegment has >3 strings)
        if (lineSegment.length > 3) {
            System.out.println("Move piece from " + "[" +
                    lineSegment[1] + ", " + lineSegment[2] +
                    "] to " + "[" + lineSegment[3] + ", " +
                    lineSegment[4] + "]");
        }

        // Case - asking to make piece (lineSegment has 3 strings)
        else {
            System.out.println("Place " + lineSegment[0] + " at " +
                    "[" + lineSegment[1] + ", " + lineSegment[2] +
                    "]");
        }
    }
    // Takes chessPiece name and (x, y) and makes
    // ... chessPiece w/ that type @ (x, y)
    private void makePiece(String word, int x, int y) {
        //int row = oldX + 1;
        //int col = 7 - oldY;

        int col = xToCol(x);
        int row = yToRow(y);

        int dir;
        ChessPiece piece = null;

        try {

            // Case: Piece out of board
            if (col < 1 || col > 8 || row < 0 || row > 7) {
                throw new OutofBoardException("Error - Piece out of board");
            }

            // Case: Piece @ top half of board
            if (row <= 3) {
                dir = ChessPiece.DOWN;
            }

            // Case: Piece @ bottom half of board
            else {
                dir = ChessPiece.UP;
            }


            // Creates piece w/ type of given string
             switch (word) {



                case "pawn":
                    piece = new Pawn(dir);
                    break;

                 case "bishop":
                     piece = new Bishop(dir);
                     break;

                 case "king":
                     piece = new King(dir);
                     break;

                 case "knight":
                     piece = new Knight(dir);
                     break;

                 case "queen":
                     piece = new Queen(dir);
                     break;

                 case "rook":
                     piece = new Rook(dir);
                     break;
            }

            // Sets part of array = to that piece
            board[col][row] = piece;

        } catch (OutofBoardException e) {
            System.out.println("Error - Piece cannot move off of board");
        } catch (Exception e) {
            System.out.println("Error - Unknown problem found");
        }
    }

    // Takes piece @ (x, y) and moves it to (newX, newY)
    private void movePiece(int x, int y, int newX, int newY) {
        int col = xToCol(x);
        int row = yToRow(y);

        ChessPiece piece = board[col][row];

        try {
            // Get destination of piece, w/ (x, y) coordinates
            int[] newLocation = piece.move(x, y, newX, newY);
            int newCol = newLocation[0];
            int newRow = newLocation[1];

            // Case: Trying to move piece off of board
            if (newCol < 1 || newCol > 8 || newRow < 0 || newRow > 7) {
                throw new OutofBoardException("Piece out of board");
            }

            // Get potential collision pts
            int[][] path = piece.getPossibleCollisions(x, y, newX, newY);

            // If any potential collision pt already has a piece,
            // ...given piece would have collided w/ that piece
            // ...In that case, don't move given piece, throw error
            for (int index = 0; index < path.length; index++) {
                int pathCol = path[index][0];
                int pathRow = path[index][1];

                if (board[pathCol][pathRow] != null) {
                    throw new PathwayException("Another piece is in the way");
                }
            }

            // Case: Everything goes fine
            // "Moves" piece from (x, y) to (newX, newY)
            board[col][row] = null;
            board[newCol][newRow] = piece;


        }

        catch(OutofBoardException e) {
            System.out.println(e.getMessage());
        }

        catch (PathwayException e) {
            System.out.println(e.getMessage());
        }

        catch (IllegalChessMoveException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Unexpected error happened");
            e.getStackTrace();
        }

    }

    // Creates board
    public String toString() {

        String message = "";


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                // Case: Bottom left conner
                if (col == 0 && row == 8) {
                    message += "===\t";
                }

                // Case: Left edge (besides bottom-left corner)
                else if (col == 0) {
                    message += "=" + (7 - row) + "=\t";
                }

                // Case: Bottom edge (besides bottom-left corner)
                else if (row == 8 & col > 0) {
                    message += "=" + (col-1) + "=\t";

                }

                // Case: The rest of the board
                else {

                    // Case: No piece here
                    if (board[col][row] == null) {
                        message += "---\t";
                    }

                    // Case: piece here
                    else {
                        message += "-" + board[col][row] + "-\t";
                    }
                }

            }
            message += "\n";
        }

        return message;
    }


}
