import java.util.*;

class Intersection {
    
    /*public int[] intersection(int[] num1, int[] num2) {
        int[] res = new int[Math.min(num1.length, num2.length)]; // Result array with max possible size
        int p = 0; // Pointer for the result array

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                if (num1[i] == num2[j]) { // Check if elements match
                    boolean flag = true; // Reset flag for duplicate checking

                    // Check if the element already exists in the result array
                    for (int k = 0; k < p; k++) {
                        if (num2[j] == res[k]) {
                            flag = false; // Duplicate found
                            break;
                        }
                    }

                    // If no duplicate, add the element to the result array
                    if (flag) {
                        res[p++] = num2[j];
                    }
                }
            }
        }
        int[] finalResult = new int[p];
        for (int i = 0; i < p; i++) {
            finalResult[i] = res[i];
        }

        return finalResult;
        // Create the final array with the exact size
        //return Arrays.copyOf(res, p);
    }*/
   //using HashSet
    public int[] intersection(int[] num1,int[] num2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        //Add element of num1 to set1
        for(int num : num1){
            set1.add(num);
        }
        // Check elements of num2 against set1
        for(int  num:num2){
            if(set1.contains(num)){
                resultSet.add(num);
            }
        }
        //convert resultSet to array
        int[] result = new int[resultSet.size()];
        int i=0;
        for(int num: resultSet){
            result[i++]=num;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Intersection solution = new Intersection();

        // Input the first array
        System.out.print("Enter the size of the first array: ");
        int n1 = sc.nextInt();
        int[] num1 = new int[n1];
        System.out.println("Enter elements of the first array:");
        for (int i = 0; i < n1; i++) {
            num1[i] = sc.nextInt();
        }

        // Input the second array
        System.out.print("Enter the size of the second array: ");
        int n2 = sc.nextInt();
        int[] num2 = new int[n2];
        System.out.println("Enter elements of the second array:");
        for (int i = 0; i < n2; i++) {
            num2[i] = sc.nextInt();
        }

        // Compute intersection
        int[] result = solution.intersection(num1, num2);

        // Output the result
        System.out.println("Intersection of the two arrays: " + Arrays.toString(result));
    }
}
