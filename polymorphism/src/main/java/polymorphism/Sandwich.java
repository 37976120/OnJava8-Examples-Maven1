// polymorphism/Sandwich.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Order of constructor calls
// {java polymorphism.Sandwich}
package polymorphism;

class Meal {
    private int i = iniIntMeal();

    int iniIntMeal() {
        System.out.println("Meal intInitial");
        return 1;
    }


    static {
        System.out.println("Meal static");
    }

    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    static {
        System.out.println("Bread static");
    }

    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    static {
        System.out.println("Cheese static");
    }

    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    static {
        System.out.println("Lettuce static");
    }

    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    private int i = iniIntMeal();

    int iniIntMeal() {
        System.out.println("Lunch intInitial");
        return 2;
    }

    static {
        System.out.println("Lunch static");
    }

    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    private int i = iniIntPortableLunch();

    int iniIntPortableLunch() {
        System.out.println("PortableLunch intInitial");
        return 3;
    }

    static {
        System.out.println("PortableLunch static");
    }

    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class Sandwich extends PortableLunch {

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    private int i = iniIntSandwich();

    int iniIntSandwich() {
        System.out.println("Sandwich intInitial");
        return 4;
    }

    static {
        System.out.println("Sandwich static");
    }

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
/**
 * 1.进行类加载，有父类的递归到最顶父亲开始加载，静态属性和代码块
 * 2.创建类的初始化（递归到顶父类），开始非静态字段初始化，再执行构造器（有方法调用会是最终重载方法）
 */
/* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*/
