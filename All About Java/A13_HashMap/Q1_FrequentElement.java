/*
Given an Array, find the most frequent element in it. if there are multiple element that appear a maximum number of times, print any one of them
n = 6;
arr[]={1,3,2,1,4,1}
 */
import java.util.*;
class Q1_FrequentElement{
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3, 1,2};
        Map<Integer, Integer> freq = new HashMap<>();
        for(int ele:arr){//O(n)
            if(!freq.containsKey(ele)){
                freq.put(ele,1);
            }else{
                freq.put(ele, freq.get(ele)+1);
            }
        }
        System.out.println("Frequency Map: ");
        System.out.println(freq.entrySet());
        int maxFreq=0,ansKey=-1;
        //not support java 8 use in java 10
        /*for(var e: freq.entrySet()){
            if(e.getValue()>maxFreq){
                maxFreq = e.getValue();
                ansKey = e.getKey();
            }
        }*/
       //help using key but not suppoer var in java 8
       /*for(var key:freq.KeySet()){
        if(freq.get(key)>maxFreq){
           maxFreq=freq.get(key);
           ansKey(key); 
        }
       }*/
      //O(n)
      for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
        if (e.getValue() >maxFreq){
            maxFreq = e.getValue();
            ansKey = e.getKey();
        }
      }
    //final time complexity O(n)
        System.out.println(ansKey+" : "+maxFreq);




    //O(n) ydi diya ho 10^9 or negative number bhi hai to dikkat array se
        /*int max = 0;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        int[] freq = new int[max + 1]; // frequency array
        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " => " + freq[i] + " times");
            }
        }
        */


    }

}