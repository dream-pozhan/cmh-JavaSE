package cmh.tcpthreadpool;

import cmh.tcpthread.ServerThreadDemo;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServerDemo {
    private static ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {
        System.out.println("===服务端启动成功===");
        try {
            //注册端口
            ServerSocket serverSocket = new ServerSocket(7776);
            while (true) {
                //必须调用accept方法，等待客户端的Socket连接请求，建立Socket通信管道
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"它来了上线了");
                Runnable taget = new ServerReaderRunnable(socket);
                pool.execute(taget);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
