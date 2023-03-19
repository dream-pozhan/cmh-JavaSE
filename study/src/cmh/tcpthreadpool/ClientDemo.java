package cmh.tcpthreadpool;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("===客户端启动了===");
        try {
            //创建socket管道请求服务端的连接
            //public socket(String host,int port)
            //参数1，服务端的ip地址
            //参数2，服务端的端口
            Socket socket = new Socket("192.168.110.169",7776);
            //从socket管道获得一个字节输出流，负责发送数据
            OutputStream outputStream = socket.getOutputStream();
            //把低级的字节流包装成打印流
            PrintStream printStream = new PrintStream(outputStream);
            //发送信息
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请说：");
                String msg = scanner.nextLine();
                printStream.println(msg);
                printStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
