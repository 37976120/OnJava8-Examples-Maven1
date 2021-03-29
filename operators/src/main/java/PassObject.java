// operators/PassObject.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Passing objects to methods might not be
// what you're used to

class Letter {
    char c;
}

public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        tt1 tt1 = new tt1();
        //-------------------------------
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);//一旦传递了一个引用，那么实际上 y.c ='z'; 是在方法 f() 之外改变对象
        System.out.println("2: x.c: " + x.c);
    }
}
/* Output:
1: x.c: a
2: x.c: z
*/

class tt1 {
    public tt1() {
        System.out.println("no constr");
    }

    public tt1(int i) {
        System.out.println(i);
    }

    public tt1(double d) {
        this();
    }
}
