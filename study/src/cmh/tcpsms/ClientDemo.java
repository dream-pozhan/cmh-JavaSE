package cmh.tcpsms;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws Exception{
        System.out.println("===客户端启动了===");
            //创建socket管道请求服务端的连接
            //public socket(String host,int port)
            //参数1，服务端的ip地址
            //参数2，服务端的端口
            Socket socket = new Socket("192.168.110.169",7776);
            //创建一个独立线程，用于客户端读消息
            new ClientReaderThread(socket).start();
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
    }
}
class ClientReaderThread extends Thread{
    private Socket socket;
    public ClientReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //从socket管道中得到一个字节输出流
            InputStream inputStream = socket.getInputStream();
            //把字节输入流包装成缓冲字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println("收到消息："+msg);
            }
        } catch (Exception e) {
            System.out.println("服务器把你踢出去了~~");
        }
    }
}
