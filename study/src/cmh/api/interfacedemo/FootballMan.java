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
        System.out.println(name+"运动员需要跑步锻炼！");
    }

    @Override
    public void copetition() {
        System.out.println(name+"运动员需要比赛！");
    }
}
