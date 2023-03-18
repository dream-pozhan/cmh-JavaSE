package cmh.tcpthread;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("===服务端启动成功===");
        try {
            //注册端口
            ServerSocket serverSocket = new ServerSocket(7776);
            while (true) {
                //必须调用accept方法，等待客户端的Socket连接请求，建立Socket通信管道
                Socket socket = serverSocket.accept();
                //启动线程类
                new ServerThreadDemo(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
