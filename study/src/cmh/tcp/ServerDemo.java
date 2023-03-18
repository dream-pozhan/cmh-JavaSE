package cmh.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("===服务端启动成功===");
        try {
            //注册端口
            ServerSocket serverSocket = new ServerSocket(7776);
            //必须调用accept方法，等待客户端的Socket连接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();
            //从socket管道中得到一个字节输出流
            InputStream inputStream = socket.getInputStream();
            //把字节输入流包装成缓冲字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress()+"说了："+msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
