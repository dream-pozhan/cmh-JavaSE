package cmh.api.interfacedemo;

public class FootballMan implements SportMan{
    private String name;

    public FootballMan() {
    }

    public FootballMan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"�˶�Ա��Ҫ�ܲ�������");
    }

    @Override
    public void copetition() {
        System.out.println(name+"�˶�Ա��Ҫ������");
    }
}
