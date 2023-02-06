package cmh.api.polymorphicdemo;

public class Test {
    //∂‡Ã¨–Œ Ω
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.run();

        Animal animal1 = new Tortoise();
        animal1.run();
    }
}
