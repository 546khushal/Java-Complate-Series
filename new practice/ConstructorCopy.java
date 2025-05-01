class ConstructorCopy{
    int id;
    String name;
    int age;
    ConstructorCopy(int i,String n ){
        id=i;
        name=n;
    }
    //Copy Constructor 
    ConstructorCopy(ConstructorCopy c){
        id=c.id;
        name=c.name;
        age=c.age;
    }
    void display(){
        System.out.println(id+" "+name);
    }
    public static void main(String[] args){
        ConstructorCopy s1 = new ConstructorCopy(111,"khushal");
        ConstructorCopy s2 = new ConstructorCopy(s1);
        s1.display();
        s2.display();
    }
}