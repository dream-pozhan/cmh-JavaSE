package cmh.stream.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Callable<String> callable = new MyCallable(100);
        FutureTask<String> futureTask = new FutureTask(callable);
        //futureTaskʵ�ֵ���runnable�ӿڣ����Է���Thread������
        //futureTask�����߳�ִ����֮��Ľ��
        Thread thread = new Thread(futureTask);
        thread.start();

        Callable<String> callable2 = new MyCallable(200);
        FutureTask<String> futureTask2 = new FutureTask(callable2);
        //futureTaskʵ�ֵ���runnable�ӿڣ����Է���Thread������
        //futureTask�����߳�ִ����֮��Ľ��
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        //ͨ��get������ȡ���
        try {
            String result1 = futureTask.get();
            System.out.println("��һ�������"+result1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String result2 = futureTask2.get();
            System.out.println("�ڶ��������"+result2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=i;
        }
        return "���߳�ִ�еĽ����"+sum;
    }
}