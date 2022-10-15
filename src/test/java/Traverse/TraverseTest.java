package Traverse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static Traverse.Traverse.*;
import static org.junit.jupiter.api.Assertions.*;

class TraverseTest {
    @Test
    public void testTraverse() {

        int[][] matrix;
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        traverse(matrix);
        Integer[] res = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};

        assertEquals(List.of(res), traverse(matrix));
    }

    @Test
    public void testTraverseRows() {

        int[][] matrix;
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
        };
        traverse(matrix);
        Integer[] res = {1, 2, 3, 4, 8, 7, 6, 5};

        assertEquals(List.of(res), traverse(matrix));

        matrix = new int[][]{
                {1, 2, 3, 4},
        };
        traverse(matrix);
        res = new Integer[]{1, 2, 3, 4};

        assertEquals(List.of(res), traverse(matrix));
    }

    @Test
    public void testTraverseCols() {

        int[][] matrix;
        matrix = new int[][]{
                {1, 2},
                {6, 3},
                {5, 4},
        };
        traverse(matrix);
        Integer[] res = {1, 2, 3, 4, 5, 6};

        assertEquals(List.of(res), traverse(matrix));

        matrix = new int[][]{
                {1},
                {2},
                {3},
                {4},
        };
        traverse(matrix);
        res = new Integer[]{1, 2, 3, 4};

        assertEquals(List.of(res), traverse(matrix));
    }

    @Test
    public void testTraverseBrokenArray() {

        int[][] matrix;
        matrix = new int[][]{
                {1, 2, 3},
                {6, 3, 7, 8},
                {5, 4},
        };

        assertEquals(List.of(), traverse(matrix));
    }

    @Test
    public void testTraverseEmptyInputs() {
        int[][] matrix = null;
        assertEquals(List.of(), traverse(matrix));

        matrix = new int[0][0];
        assertEquals(List.of(), traverse(matrix));

        matrix = new int[5][0];
        assertEquals(List.of(), traverse(matrix));

    }

    @Test
    public void testIsArrayValid() {
        int[][] matrix = null;
        assertFalse(isArrayValid(matrix));

        matrix = new int[0][0];
        assertFalse(isArrayValid(matrix));

        matrix = new int[5][0];
        assertFalse(isArrayValid(matrix));

        matrix = new int[][]{
                {1, 2, 3},
                {6, 3, 7, 8},
                {5, 4},
        };
        assertFalse(isArrayValid(matrix));

        matrix = new int[][]{
                {1, 2},
                {6, 3},
                {5, 4},
        };
        assertTrue(isArrayValid(matrix));

        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        assertTrue(isArrayValid(matrix));

        matrix = new int[][]{
                {1},
                {1},
                {1},
                {1}
        };
        assertTrue(isArrayValid(matrix));

        matrix = new int[][]{
                {1, 2},
                {1},
                {1},
                {1}
        };
        assertFalse(isArrayValid(matrix));

        matrix = new int[][]{};
        assertFalse(isArrayValid(matrix));
    }
}