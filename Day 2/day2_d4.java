/*4. Write a program to perform addition of numbers between 3 to 10, except number 5. 
*/
class day2_d4 {
    public static void main(String[] args) {
        int sum = 0;

        // Using a for loop to iterate between 3 to 10
        for (int i = 3; i <= 10; i++) {
            if (i == 5) { // Skip the number 5
                continue; 
            }
            sum += i; // Add the current number to the sum
        }

        // Display the result
        System.out.println("The sum of numbers between 3 to 10, except 5, is: " + sum);
    }
}
