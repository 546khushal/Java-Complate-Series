/*
 Create following arrays and assign incremental values starting from 1 to each element. 
1. Array with 2 rows and 3 columns.
2. Array with 2 rows. First row has 3 cells, and second row has 2 cells.
Print the content of both the arrays.
*/
public class day1_4 {             //ArrayExample
    public static void main(String[] args) {
        // 1. Array with 2 rows and 3 columns
        int[][] array1 = new int[2][3];
        int value = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                array1[i][j] = value++;
            }
        }

        // Print array1
        System.out.println("Array with 2 rows and 3 columns:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }

        // 2. Array with 2 rows (first row 3 cells, second row 2 cells)
        int[][] array2 = { {1, 2, 3}, {4, 5} };

        // Print array2
        System.out.println("\nArray with 2 rows (jagged):");
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
