/*
Given two string s and t, determine if they are isomorphic.
Two Strings s,and t are isomorphic if the characters in s can be replaced to get t.
Input1: 
    aab
    xxy
Output: True
Input2:
abcd
xyxw
Output: False

 */
import java.util.*;
class Q2_Isomorphic_String{
    
    public static boolean isIsomorphic(String s,String t){
       //time complexity: O(n) sc O(1)
       /* if(s.length()!=t.length())return false;
        int[] sMap=new int[256];// Tracks s → t mapping
        int[] tMap=new int[256];// Tracks t → s mapping
        for(int i=0;i<s.length();i++){
            int sCode=s.charAt(i);
            int tCode=t.charAt(i);
            if(sMap[sCode]!=0 && sMap[sCode]!=tCode) return false;
            if(tMap[tCode]!=0 && tMap[tCode]!=sCode) return false;
            sMap[sCode]=tCode;
            tMap[tCode]=sCode;
            }
            return true;

            //i	s[i]	t[i]	sMap Updates	    tMap Updates	        Check Passes?
            //0	 'e'	'a'	    sMap['e'] = 'a'	    tMap['a'] = 'e'	        true
            //1	 'g'	'd'	    sMap['g'] = 'd'	    tMap['d'] = 'g'	        true
            //2	 'g'	'd'	    sMap['g'] alrdy 'd'	tMap['d'] already 'g'	true
             
        */
       //time complexity: O(n)
      /* HashMap<Character,Character> mp = new HashMap<>();
       for(int i=0;i<s.length();i++){
        Character sch = s.charAt(i);
        Character tch = t.charAt(i);
        if(mp.containsKey(sch)){
            if(mp.get(sch)!=tch)return false;
        }
        else if (mp.containsValue(tch)){
            return false;
        }else{
            mp.put(sch, tch);
        }

       }
       return true;*/

        if (s.length() != t.length()) return false;
        
        HashMap<Character, Character> mp = new HashMap<>();
        HashSet<Character> st = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character sch = s.charAt(i);
            Character tch = t.charAt(i);
            
            if (mp.containsKey(sch)) {
                if (mp.get(sch) != tch) return false;
            } else {
                if (st.contains(tch)) return false;
                mp.put(sch, tch);
                st.add(tch);
            }
        }
        return true;
    }
    
    
    public static void main(String[] args){
        String s = "aab";
        String t = "xxy";
        System.out.println(isIsomorphic(s,t));

    }
}