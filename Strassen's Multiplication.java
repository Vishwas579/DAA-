package aaa;
import java.util.Scanner;

public class sss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
        int[][] C = new int[2][2];

        System.out.println("Enter elements of Matrix A (2x2):");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter elements of Matrix B (2x2):");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                B[i][j] = sc.nextInt();

        // Calculate the 7 products
        int M1 = (A[0][0] + A[1][1]) * (B[0][0] + B[1][1]);
        int M2 = (A[1][0] + A[1][1]) * B[0][0];
        int M3 = A[0][0] * (B[0][1] - B[1][1]);
        int M4 = A[1][1] * (B[1][0] - B[0][0]);
        int M5 = (A[0][0] + A[0][1]) * B[1][1];
        int M6 = (A[1][0] - A[0][0]) * (B[0][0] + B[0][1]);
        int M7 = (A[0][1] - A[1][1]) * (B[1][0] + B[1][1]);

        // Calculate the resulting matrix C
        C[0][0] = M1 + M4 - M5 + M7;
        C[0][1] = M3 + M5;
        C[1][0] = M2 + M4;
        C[1][1] = M1 - M2 + M3 + M6;

        System.out.println("Resultant Matrix after Strassen's Multiplication:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(C[i][j] + "\t");
            System.out.println();
        }

        sc.close();
    }
}
