import java.util.*;

public abstract class ChessPiece {
    private String name;

    // Determines which way piece considers "forward"
    // Only matters for pieces that only move some direction forward

    /* Honestly thought this would matter a whole lot more than
    it did; next time I'll probably just make direction a var for
    pawn and rook
     */
    int direction;

    // Based on indices - up and left mean going negative dir,
    // ... down and right mean positive
    public static int UP = -1;
    public static int LEFT = -1;

    public static int RIGHT = 1;
    public static int DOWN = 1;


    public ChessPiece(String newName, int newDir) {
        name = newName;
        direction = newDir;
    }
// Gives piece's new location as [col, row]
    public abstract int[] move(int x, int y, int newX, int newY) throws IllegalChessMoveException;

    /* Gives places where pieces COULD get in each other's way
    as array of [col, row]
     */

    public abstract int[][] getPossibleCollisions(int x, int y, int newX, int newY);

    /* Prints list of possible collisions

    Note - If you want to see possible collision spots in terms of
    [col, row], set truePath to true

    If you want to see possible collision spots in terms of
    (x, y), set truePath to false
     */
    public void printPossibleCollisions(int[][] path, boolean truePath) {

        // Case, print in terms of (x, y)
        if (truePath == false) {

            // Converts path from (col, row) to (x, y)
            for (int index = 0; index < path.length; index++) {
                path[index][0] = ChessBoard.colToX(path[index][0]);
                path[index][1] = ChessBoard.rowToY(path[index][1]);
            }
        }

        // Prints out path
        System.out.print(Arrays.toString(path[0]));
        for (int index = 1; index < path.length; index++) {
            System.out.print(" -> " + Arrays.toString(path[index]));
        }


        System.out.println();

        }

        // Getters, setters, toString
    public String getName() {return name;}
    public void setName(String update) {name = update;}

    public int getDirection(){return direction;}
    public void setDirection(int update) {direction = update;};

    public String toString() {
        return name;
    }
}
