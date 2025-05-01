class Swap {
// swap() doesn't swap i and j

/*public static void swap(Integer i, Integer j) { 
int temp = i;
i = j;
j = temp;
}
*/
public static void main(String[] args) { 
int i = 10;
int  j = 20; 
int temp = i;
i = j;
j = temp;
//swap(i, j);
System.out.println("i = " + i + ", j = " + j);
}
}
