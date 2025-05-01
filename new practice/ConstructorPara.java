class ConstructorPara{
    int id;
    String name;
    int age;
    ConstructorPara(int i,String n ){
        id=i;
        name=n;
    }
    //Constructor OverLoading
    ConstructorPara(int i,String n ,int a){
        id=i;
        name=n;
        age=a;
    }
    void display(){
        System.out.println(id+" "+name+" "+age);
    }
    public static void main(String[] args){
        ConstructorPara s1 = new ConstructorPara(111,"khushal");
        ConstructorPara s2 = new ConstructorPara(222,"Ram",55);
        s1.display();
        s2.display();
    }
}