package cmh.api.polymorphicdemo;

public class Dog extends Animal{
    public String name = "���๷";

    @Override
    public void run() {
        System.out.println("���ܵ����죡");
    }
}
