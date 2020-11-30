public class RotateMatrix {
    public static void main(String[] args) {
        int[][] test1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        printTwoDimensionalArray(test1);
        System.out.println("\n");
        rotateMatrix(test1, 4);
        printTwoDimensionalArray(test1);
    }

    public static void rotateMatrix(int[][] matrix, int n) {
        for (int row=0; row < n/2; row++) {
            // Obtains the last index (column) for the row
            int last = n - 1 - row;
            for (int col=row; col < last; col++) {
                // Offset for positions (Figure out what this means...)
                int offset = col - row;

                // Saves the top left value
                int leftTop = matrix[row][col];

                // Sets the top left to the bottom left value
                matrix[row][col] = matrix[last-offset][row];
                
                // Sets the bottom left to the right bottom value
                matrix[last-offset][row] = matrix[last][last-offset];

                // Sets the right bottom to the top right value
                matrix[last][last-offset] = matrix[col][last];
                
                // Sets the top right to the the top left value
                matrix[col][last] = leftTop;
                
                // System.out.println("Row #: " + row);
                // System.out.println("Start index: " + col);
                // System.out.println("Last index: " + last);
                // System.out.println("Offset: " + offset);
                // System.out.println("Last - offset: " + (last - offset) + "\n");
            
            }
        }
    }

    public static void printTwoDimensionalArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }
    
}
