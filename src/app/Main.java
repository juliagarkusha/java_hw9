package app;

public class Main {

    static int [][] multiArr;
    static int oddRowsSum;
    static int evenRowsSum;
    static long evenColumnProduct;
    static long oddColumnProduct;
    static int rowKey;
    static int colKey;

    public static void main(String[] args) {

        rowKey = 0;
        oddRowsSum = 0;
        evenRowsSum = 0;
        evenColumnProduct = 1;
        oddColumnProduct = 1;

        multiArr = new int[][] {
            {3, 32, 11, 15},
            {21, 15, 29, 5},
            {14, 8, 10, 2},
            {33, 28, 14, 5},
        };

        System.out.println("Матриця 4x4: ");

        for (int[] arrItem: multiArr) {
            colKey = 0;

            for (int number: arrItem) {
                System.out.print(number + " ");

                if (rowKey % 2 == 0) {
                    evenRowsSum += number;
                } else {
                    oddRowsSum += number;
                }

                if (colKey % 2 == 0) {
                    evenColumnProduct *= number;
                } else {
                    oddColumnProduct *= number;
                }

                colKey++;
            }

            System.out.println();
            rowKey++;
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + evenRowsSum);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + oddRowsSum);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + evenColumnProduct);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + oddColumnProduct);

        if (isMagicSquare(multiArr)) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    static boolean isMagicSquare(int[][] matrix) {
        int size = matrix.length;
        int sum = 0;
        int diag1Sum = 0;
        int diag2Sum = 0;

        for (int number : matrix[0]) {
            sum += number;
        }

        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < size; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }

            if (rowSum != sum || colSum != sum) {
                return false;
            }

            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][size - i - 1];
        }

        return diag1Sum == sum && diag2Sum == sum;
    }
}
