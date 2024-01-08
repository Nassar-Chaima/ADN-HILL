package Hill;

import java.util.Arrays;
import java.util.Scanner;

public class test {
	// Méthode pour calculer le déterminant d'une matrice 3x3
	private static final int MATRIX_SIZE = 3;
    public static double[][] inverseMatrix(double[][] matrix) {
        double det = determinant(matrix);
        if (det == 0) {
            // La matrice n'est pas inversible
            return null;
        }
        double[][] adjointMatrix = adjoint(matrix);
        // Calcul de l'inverse en divisant la matrice adjointe par le déterminant
        double[][] inverseMatrix = new double[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseMatrix[i][j] = adjointMatrix[i][j] / det;
            }
        }
        return inverseMatrix;
}
// Méthode pour calculer le déterminant d'une matrice 3x3

private static double determinant(double[][] matrix) {
        double det = 0;
        // Utilisation de la règle de Sarrus pour calculer le déterminant
        det = matrix[0][0] * matrix[1][1] * matrix[2][2]
            + matrix[0][1] * matrix[1][2] * matrix[2][0]
            + matrix[0][2] * matrix[1][0] * matrix[2][1]
            - matrix[0][2] * matrix[1][1] * matrix[2][0]
            - matrix[0][1] * matrix[1][0] * matrix[2][2]
            - matrix[0][0] * matrix[1][2] * matrix[2][1];
        return det;
    }
// Méthode pour calculer la matrice adjointe d'une matrice 3x3
private static double[][] adjoint(double[][] matrix) {
        double[][] adjointMatrix = new double[3][3];
        // Calcul des cofacteurs pour la matrice adjointe
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double cofactor = Math.pow(-1, i + j) * determinant(minor(matrix, i, j));
                adjointMatrix[j][i] = cofactor;  // Transposer les cofacteurs
            }
        }
        return adjointMatrix;
}

// Méthode pour obtenir la sous-matrice mineure d'une matrice 3x3
private static double[][] minor(double[][] matrix, int row, int col) {
        double[][] minorMatrix = new double[2][2];

        int minorRow = 0, minorCol = 0;
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
public static void main(String[] args) {
    // Étape 1: Demander à l'utilisateur d'entrer le texte à chiffrer
    	double[][] keyMatrixd = {
                {1/3, 1/6, 1/3},
                {-1/6, 1/6, -1/3},
                {-1/6, 1/3, 1/6}
                
        };
    	int[][] keyMatrix = {
                {2, 1, 1},
                {1, 3, 2},
                {1, 0, 0}
        };
    	System.out.print((double) keyMatrix[0][0]);
        }}
