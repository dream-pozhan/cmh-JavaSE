package cmh.api.polymorphicdemo;

public class Test {
    //��̬��ʽ
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.run();
        System.out.println(animal.name);

        Animal animal1 = new Tortoise();
        animal1.run();
        System.out.println(animal1.name);
        //��̬���ʵ��ص㣺�����ĵ���->���뿴��ߣ����п��ұߣ������ĵ���->���뿴��ߣ�����Ҳ����ߡ�
    }
}
