public class lab1 {
    public static void main(String[] args) {
        int num = 23; // student number
        int c5 = num % 5; // 3 => A XOR B
        int c7 = num % 7; // 2 => short
        int c11 = num % 11; // 1 => sum of min elements from rows

        short[][] matrix1 = {   
            {1, 2},
            {3, 4},
            // {9, 10}
        };
        short[][] matrix2 = {
            {5, 6},
            {7, 8},
            // {11, 12}
        };

        short[][] result = XOR(matrix1, matrix2);
        System.out.println("Step 1, after XOR:");
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        short sum = sumOfMinElements(result);
        System.out.println("Step 2, sum of min elements in each row: " + sum);
    }

    public static short[][] XOR(short[][] A, short[][] B) {
        if (A.length == B.length && A[0].length == B[0].length) {
            short[][] C = new short[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = (short) (A[i][j] ^ B[i][j]);
                }
            }
            return C;
        }
        else {
            System.out.println("Matrices have different sizes");
            return null;
        }
    }

    public static short sumOfMinElements(short[][] matrix) {
        short sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            short min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sum += min;
        }
        return sum;
    }
}