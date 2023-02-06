package cmh.api.interfaceextenddemo;

public class Man implements SportMan{

    @Override
    public void run() {
        System.out.println("ÅÜ");
    }

    @Override
    public void rule() {
        System.out.println("×ñÊØ¹æÔò");
    }

    @Override
    public void eat() {
        System.out.println("³Ô");
    }

    @Override
    public void sleep() {
        System.out.println("Ë¯¾õ");
    }
}
