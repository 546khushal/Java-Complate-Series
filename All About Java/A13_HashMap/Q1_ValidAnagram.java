/*
Check whether two String are anagram of each other.Return true if they are else return false.
An Anagaram of a string is another string that contains same characters, only ther order of charactes may be different.
For Example "abcd" and "dcba" are anagram of each other.
Input: 
    listen
    silent
Output: True

Input2:
    anagram
    grams
Output: flase
 */
import java.util.*;
class Q1_ValidAnagram{
    /*public static  boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
            }
        char[] s1Array = s1.toLowerCase().toCharArray();
        char[] s2Array = s2.toLowerCase().toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return Arrays.equals(s1Array, s2Array);
    }*/
   static HashMap<Character,Integer> makeFreqMap(String str){
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }else{
                int currFreq = mp.get(ch);
                mp.put(ch,currFreq+1);
            }
        }
        return mp;
   }
   
   public static  boolean isAnagram(String s1, String s2){
    if(s1.length() !=s2.length())return false;
    HashMap<Character,Integer> mp1 = makeFreqMap(s1);
    HashMap<Character,Integer> mp2 = makeFreqMap(s2);
    return mp1.equals(mp2);
   }
        
    
    public static void main(String[] args){
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(isAnagram(str1, str2));
        
    }
}