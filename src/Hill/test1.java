package Hill;
import java.util.Arrays;
import java.util.Scanner;

public class test1 {
private static double determinant(double[][] matrix) {
       
        // Utilisation de la règle de Sarrus pour calculer le déterminant
        double det = matrix[0][0] * matrix[1][1] * matrix[2][2]
            + matrix[0][1] * matrix[1][2] * matrix[2][0]
            + matrix[0][2] * matrix[1][0] * matrix[2][1]
            - matrix[0][2] * matrix[1][1] * matrix[2][0]
            - matrix[0][1] * matrix[1][0] * matrix[2][2]
            - matrix[0][0] * matrix[1][2] * matrix[2][1];
        return det;
    }
private static double[][] minor(double[][] matrix, int row, int col) {
    double[][] minorMatrix = new double[2][2];

    int minorRow = 0, minorCol;
    for (int i = 0; i < 3; i++) {
        if (i != row) {
            minorCol = 0;
            for (int j = 0; j < 3; j++) {
                if (j != col) {
                    minorMatrix[minorRow][minorCol] = matrix[i][j];
                    minorCol++;
                }
            }
            minorRow++;
        }
    }
    return minorMatrix;
}
private static double[][] adjoint(double[][] matrix) {
    double[][] adjointMatrix = new double[3][3];
    int i=0,j=0;
    // Calcul des cofacteurs pour la matrice adjointe
    for (int a = 0; a < 3; a++) {
        for (int b = 0; b < 3; b++) {
            double cofactor = Math.pow(-1, a + b) * determinant(minor(matrix, i, j));
            adjointMatrix[j][i] = cofactor;  // Transposer les cofacteurs
        }
    }
    return adjointMatrix;
}
public static void main(String[] args) {
	double[][] keyMatrix = {
            {2.0 , 1.0 , 1.0 },
            {1.0 , 3.0 , 2.0 },
            {1.0 , 0.0 , 0.0 } };
	System.out.println("Texte  : " + determinant(keyMatrix));
	System.out.println("Texte  : " + adjoint(keyMatrix));
}
}