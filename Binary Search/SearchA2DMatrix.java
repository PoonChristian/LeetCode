// LeetCode 74: Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = (m * n) - 1;
        
        while (left <= right) {
            // Mid represents the index of the middle element if it were in a 1D array
            int mid = left + (right - left) / 2;
            
            /*
                To get the element in a 2D array, use the following calculation
                rowIndex = mid / numColumns
                colIndex = mid % numColumns
            
                Why does this work intuitively?
                --> Because a 1D index with respect to a matrix just wraps around the last column to the next row

                Consider the below matrix where each index is mapped to its corresponding value.
                0 1 2 3
                4 5 6 7

                In order to get the row in the matrix, we want to take index / 4 because every row has 4 columns

                In order to get the column in the matrix, we want to take index % 4 because the index just wraps around the last column to the next row
                The column of index 0 is the same as the column of index 4. The column of index 1 is the same as index 5, etc.

                How would we convert a 2D index back to 1D?
                --> We would just do the opposite
                
                To break it down with the same matrix below, say we have matrix[1][1] so rowIndex is 1 and colIndex is 1, which would be value 5
                0 1 2 3
                4 5 6 7

                The rowIndex indicates how many columns we've crossed. Since we're on row 1, we crossed 4 columns from row 0. This mean we want to take (rowIndex * numCols)
                The colIndex indicates how many steps we've moved ahead from the start of the row. This would simply just be adding colIndex (+ colIndex)
                Putting this together, to get the 1D index, we use the formula (rowIndex * numCols) + colIndex
            */
            int midElement = matrix[mid / n][mid % n];
            
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
