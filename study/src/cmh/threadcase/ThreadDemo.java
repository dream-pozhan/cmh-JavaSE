package cmh.threadcase;

public class ThreadDemo {
    public static void main(String[] args) {
        Account account = new Account("ICBC-11",10000);
        Account account1 = new Account("ICBC-12",500);

        //���������̶߳���
        new DrawThread(account,"С��",500).start();
        new DrawThread(account,"С��",500).start();

        new DrawThread(account1,"С��",100).start();
        new DrawThread(account1,"С��",100).start();
    }
}
