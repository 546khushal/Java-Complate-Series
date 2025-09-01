/*generate by system(random) 4 unique digit 
 
  
 */

import java.util.*;
class Guess4Digit{
    static int generate4UniqueDigitNumber(){
        int unit=0;
        Random rand = new Random();
        String n="";
        while(unit<4){
            int randomNumber = rand.nextInt(10);
            String randomNumberStr = String.valueOf(randomNumber);
            if(!n.contains(randomNumberStr)){
                n+=randomNumberStr;
                unit++;
            } 
        }    
        int number = Integer.parseInt(n); 
        return number;
    }
    
    // static int numberGuess(){
    //     int digit=0;
    //     Random rand = new Random();
    //     int number=0;
    //     boolean firstDigit=true;
    //     while(digit<4){
    //         int rn=rand.nextInt(10);
    //         if(rn==0 && firstDigit){
    //             firstDigit=false;
    //         }
    //         if(!contain(number, rn)){ 
    //             number=number*10 +rn;
    //             digit++;
    //         }
    //     }
    //     return number;
    // }

    // static boolean contain(int v1,int v2){
    //     while(v1>0){
    //         int n=v1%10;
    //         if(n==v2)return true;
    //         v1/=10;
    //     }
    //     return false;
    // }


    static void guessNumberByUser(){
        int sn = generate4UniqueDigitNumber();
        //System.out.println("System random: "+sn);
        Scanner sc = new Scanner(System.in);
        String systemNumber = String.valueOf(sn);
        int tries=1;
        while(true){
            System.out.print("Guess 4 unique digit number to find value(tries "+tries+" ): ");
            int userGuess = sc.nextInt();
            String  userNumber = String.valueOf(userGuess);

            if(userNumber.equals(systemNumber)){
                System.out.println("Congratulation bro! You Guess Correct number in "+ tries +" tries");
                break;
            }
            int cow=0,bull=0;
            for(int j=0;j<4;j++){
                char u=userNumber.charAt(j);
                if(systemNumber.contains(String.valueOf(u)) && userNumber.charAt(j)!=systemNumber.charAt(j) ){
                    cow++;
                }
            }
            for(int j=0;j<4;j++){
                if(userNumber.charAt(j)==systemNumber.charAt(j) ){
                    bull++;
                }
            }
            //cow=cow-bull;
            System.out.println("Your Number         cow             bull");
            System.out.println(userGuess+"                "+cow+"                 "+bull);
            System.out.println("Guess not correct! plz trie  again...\n\n");
            tries++;
        }
    }

    
    public static void main(String[] args){
        // Random rand = new Random();
        // int randomNumber = rand.nextInt(10);
        // System.out.println(randomNumber);
        //System.out.println(generate4UniqueDigitNumber());
        //System.out.println(numberGuess());
        guessNumberByUser();
        
    }
}