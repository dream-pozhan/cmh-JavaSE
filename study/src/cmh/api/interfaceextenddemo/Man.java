package cmh.api.interfaceextenddemo;

public class Man implements SportMan{

    @Override
    public void run() {
        System.out.println("��");
    }

    @Override
    public void rule() {
        System.out.println("���ع���");
    }

    @Override
    public void eat() {
        System.out.println("��");
    }

    @Override
    public void sleep() {
        System.out.println("˯��");
    }
}
