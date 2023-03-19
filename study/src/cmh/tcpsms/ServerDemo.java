package cmh.tcpsms;




import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ServerDemo {
    //定义一个list存储当前在线的全部管道
    public static List<Socket> allOnlineSocket = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        System.out.println("===服务端启动成功===");

            //注册端口
            ServerSocket serverSocket = new ServerSocket(7776);
            while (true) {
                //必须调用accept方法，等待客户端的Socket连接请求，建立Socket通信管道
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"它来了上线了");
                allOnlineSocket.add(socket);
                //创建一个线程来处理socket管道
                new ServerReaderThread(socket).start();


            }
    }
}
class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //从socket管道中得到一个字节输入流
            InputStream inputStream = socket.getInputStream();
            //把字节输入流包装成缓冲字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress()+"收到消息："+msg);
                //把这个消息进行端口转发给所有客户的socket管道
                sendMsgToAll(msg);
            }
        } catch (Exception e) {
            System.out.println(socket.getRemoteSocketAddress()+"下线了，欢迎下次再来~~");
            ServerDemo.allOnlineSocket.remove(socket);
        }
    }
    private void sendMsgToAll(String msg) throws Exception {
        for (Socket socket : ServerDemo.allOnlineSocket) {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println(msg);
            printStream.flush();
        }
    }
}