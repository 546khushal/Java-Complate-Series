/*
For using this class to generate random numbers, we have to first create an instance of this 
class and then invoke methods such as nextInt(), nextDouble(), nextLong() etc using that 
instance.

We can generate random numbers of types integers, float, double, long, booleans using this 
class. 
 */
import java.util.Random;
public class A10_Random{
    public static void main(String[] args){
        // create instance of Random class 
        Random rand = new Random();

        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(1000); 
        System.out.println("Random Integers: "+rand_int1);//Random Integers: 376 

        // Generate Random doubles 
        double rand_dub1 = rand.nextDouble(); 
        System.out.println("Random Doubles: "+rand_dub1); //Random Doubles: 0.6862921102468605

    
    }
}