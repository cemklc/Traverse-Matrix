package Traverse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clockwise Traversal of an Integer Array
 *
 * @author Selahattin Cem Kılıç
 */

public class Traverse {

    public static final Logger logger
            = Logger.getLogger(
            Traverse.class.getName());

    public static void main(String[] args) {

        int[][] matrix;
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(traverse(matrix));
    }

    /**
     * Traverses the given 2-D array in the clockwise direction
     * Doesn't modify the original matrix
     * Returns an empty list if the given matrix is not valid
     *
     * O(row x column) time and O(row x column) memory complexity
     *
     * @return List of matrix elements traversed in the clockwise direction
     *
     *  TODO: A nice to implement this with Generics to support other types.
     *        Memory complexity can be reduced by not returning the result array
     *        but it makes testing more complex
     *
     */

    public static List<Integer> traverse(int[][] matrix) {


        if (!isArrayValid(matrix)) {
            logger.log(Level.WARNING, "Can't validate input Matrix");
            return List.of();
        }

        Directions currentDirection = Directions.RIGHT;

        // Set initial boundaries for the given matrix
        int topBoundary = 0;
        int bottomBoundary = matrix.length - 1;
        int leftBoundary = 0;
        int rightBoundary = matrix[0].length - 1;
        int i;

        List<Integer> result = new ArrayList<>();
        logger.log(Level.INFO, "Starting to traverse the matrix...");

        // traverse the matrix clockwise direction on the boundaries
        while (topBoundary <= bottomBoundary && leftBoundary <= rightBoundary) {
            if (currentDirection == Directions.RIGHT) {
                for (i = leftBoundary; i <= rightBoundary; i++) {
                    result.add(matrix[topBoundary][i]);
                }
                topBoundary += 1;
            }
            if (currentDirection == Directions.DOWN) {
                for (i = topBoundary; i <= bottomBoundary; i++) {
                    result.add(matrix[i][rightBoundary]);
                }
                rightBoundary -= 1;
            }
            if (currentDirection == Directions.LEFT) {
                for (i = rightBoundary; i >= leftBoundary; i--) {
                    result.add(matrix[bottomBoundary][i]);
                }
                bottomBoundary -= 1;
            }
            if (currentDirection == Directions.UP) {
                for (i = bottomBoundary; i >= topBoundary; i--) {
                    result.add(matrix[i][leftBoundary]);
                }
                leftBoundary += 1;
            }

            currentDirection = changeDirectionClockwise(currentDirection);

        }
        logger.log(Level.INFO, "Finished traversing the matrix...");
        return result;
    }

    /**
     * Checks if the matrix is valid
     *
     * Returns true if the matrix is valid, false otherwise
     *
     * @return Validity of the matrix
     */

    protected static boolean isArrayValid(int[][] matrix) {

        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0].length == 0) {
            logger.log(Level.WARNING, "There are empty elements in the matrix...");
            return false;
        }
        int rowLength = matrix[0].length;

        for (int[] row : matrix) {
            if (row.length != rowLength) {
                logger.log(Level.WARNING, "The matrix has uneven dimensions...");
                return false;
            }
        }
        return true;
    }

    protected static Directions changeDirectionClockwise(Directions direction){
        // Change the direction when reached to a boundary in clockwise format
        switch (direction) {
            case RIGHT:
                direction = Directions.DOWN;
                break;
            case DOWN:
                direction = Directions.LEFT;
                break;
            case LEFT:
                direction = Directions.UP;
                break;
            case UP:
                direction = Directions.RIGHT;
                break;

            default:
                direction = Directions.RIGHT;
        }
        return direction;
    }

    enum Directions {
        RIGHT,
        DOWN,
        LEFT,
        UP,
    }
}
