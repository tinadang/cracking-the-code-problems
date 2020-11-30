public class SetRowAndColumnToZero {
    public static void main(String[] args) {
        int[][] test1 = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}};

        printTwoDimensionalArray(test1);
        System.out.println();
        setZeros(test1);
        printTwoDimensionalArray(test1);
    }


    public static void setZeros(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        // Store which rows and columns contain zeros
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Go through the matrix again to converts rows and columns into zeros
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                // If the row or column contains a zero, make the value zero
                if (row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }         
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
