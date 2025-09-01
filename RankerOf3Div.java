import java.util.*;
import java.io.*;
public class RankerOf3Div {
    static final String FILE_DIV_A="fileA.txt";
    static final String FILE_DIV_B="fileB.txt";
    static final String FILE_DIV_C="fileC.txt";
    static void writeFileWithMark(String FileName,String data){
        File file = new File(FileName);
        try{
            if(!file.exists()){
                FileWriter fw = new FileWriter(file);
                fw.write(data);
                fw.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // static void writeFileWithMarkA(){
    //     File file = new File(FILE_DIV_A);
    //     try{
    //         if(!file.exists()){
    //             FileWriter fw = new FileWriter(file);
    //             fw.write("89\n92\n95\n88\n91\n94\n87\n90\n93\n86\n89\n92\n85\n88\n91\n84\n87\n90\n83\n86\n82\n85\n88\n81\n84\n87\n80\n83\n86\n79\n82\n85\n78\n81\n84\n77\n80\n83\n76\n79\n82\n75\n78\n81\n74\n77\n80\n73\n76\n79\n72\n75\n78\n71\n74\n77\n70\n73\n76\n75");
    //             fw.close();
    //         }
    //     }catch(IOException e){
    //         e.printStackTrace();
    //     }
    // }
    // static void writeFileWithMarkB(){
    //     File file = new File(FILE_DIV_B);
    //     try{
    //         if(!file.exists()){
    //             FileWriter fw = new FileWriter(file);
    //             fw.write("78\n75\n82\n79\n76\n83\n80\n77\n84\n81\n78\n85\n82\n79\n76\n83\n80\n77\n74\n81\n78\n75\n82\n79\n76\n73\n80\n77\n74\n81\n78\n75\n72\n79\n76\n73\n80\n77\n74\n71\n78\n75\n72\n79\n76\n73\n70\n77\n74\n71\n78\n75\n72\n69\n76\n73\n70\n67\n74\n71");
    //             fw.close();
    //         }
    //     }catch(IOException e){
    //         e.printStackTrace();
    //     }
    // }
    // static void writeFileWithMarkC(){
    //     File file = new File(FILE_DIV_C);
    //     try{
    //         if(!file.exists()){
    //             FileWriter fw = new FileWriter(file);
    //             fw.write("65\n72\n68\n75\n71\n67\n74\n70\n66\n73\n69\n64\n71\n68\n75\n62\n69\n66\n73\n60\n67\n72\n68\n65\n70\n67\n72\n69\n66\n71\n68\n65\n70\n67\n64\n69\n66\n63\n70\n67\n64\n61\n68\n65\n62\n69\n66\n63\n60\n67\n64\n61\n58\n65\n62\n59\n66\n63\n60\n57");
    //             fw.close();
    //         }
    //     }catch(IOException e){
    //         e.printStackTrace();
    //     }
    // }

    static int[] ReadFileStoreinArray(String FileName) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(FileName));
        int[] arr=new int[60];
        int count=0;
        while(sc.hasNextLine()){
            arr[count++] = Integer.parseInt(sc.nextLine().trim());
        }
        sc.close();
       
        //sort Array
        int i,j,key;
        for(i=1;i<count;i++){
            key=arr[i];
            j=i;
            while(j>0 && key<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=key;
        }
    //return top 20 student mark
        int[] mark20=new int[20];
        int index=0;
        for(int  k=40;k<count;k++){
            mark20[index++]=arr[k];
        }
        return mark20;  
    }
    
    static int[] marge(int[] a,int[] b){
        int m=a.length,n=b.length;
        int i=0,j=0,k=0;
        int[] tmp=new int[m+n];
        while(i<m && j<n){
            if(a[i]<=b[j]) tmp[k++]=a[i++];
            else tmp[k++]=b[j++];
        }
        while(i<m){
            tmp[k++]=a[i++];
        }
        while(j<n){
            tmp[k++]=b[j++];
        }
        
        return tmp;
    }




    public static void main(String[] args) throws FileNotFoundException{
        //create file  and write 60 student mark each Div A,B,C 
        writeFileWithMark(FILE_DIV_A,"89\n92\n95\n88\n91\n94\n87\n90\n93\n86\n89\n92\n85\n88\n91\n84\n87\n90\n83\n86\n82\n85\n88\n81\n84\n87\n80\n83\n86\n79\n82\n85\n78\n81\n84\n77\n80\n83\n76\n79\n82\n75\n78\n81\n74\n77\n80\n73\n76\n79\n72\n75\n78\n71\n74\n77\n70\n73\n76\n75");
        writeFileWithMark(FILE_DIV_B, "78\n75\n82\n79\n76\n83\n80\n77\n84\n81\n78\n85\n82\n79\n76\n83\n80\n77\n74\n81\n78\n75\n82\n79\n76\n73\n80\n77\n74\n81\n78\n75\n72\n79\n76\n73\n80\n77\n74\n71\n78\n75\n72\n79\n76\n73\n70\n77\n74\n71\n78\n75\n72\n69\n76\n73\n70\n67\n74\n71");
        writeFileWithMark(FILE_DIV_C,"65\n72\n68\n75\n71\n67\n74\n70\n66\n73\n69\n64\n71\n68\n75\n62\n69\n66\n73\n60\n67\n72\n68\n65\n70\n67\n72\n69\n66\n71\n68\n65\n70\n67\n64\n69\n66\n63\n70\n67\n64\n61\n68\n65\n62\n69\n66\n63\n60\n67\n64\n61\n58\n65\n62\n59\n66\n63\n60\n57");
        
        //Read Each file and store marks in arrayA,B,C
        int[] ArrA=ReadFileStoreinArray(FILE_DIV_A);
        int[] ArrB=ReadFileStoreinArray(FILE_DIV_B);
        int[] ArrC=ReadFileStoreinArray(FILE_DIV_C);

        //Merge Sorted ArrayA,B,C
        int[] AB = marge(ArrA, ArrB);
        int[] finalList = marge(AB, ArrC); 
        
        //create final file and store rank,Mark in final file 
        System.out.println("Ranker\tMarks");
        int rank=1;
        File file = new File("FinalRanker.txt");
        try{
            if(!file.exists()){
                FileWriter fw = new FileWriter(file);
                fw.write("Rank\tMark\n");
                for(int i=finalList.length-1;i>=0;i--){
                    System.out.println(rank+"\t"+finalList[i]);
                    fw.write(rank+"\t\t"+finalList[i]+"\n");
                    rank++;
                }
                fw.close();
            }
        }catch(Exception e){

        }





    }
    
}
