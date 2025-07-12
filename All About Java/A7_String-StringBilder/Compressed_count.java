/*The String should be compressed such that consecutive duplicated of characters are replaced with the character and 
followed by the number of consecutive duplicated 
Input - aaabbbbccddde
Output - a3b4c2d3e
*/
public class Compressed_count{
    static String Compressed(String str){
        if (str.isEmpty()) return "";  // Handle empty string
        int count=1;
        //StringBuilder sb=new StringBuilder();
        String ans="";
        for(int i=0;i<str.length()-1;i++){
            char curr=str.charAt(i);
            char next=str.charAt(i+1);
            
            if(curr==next){
                count++;
            }else{
                // ans+=curr;
                // ans+=count; 
                //ans+=curr+String.valueOf(count);
                ans+=curr +(count+"");
                count=1;
            }
        }
        //Add the last character and its count
        //ans+=str.charAt(str.length()-1)+String.valueOf(count);
        ans+=str.charAt(str.length()-1)+(count+"");
        return ans;
    }

    public static void main(String[] args){
        String str="aaabbbbccaaaaadddeeeeee";
        System.out.println(Compressed(str));
    }
}