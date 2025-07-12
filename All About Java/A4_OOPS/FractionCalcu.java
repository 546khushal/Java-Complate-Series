class Fraction{
    int num;
    int denominator;
    public Fraction(int num,int denominator){
        this.num=num;
        this.denominator=denominator;
        simplify();
    }
    public void display(){
        System.out.println(num+"/"+denominator);
    }
    //// Static method since it doesn't depend on instance variables
    //static likhe to bhi chalega
    int HCF(int x,int y){
        int r;
        while(y>0){
            r=x%y;
            x=y;
            y=r;
        }
        return x;
    }//or using recursion HCF{ if(b==0)return a;else return HCF(b,a%b)};
    void simplify(){
            int hcf=HCF(num,denominator);
            num/=hcf;
            denominator/=hcf;
    }
    public Fraction add(Fraction f1,Fraction f2){
        int n=f1.num*f2.denominator + f2.num*f1.denominator;
        int d= f1.denominator*f2.denominator;
        //return new Fraction(n,d);
        Fraction f3 = new Fraction(n,d);
        return f3;
    }
    public Fraction multi(Fraction f1,Fraction f2){
        int n=f1.num*f2.num;
        int d=f1.denominator*f2.denominator;
        return new Fraction(n,d);
    }
    public Fraction sub(Fraction f1,Fraction f2){
        int n=f1.num*f2.denominator -f2.num*f1.denominator;
        int d= f1.denominator*f2.denominator;
        return new Fraction(n,d);
    }
    public Fraction div(Fraction f1,Fraction f2){
        int n=f1.num*f2.denominator;
        int d=f1.denominator*f2.num;
        return new Fraction(n,d);
    }
}



public class FractionCalcu{
    public static void main(String[] args){
        Fraction f1=new Fraction(5,4);
        Fraction f2=new Fraction(3,2);
        //System.out.println(f1.num+"/"+f1.denominator);
        //System.out.println(f2.num+"/"+f2.denominator);
        // f1.simplify();
        f1.display();
        f2.display();
        /*yha f1 ka use dummy ke liye kiya iski jgh 
        Fraction temp = new Fraction(0, 1);
        Fraction result = temp.add(f1, f2);
        */
        //Fraction f3 = f1.add(f1,f2);
        //Fraction f3 = f1.multi(f1,f2);
        //Fraction f3 = f1.sub(f1,f2);
        Fraction f3 = f1.div(f1,f2);
        
        f3.display();
    }
}