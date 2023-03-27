package cmh.stream.thread;
//主线程和子线程同时在跑
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        for (int i = 0; i <10; i++) {
            System.out.println("主线程在输出");
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程在调用");
        }
    }
}
