package polymorphism;// polymorphism/Transmogrify.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Dynamically changing the behavior of an object
// via composition (the "State" design pattern)
//组合与继承的选择

/**
 * Stage 对象中包含了 Actor 引用，该引用被初始化为指向一个 HappyActor 对象，这意味着 performPlay() 会产生一个特殊行为。
 * 但是既然引用可以在运行时与其他不同的对象绑定，那么它就可以被替换成对 SadActor 的引用，performPlay() 的行为随之改变。
 * 这样你就获得了运行时的动态灵活性（这被称为状态模式）。与之相反，我们无法在运行时才决定继承不同的对象；那在编译时就完全决定好了。
 *---------------------------------------------------------
 * 有一条通用准则：使用继承表达行为的差异，使用属性表达状态的变化。
 * 在上个例子中，两者都用到了。通过继承得到的两个不同类在 act() 方法中表达了不同的行为，Stage 通过组合使自己的状态发生变化。
 * 这里状态的改变产生了行为的改变。
 */

class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
/* Output:
HappyActor
SadActor
*/
