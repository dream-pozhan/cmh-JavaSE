package cmh.stream.thread;
//���̺߳����߳�ͬʱ����
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        for (int i = 0; i <10; i++) {
            System.out.println("���߳������");
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("���߳��ڵ���");
        }
    }
}
