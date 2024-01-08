package Hill;
import java.util.Arrays;
import java.util.Scanner;

public class HillADN {
	private static String equivalent = "0";
// 1.1 Convertir le texte en binaire
    private static String textToBinary(String text) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String binaryLetter = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryString.append(binaryLetter);
        }
        return binaryString.toString();
    }
// 1.2 Convertir le texte en test en claire
    private static String binaryToText(String binaryText) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binaryText.length(); i += 8) {
            String byteStr = binaryText.substring(i, i + 8);
            int charCode = Integer.parseInt(byteStr, 2);
            text.append((char) charCode);
        }
        return text.toString();
    }
// 2.1 Convertir le texte binaire en texte ADN
    private static String binaryToDNA(String binaryText) {
        StringBuilder dnaText = new StringBuilder();
        for (int i = 0; i < binaryText.length(); i += 2) {
            String twoBits = binaryText.substring(i, i + 2);
            switch (twoBits) {
                case "00":
                    dnaText.append("A");
                    break;
                case "01":
                    dnaText.append("C");
                    break;
                case "10":
                    dnaText.append("G");
                    break;
                case "11":
                    dnaText.append("T");
                    break;
                default:
                    break;
            }
        }
        return dnaText.toString();
    }
// 2.2 Convertir le texte ADN en texte binary
    private static String DNAtoBinary(String DNAText) {
        StringBuilder binaryText = new StringBuilder();
        for (int i = 0; i < DNAText.length(); i++) {
            char nucleotide = DNAText.charAt(i);
            switch (nucleotide) {
                case 'A': binaryText.append("00");
                    break;
                case 'C':binaryText.append("01");
                    break;
                case 'G':binaryText.append("10");
                    break;
                case 'T':binaryText.append("11");
                    break;
                default:
                    break;
            }
        }
        return binaryText.toString();
    }
// 3.1 Convertir le texte ADN en ARNm
    private static String DNAToARNM(String DNAText) {
        StringBuilder rnmText = new StringBuilder();
        for (int i = 0; i < DNAText.length(); i++) {
            char transform = DNAText.charAt(i);
            switch (transform) {
                case 'A':
                    rnmText.append('U');
                    break;
                case 'T':
                    rnmText.append('A');
                    break;
                case 'C':
                    rnmText.append('G');
                    break;
                case 'G':
                    rnmText.append('C');
                    break;
                default:
                    break;
            }
        }
        return rnmText.toString();
    }
// 3.2 Convertir le texte ARNm en ADN
    private static String ARNMToDNA(String ARNMText) {
        StringBuilder dnaText = new StringBuilder();
        for (int i = 0; i < ARNMText.length(); i++) {
            char nucleotide = ARNMText.charAt(i);
            switch (nucleotide) {
                case 'U':dnaText.append('A');
                    break;
                case 'A':dnaText.append('T');
                    break;
                case 'G':dnaText.append('C');
                    break;
                case 'C':dnaText.append('G');
                    break;
                default:
                    break;
            }
        }
        return dnaText.toString();
    }
// 4.1 Convertir le texte ARNM en acides aminés
       private static String arnmToAminoAcids(String arnmText) {
           StringBuilder aminoAcidsText = new StringBuilder();

           // Découper le texte ARNM
           for (int i = 0; i < arnmText.length(); i += 3) {
               String codon = arnmText.substring(i, i + 3);
               // Comparer par table Amino Acid
               String aminoAcid = aminoAcid(codon);
               // Ajouter l'acide aminé au texte final
               aminoAcidsText.append(aminoAcid);
           }
           return aminoAcidsText.toString();
       }
       // Table Amino Acid
       private static String aminoAcid(String codon) {
           switch (codon) {
               case "GCU": equivalent="1" ; return "A";
                   case "GCC": equivalent="2" ; return "A";
                       case "GCA": equivalent="3" ; return "A";
                           case "GCG": equivalent="4" ; return "A";
               case "UUA": equivalent="1" ; return "L";
                   case "UUG": equivalent="2" ; return "L";
                       case "CUU": equivalent="3" ; return "L";
                           case "CUC": equivalent="4" ; return "L";
                               case "CUA": equivalent="5" ; return "L";
                                   case "CUG": equivalent="6" ; return "L";
               case "CGU": equivalent="1" ; return "R";
            	   case "CGC": equivalent="2" ; return "R";
            		   case "CGA": equivalent="3" ; return "R";
            			   case "CGG": equivalent="4" ; return "R";
            				   case "AGA": equivalent="5" ; return "R";
            					   case "AGG": equivalent="6" ; return "R";
               case "AAA": equivalent="1" ; return "K";
            	   case "AAG": equivalent="2" ; return "K";
               case "AAU": equivalent="1" ; return "N";
            	   case "AAC": equivalent="2" ; return "N";
               case "AUG": equivalent="1"; return "M";
               case "GAU": equivalent="1"; return "D";
            	   case "GAC": equivalent="2"; return "D";
               case "UUU": equivalent="1"; return "F";
            	   case "UUC": equivalent="2"; return "F";
               case "UGU": equivalent="1"; return "C";
            	   case "UGC": equivalent="2"; return "C";
               case "CCU": equivalent="1"; return "P";
            	   case "CCC": equivalent="2"; return "P";
            		   case "CCA": equivalent="3"; return "P";
            			   case "CCG": equivalent="4"; return "P";
               case "CAA": equivalent="1"; return "Q";
            	   case "CAG": equivalent="2"; return "Q";
               case "UCU": equivalent="1"; return "S";
            	   case "UCC": equivalent="2"; return "S";
            		   case "UCA": equivalent="3"; return "S";
            			   case "UCG": equivalent="4"; return "S";
            				   case "AGU": equivalent="5"; return "S";
            					   case "AGC": equivalent="6"; return "S";
               case "GAA": equivalent="1"; return "E";
            	   case "GAG": equivalent="2"; return "E";
               case "ACU": equivalent="1"; return "T";
            	   case "ACC": equivalent="2"; return "T";
            		   case "ACA": equivalent="3"; return "T";
            			   case "ACG": equivalent="4"; return "T";
               case "GGU": equivalent="1"; return "G";
            	   case "GGC": equivalent="2"; return "G";
            		   case "GGA": equivalent="3"; return "G";
            			   case "GGG": equivalent="4"; return "G";
               case "UGG": equivalent="1"; return "W";
               case "CAU": equivalent="1"; return "H";
            	   case "CAC": equivalent="2"; return "H";
               case "UAU": equivalent="1"; return "Y";
            	   case "UAC": equivalent="2"; return "Y";
               case "AUU": equivalent="1"; return "I";
            	   case "AUC": equivalent="2"; return "I";
            		   case "AUA": equivalent="3"; return "I";
               case "GUU": equivalent="1"; return "V";
            	   case "GUC": equivalent="2"; return "V";
            		   case "GUA": equivalent="3"; return "V";
            			   case "GUG": equivalent="4"; return "V";
               case "UAA": equivalent="1"; return "";
            	   case "UGA": equivalent="2"; return "";
            		   case "UAG": equivalent="3"; return "";
               default: return ".";
           }
       }
// 4.2 Convertir le texte  acides aminés en ARNm
       private static String aminoAcidsToARNM(String aminoAcidsText) {
           StringBuilder arnmText = new StringBuilder();
           // Découper le texte d'Acides aminés
           for (int i = 0; i < aminoAcidsText.length(); i += 6) {
               String aminoAcid = aminoAcidsText.substring(i, i + 6);
               // Comparer par la table Amino Acid pour obtenir le codon ARNm
               String daminoAcid = DaminoAcid(aminoAcid);
               // Ajouter le codon ARNm au texte final
               arnmText.append(daminoAcid);
           }
           return arnmText.toString();
       }
       // Table Inverse Amino Acid
       private static String DaminoAcid(String codon) {
    	   switch (codon) {
           case "A": if(equivalent == "1"){ return "GCU"; }
                     if(equivalent == "2"){ return "GCC";}
                     if(equivalent == "3"){ return "GCA";}
                     if(equivalent == "4"){ return "GCG";}
           case "L": if(equivalent == "1"){ return "UAA"; }
           			 if(equivalent == "2"){ return "UUG";}
                     if(equivalent == "3"){ return "CUU";}
                     if(equivalent == "4"){ return "CUC";}
                     if(equivalent == "5"){ return "CUA";}
                     if(equivalent == "6"){ return "CUG";}
           case "R": if(equivalent == "1"){ return "CGU"; }
 			         if(equivalent == "2"){ return "CGC";}
 			         if(equivalent == "3"){ return "CGA";}
 			         if(equivalent == "4"){ return "CGG";}
 			         if(equivalent == "5"){ return "AGA";}
 			         if(equivalent == "6"){ return "AGG";}
           case "K": if(equivalent == "1"){ return "AAA"; }
           			 if(equivalent == "2"){ return "AAG";}     
           case "N": if(equivalent == "1"){ return "AAU"; }
                     if(equivalent == "2"){ return "AAC";}
           case "M": if(equivalent == "1"){ return "AUG"; }
           case "D": if(equivalent == "1"){ return "GAU"; }
                     if(equivalent == "2"){ return "GAC";}
           case "F": if(equivalent == "1"){ return "UUU"; }
                     if(equivalent == "2"){ return "UUC";}
           case "C": if(equivalent == "1"){ return "UGU"; }
                     if(equivalent == "2"){ return "UGC";}
           case "P": if(equivalent == "1"){ return "CCU"; }
	                 if(equivalent == "2"){ return "CCC";}
	                 if(equivalent == "3"){ return "CCA";}
	                 if(equivalent == "4"){ return "CCG";}
           case "Q": if(equivalent == "1"){ return "CAA"; }
           			 if(equivalent == "2"){ return "CAG";}       
           case "S": if(equivalent == "1"){ return "UCU"; }
           			 if(equivalent == "2"){ return "UCC";}
           			 if(equivalent == "3"){ return "UCA";}
           			 if(equivalent == "4"){ return "UCG";}
           			 if(equivalent == "5"){ return "AGU";}
           			 if(equivalent == "6"){ return "AGC";} 
           case "E": if(equivalent == "1"){ return "GAA"; }
 			 		 if(equivalent == "2"){ return "GAG";}
           case "T": if(equivalent == "1"){ return "ACU"; }
 			 		 if(equivalent == "2"){ return "ACC";}
 			 		 if(equivalent == "3"){ return "ACA";}
 			 		 if(equivalent == "4"){ return "ACG";}	 
           case "G": if(equivalent == "1"){ return "GGU"; }
 			         if(equivalent == "2"){ return "GGC";}
 			         if(equivalent == "3"){ return "GGA";}
 			         if(equivalent == "4"){ return "GGG";}
           case "W": if(equivalent == "1"){ return "UGG"; }
           case "H": if(equivalent == "1"){ return "CAU"; }
	                 if(equivalent == "2"){ return "CAC";}
           case "Y": if(equivalent == "1"){ return "UAU"; }
	                 if(equivalent == "2"){ return "UAC";}
           case "I": if(equivalent == "1"){ return "AUU"; }
           			 if(equivalent == "2"){ return "AUC";}
           			 if(equivalent == "3"){ return "AUA";}
           case "V": if(equivalent == "1"){ return "GUU"; }
	                 if(equivalent == "2"){ return "GUC";}
	                 if(equivalent == "3"){ return "GUA";}
	                 if(equivalent == "4"){ return "GUG";}
           case "": if(equivalent == "1"){ return "UAA"; }
	                if(equivalent == "2"){ return "UGA";}
	                if(equivalent == "3"){ return "UAG";}
           default:
               return ".";
       }
       }
// 5.1 Appliquer l'algorithme de hill pour le chiffrement
    private static final int MATRIX_SIZE = 3;
    // Effectuer le chiffrement Hill-ADN
private static String hillADNCipher(String plaintext, int[][] keyMatrix) {
    // Étape 1: Conversion du texte clair en binaire 8-bit
    String binaryText = textToBinary(plaintext);
    System.out.println("Texte binaire 8-bit: " + binaryText);

    // Étape 2: Transformation des données sous la forme ADN
    String dnaText = binaryToDNA(binaryText);
    System.out.println("Texte ADN: " + dnaText);

    // Étape 3: Transformation des données sous la forme ARNm
    String arnmText = DNAToARNM(dnaText);
    System.out.println("Texte ARNm: " + arnmText);

    // Étape 4: Passage des données à la table d'Acides aminésf
    String aminoAcidsText = arnmToAminoAcids(arnmText);
    System.out.println("Texte Acides Aminés: " + aminoAcidsText);

    // Étape 5: Chiffrement avec l'algorithme de Hill
    String ciphertext = hillCipherEncrypt(aminoAcidsText, keyMatrix);
    System.out.println("Texte chiffré: " + ciphertext);

    return ciphertext;
}
	public static String hillCipherEncrypt(String plaintext, int[][] keyMatrix) {
        // Assurez-vous que la longueur du texte est un multiple de la taille de la matrice
        int padding = MATRIX_SIZE - (plaintext.length() % MATRIX_SIZE);
        if (padding != MATRIX_SIZE) {
            for (int i = 0; i < padding; i++) {
                plaintext += 'X'; // Ajoute 'X' pour le padding
            }
        }
        StringBuilder ciphertext = new StringBuilder();
        // Applique l'algorithme de chiffrement par blocs
        for (int i = 0; i < plaintext.length(); i += MATRIX_SIZE) {
            String block = plaintext.substring(i, i + MATRIX_SIZE);
            int[] blockVector = new int[MATRIX_SIZE];

            // Convertit le bloc en vecteur numérique
            for (int j = 0; j < MATRIX_SIZE; j++) {
                blockVector[j] = block.charAt(j) - 'A'; // Supposons des majuscules
            }

            // Applique la transformation avec la matrice clé
            int[] resultVector = multiplyMatrix(keyMatrix, blockVector);

          // Convertit le résultat en texte chiffré
            for (int j = 0; j < MATRIX_SIZE; j++) {
                char encryptedChar = (char) ((resultVector[j] % 26) + 'A');
                ciphertext.append(encryptedChar);
            }
        }

        return ciphertext.toString();
    }
    private static int[] multiplyMatrix(int[][] matrix, int[] vector) {
        int[] result = new int[MATRIX_SIZE];

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        return result;
    }
// 5.2 Appliquer l'algorithme de hill pour le déchiffrement
 // Méthode pour calculer le déterminant d'une matrice 3x3
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

    public static double[][] inverseMatrix(double[][] matrix) {
    	double det = determinant(matrix);
        if (det == 0) {
            // La matrice n'est pas inversible
            return null;
        }
        double[][] adjointMatrix = adjoint(matrix);
        double[][] inverseMatrix = new double[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseMatrix[i][j] = adjointMatrix[i][j] / det;
            }
        }
        return inverseMatrix;
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
    public static String hillCipherDecrypt(String ciphertext, double[][] inverseKeyMatrix) {
        // Assurez-vous que la longueur du texte est un multiple de la taille de la matrice
        int padding = MATRIX_SIZE - (ciphertext.length() % MATRIX_SIZE);
        if (padding != MATRIX_SIZE) {
            for (int i = 0; i < padding; i++) {
                ciphertext += 'X'; // Ajoute 'X' pour le padding
            }
        }
        StringBuilder plaintext = new StringBuilder();
        // Applique l'algorithme de déchiffrement par blocs
        for (int i = 0; i < ciphertext.length(); i += MATRIX_SIZE) {
            String block = ciphertext.substring(i, i + MATRIX_SIZE);
            int[] blockVector = new int[MATRIX_SIZE];

            // Convertit le bloc en vecteur numérique
            for (int j = 0; j < MATRIX_SIZE; j++) {
                blockVector[j] = block.charAt(j) - 'A'; // Supposons des majuscules
            }

            // Applique l'inverse de la matrice clé à l'inverse du vecteur résultant
            double [] resultVector = multiplyMatrixInv(inverseKeyMatrix, blockVector);

            // Convertit le résultat en texte déchiffré
            for (int j = 0; j < MATRIX_SIZE; j++) {
                char decryptedChar = (char) ((resultVector[j] % 26) + 'A');
                plaintext.append(decryptedChar);
            }
        }

        return plaintext.toString();
    }
    private static double[] multiplyMatrixInv(double[][] inverseKeyMatrix, int[] vector) {
        double[] result = new double[MATRIX_SIZE];

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                result[i] += inverseKeyMatrix[i][j] * vector[j];
            }
        }

        return result;
    }

// Effectuer le déchiffrement Hill-ADN
    private static String hillADNDecipher(String encryptedText, double[][] inverseKeyMatrix) {
    	// Étape 1: Déchiffrement avec l'algorithme de Hill
        String deciphertext = hillCipherDecrypt(encryptedText, inverseKeyMatrix);
        System.out.println("Texte déchiffré: " + deciphertext);
        
        // Étape 2: Passage de la table d'Acides aminésf à ARNm
        String arnmText = aminoAcidsToARNM(deciphertext);
        System.out.println("Texte ARNm: " + arnmText);
        
        // Étape 3: Transformation ARNm sous la forme ADN
        String adnText = ARNMToDNA(arnmText);
        System.out.println("Texte ADN: " + adnText);
        
        // Étape 4: Transformation ADN sous la forme binaire
        String binaryText = DNAtoBinary(adnText);
        System.out.println("Texte binaire: " + binaryText);
        
        // Étape 5: Conversion du binaire 8-bit en texte clair 
        String textClair = binaryToText(binaryText);
        System.out.println("Texte clair: " + textClair);

        return textClair;
    }

// la methode main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vous voulez 1.chiffrer ou 2.déchiffrer : ");
        String besoin = scanner.nextLine();
        if(besoin.equals("1")) {
        	int[][] keyMatrix = {
                    {2, 1, 1},
                    {1, 3, 2},
                    {1, 0, 1}  };
        	System.out.print("Entrez le texte à Chiffrer : ");
            String plaintext = scanner.nextLine();
            String encryptedText = hillADNCipher(plaintext, keyMatrix);
        }else 
          if(besoin.equals("2")) {
        	double[][] keyMatrix = {
                    {2.0 , 1.0 , 1.0 },
                    {1.0 , 3.0 , 2.0 },
                    {1.0 , 0.0 , 1.0 } };
        	System.out.print("Entrez le texte à déChiffrer : ");
        	String ciphertext = scanner.nextLine();
        	System.out.print(inverseMatrix(keyMatrix));
        	double[][] inverseKeyMatrix = inverseMatrix(keyMatrix);
            if (inverseKeyMatrix != null) {
            	for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(inverseKeyMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
                String decryptedText = hillADNDecipher(ciphertext, inverseKeyMatrix);
                System.out.println("Texte déchiffré : " + decryptedText);
            } else {
                System.out.println("La matrice inverse n'existe pas.");
            }
         }
           scanner.close();
}
 }