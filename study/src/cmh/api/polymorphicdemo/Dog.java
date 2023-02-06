package cmh.api.polymorphicdemo;

public class Dog extends Animal{
    public String name = "子类狗";

    @Override
    public void run() {
        System.out.println("狗跑得贼快！");
    }
}
