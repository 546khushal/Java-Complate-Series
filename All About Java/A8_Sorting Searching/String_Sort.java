/*Give an array of names of the fruits: you are supposed to sort it 
in lexicographical order using the selection sort 
Input:["Papaya","lime","watermelon","apple","mango","kiwi"]
Output:["apple","kiwi","lime","mango","papaya","watermelon"]
*/
public class String_Sort {

    static void lexicographical_order(String[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                // Use compareToIgnoreCase for case-insensitive comparison
                if (arr[j].compareToIgnoreCase(arr[min]) < 0) { // Compare lexicographically
                    min = j;
                }
            }
            // Swap the elements
            String tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        String[] fruits = {"Papaya", "lime", "watermelon", "apple", "mango", "kiwi"};
        lexicographical_order(fruits, fruits.length); // Use length, not length()
        
        System.out.println("Fruits sorted in lexicographical order:");
        for (String val : fruits) {
            System.out.print(val + " ");
        }
    }
}
