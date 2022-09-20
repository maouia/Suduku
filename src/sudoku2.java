public class sudoku2 {
    public static void main(String[] args) {
        int [][] matrix = new int[][]
                {
                        {5, 3 ,4 ,6, 7 ,8 ,9, 1 ,2},
                        {6 ,7 ,2, 1, 9, 5, 8, 3 ,4},
                        {1 ,9 ,8 ,3 ,4, 2, 5, 6, 7},
                        {8, 1 ,9, 7 ,6 ,4 ,2 ,5, 3},
                        {4,2 ,6 ,8 ,5 ,3, 7, 9, 1},
                        {7 ,5 ,3 ,9 ,2, 1, 4 ,8 ,6},
                        {9, 6 ,5 ,2 ,3, 7 ,1 ,4 ,8},
                        {3, 8, 7, 4 ,1 ,9, 6, 2 ,5},
                        {2, 4, 1, 5 ,8 ,6 ,3 ,7,9},
                };

        if(SolveSuduko(matrix, 9)){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }

    }

    public static boolean SolveSuduko(int [][]matrix, int n){
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if(rowIndex != -1){
                break;
            }

        }
        if(i == n && j == n){
            return  true;
        }
        else {
            for (int value = 1; value < 10; value++) {
                if(IsSafe(matrix, value, rowIndex, columnIndex, n)){
                    matrix[rowIndex][columnIndex] = value;
                    if(!SolveSuduko(matrix,n)){
                        matrix[rowIndex][columnIndex] = 0;
                    }
                    else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean IsSafe(int [][] matrix, int value, int rowIndex, int columnIndex, int n){
        //row check
        for (int j = 0; j < 9; j++) {
            if(matrix[rowIndex][j] == value){
                return  false;
            }
        }
        //column check
        for (int i = 0; i < 9; i++) {
            if(matrix[i][columnIndex] == value){
                return  false;
            }
        }
        //submatrix check
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columnIndex - (columnIndex % 3);
        for (int i = baseRowIndex; i < baseRowIndex + 3; i++) {
            for (int j = baseColumnIndex; j < baseColumnIndex + 3; j++) {
                if(matrix[i][j] == value){
                    return  false;
                }

            }
        }
        return true;
    }
}
