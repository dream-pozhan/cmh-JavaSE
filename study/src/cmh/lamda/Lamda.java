package cmh.lamda;

public class Lamda {
    public static void main(String[] args) {
            /*swming swim = new swming() {
                @Override
                public void swim() {
                    System.out.println("ѧ���εĺܿ�");
                }
            };*/
        swming swim =()->{
                System.out.println("ѧ���εĺܿ�");

        };
          run(swim);
    }
    public static void run(swming swim){
        System.out.println("��ʼ");
        swim.swim();
        System.out.println("����");
    }
}
interface swming {
    void swim();
}
