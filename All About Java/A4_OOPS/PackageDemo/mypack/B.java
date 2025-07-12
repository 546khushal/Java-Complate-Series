package mypack;

import pack.A;  // Import the A class

class B {
    public static void main(String args[]) {
        A obj = new A();  // Now we can use simple name
        obj.msg();
    }
}
/*E:\MCA\sem 2\JAVA\PW series\OOPS\PackageDemo>
javac pack/A.java
javac mypack/B.java
java mypack.B*/