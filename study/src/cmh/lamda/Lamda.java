package cmh.lamda;

public class Lamda {
    public static void main(String[] args) {
            /*swming swim = new swming() {
                @Override
                public void swim() {
                    System.out.println("学生游的很快");
                }
            };*/
        swming swim =()->{
                System.out.println("学生游的很快");

        };
          run(swim);
    }
    public static void run(swming swim){
        System.out.println("开始");
        swim.swim();
        System.out.println("结束");
    }
}
interface swming {
    void swim();
}
