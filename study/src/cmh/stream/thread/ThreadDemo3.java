package cmh.stream.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Callable<String> callable = new MyCallable(100);
        FutureTask<String> futureTask = new FutureTask(callable);
        //futureTask实现的了runnable接口，可以放入Thread对象中
        //futureTask返回线程执行完之后的结果
        Thread thread = new Thread(futureTask);
        thread.start();

        Callable<String> callable2 = new MyCallable(200);
        FutureTask<String> futureTask2 = new FutureTask(callable2);
        //futureTask实现的了runnable接口，可以放入Thread对象中
        //futureTask返回线程执行完之后的结果
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        //通过get方法获取结果
        try {
            String result1 = futureTask.get();
            System.out.println("第一个结果是"+result1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String result2 = futureTask2.get();
            System.out.println("第二个结果是"+result2);
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
        return "子线程执行的结果是"+sum;
    }
}