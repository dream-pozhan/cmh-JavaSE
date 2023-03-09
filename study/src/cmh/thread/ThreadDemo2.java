package cmh.thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //创建线程任务对象
         Runnable target = new MyRunnable();
         //将任务对象传给线程
        Thread t = new Thread(target);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程运行"+i);
        }
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程运行"+i);
        }
    }
}
