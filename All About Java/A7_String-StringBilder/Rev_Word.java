/*Reverse each word in String 
input: I am an Eductor
output: I ma na rptacude
*/

public class Rev_Word{
    //method 1
    public static String RevEachWord(String str){
        StringBuilder sb=new StringBuilder("");
        String ans="";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch!=' '){
                sb.append(ch);
            }else{//ch ==' '
                sb.reverse();
                ans+=sb;
                ans+=" ";
                //sb.delete(0,sb.length());//StringBuilder empty
                sb= new StringBuilder("");//StringBuilder Empty
            }
        }
        sb.reverse();
        ans+=sb;
        return ans;
    }
    //Method 2
    public static String reverseWords(String str){
        StringBuilder result = new StringBuilder();
        int wordStart=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                result.append(revWord(str,wordStart,i-1)).append(' ');
                wordStart=i+1;
            }
        }
        result.append(revWord(str,wordStart,str.length()-1));
        return result.toString();
    }
    private static String revWord(String str, int start, int end) {
        StringBuilder word = new StringBuilder();
        for (int i = end; i >= start; i--) {
            word.append(str.charAt(i));
        }
        return word.toString();
    }
    




    //using String
    public static String reverseWords_String(String str) {
        int n = str.length();
        int start = 0;        
        for (int end = 0; end < n; end++) {
            if (str.charAt(end) == ' ') {
                // Reverse the current word (from start to end-1)
                str = revWord2(str, start, end - 1);
                start = end + 1;  // Move start to beginning of next word
            }
        }
        // Reverse the last word
        str = revWord2(str, start, n - 1);
        
        return str;
    }

    static String revWord2(String str,int i,int j){
        char[] chars = str.toCharArray();
        while(i<j){
            char tmp=chars[i];
            chars[i]=chars[j];
            chars[j]=tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
    

    public static void main(String[] args){
        String s="I am an Eductor";
        System.out.println(RevEachWord(s));  //I ma na rotcudE 
        System.out.println(reverseWords(s));//I ma na rotcudE
    
        System.out.println(reverseWords_String(s));//I ma na rotcudE
    }
}