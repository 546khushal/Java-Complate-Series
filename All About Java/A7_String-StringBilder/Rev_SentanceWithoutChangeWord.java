import java.util.*;
class Rev_SentanceWithoutChangeWord{
    static String rev(String s){
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            reversed.append(words[i]);
            if(i!=0)reversed.append(" ");
        }
        return reversed.toString();
    }
    public static void main(String[] args){
        String s="hello i am khushal";
        System.out.println(rev(s));//khushal am i hello
    }
}