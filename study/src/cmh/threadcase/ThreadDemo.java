package cmh.threadcase;

public class ThreadDemo {
    public static void main(String[] args) {
        Account account = new Account("ICBC-11",10000);
        Account account1 = new Account("ICBC-12",500);

        //创建两个线程对象
        new DrawThread(account,"小明",500).start();
        new DrawThread(account,"小红",500).start();

        new DrawThread(account1,"小黑",100).start();
        new DrawThread(account1,"小白",100).start();
    }
}
