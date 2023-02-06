package cmh.api.finaldemo;


public class Test {
    //修饰静态成员变量
    public static final String string = "giao";
    //修饰实例成员变量(无意义，几乎不用)
    private final String name = "猪刚鬣";
    public static void main(String[] args) {
        //理解final修饰变量的作用
        //变量分为:局部变量和成员变量（静态成员变量和实例成员变量），
        //修饰局部变量,只能被赋值一次
        final double pai = 3.14;
        //pai = 3.15;第二次赋值不被允许
        //string = "黑马";不能第二次赋值！

        Test test = new Test();
        System.out.println(test.name);//输出为猪刚鬣
        //test.name = "天蓬元帅";name无法进行第二次赋值，因为name被final修饰了，只能赋值一次！！

        //final修饰的变量为引用类型时，变量存储的地址不能变，但是地址指向的对象内容可以变
         final Teacher teacher = new Teacher("上课！");
        System.out.println(teacher.getHobby());
        //teacher= null;teacher new 出来的时候产生了一个地址，地址不能被改变了
        teacher.setHobby("布置作业");//地址指向的内容可以发生改变
        System.out.println(teacher.getHobby());

    }
}

class Teacher{
    private String hobby;

    public Teacher(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}

