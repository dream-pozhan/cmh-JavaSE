package cmh.thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //�����߳��������
         Runnable target = new MyRunnable();
         //��������󴫸��߳�
        Thread t = new Thread(target);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("���߳�����"+i);
        }
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("���߳�����"+i);
        }
    }
}
