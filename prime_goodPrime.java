import java.io.FileWriter;
import java.io.IOException;

class prime_goodPrime {
    static boolean is_prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void Good_Prime(int[] prime, int[] GoodPrime) {
        int k = 0;
        try (FileWriter goodPrimeFile = new FileWriter("GoodPrimes.txt")) {
            for (int i = 1; i < prime.length - 1; i++) {
                if (prime[i] == 0 || prime[i + 1] == 0) break;
                int psqrt = prime[i] * prime[i];
                int primeMulti = prime[i - 1] * prime[i + 1];
                if (psqrt > primeMulti) {
                    GoodPrime[k++] = prime[i];
                }
            }
            for (int j = 0; j < k; j++) {
                goodPrimeFile.write(GoodPrime[j] + " ");
            }
            System.out.println("\nGood Primes written to GoodPrimes.txt");
            System.out.println("\nGood Primes:");
            for (int j = 0; j < 29; j++) {
                System.out.print(GoodPrime[j] + " ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing GoodPrimes.txt");
        }
    }

    public static void main(String[] args) {
        int[] prime = new int[250];
        int[] GoodPrime = new int[prime.length];
        int[] circularPrime = new int[prime.length];
        int k = 0;

        // Generate all prime numbers up to 1000
        for (int i = 0; i <= 1000; i++) {
            if (is_prime(i)) {
                prime[k++] = i;
            }
        }

        // Write Circular Primes to file (optional)
        int c=0;
        try (FileWriter circularPrimeFile = new FileWriter("CircularPrimes.txt")) {
            for (int j = 0; j < prime.length; j++) {
                if (prime[j] == 0) break;
                if (is_prime(prime[j])) {
                    circularPrime[c++] = prime[j];
                    circularPrimeFile.write(prime[j] + " ");
                }
            }
            System.out.println("Circular Primes written to CircularPrimes.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing CircularPrimes.txt");
        }

        
        System.out.println("circular Primes:");
        for (int i = 0; i < c; i++) {
            System.out.print(circularPrime[i] + " ");
        }

        System.out.println();
        Good_Prime(prime, GoodPrime);
    }
}
