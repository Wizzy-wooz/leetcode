package leetcode_challenges.april.day21;

import java.util.ArrayList;
import java.util.List;

public class LC0LeftmostColumnWithAtLeastAOne {
//    A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
//
//    Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
//
//    You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
//
//            BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
//            BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
//    Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//    For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

//    Example 1:
//
//    Input: mat = [[0,0],[1,1]]
//    Output: 0

//    Example 2:
//
//    Input: mat = [[0,0],[0,1]]
//    Output: 1
//    Example 3:
//
//    Input: mat = [[0,0],[0,0]]
//    Output: -1
//    Example 4:
//
//    Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
//    Output: 1
//
//    Constraints:
//
//    rows == mat.length
//    cols == mat[i].length
//1 <= rows, cols <= 100
//    mat[i][j] is either 0 or 1.
//    mat[i] is sorted in a non-decreasing way.

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if(binaryMatrix.dimensions() == null ||
                binaryMatrix.dimensions().get(0) == null ||
                binaryMatrix.dimensions().get(1) == null ||
                binaryMatrix.dimensions().get(0) == 0)
            return -1;

        int row = binaryMatrix.dimensions().get(0); //max length of rows
        int col = binaryMatrix.dimensions().get(1); //max length of columns


        int m = 0;  //starting position for the rows
        int n = col-1; //starting position for the column -> we are in the top right corner of the matrix

        while (m < row && n >= 0) {

            if(binaryMatrix.get(m, n) == 1)
                n--;						//if found 1 step minus one in column
            else
                m++;						//else step 1 row down

        }
        return n != col -1 ? n + 1 : -1; //if we are still in the rightmost column there is no 1 in the matrix, otherwise the leftmost 1 is on step forward (really we step back and undo the last n--) in the current column
    }
}

class Matrix implements BinaryMatrix{
    private int[][] binaryMatrix;
    private int n;
    private int m;

    public Matrix(int[][] binaryMatrix) {
        super();
        this.binaryMatrix = binaryMatrix;
        this.n = binaryMatrix.length;
        this.m = binaryMatrix[0].length;
    }

    @Override
    public int get(int x, int y) {
        if((x < 0 || y < 0) || (x >= n || y >= m)) return Integer.MIN_VALUE;
        return binaryMatrix[x][y];
    }

    @Override
    public List<Integer> dimensions() {
        List<Integer> resList = new ArrayList<>();
        resList.add(n);
        resList.add(m);
        return resList;
    }
}


