package cmh.api.polymorphicdemo;

public class Test {
    //多态形式
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.run();
        System.out.println(animal.name);

        Animal animal1 = new Tortoise();
        animal1.run();
        System.out.println(animal1.name);
        //多态访问的特点：方法的调用->编译看左边，运行看右边；变量的调用->编译看左边，运行也看左边。
    }
}
