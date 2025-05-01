class day2_d3 {
    static int i = 3;
    static int sum = 0;

    
    public static void Sum_do_while() {
        do {
            sum += i; 
            i++;      
        } while (i <= 10); 
        System.out.println("Result using do-while loop is: " + sum);
    }

    
    public static  void Sum_while() {
        i = 3; 
        sum = 0; 
        while (i <= 10) {
            sum += i; 
            i++;      
        }
        System.out.println("Result using while loop is: " + sum);
    }

    public static void main(String[] args) {
        
        day2_d3.Sum_do_while();
        day2_d3.Sum_while();
    }
}
