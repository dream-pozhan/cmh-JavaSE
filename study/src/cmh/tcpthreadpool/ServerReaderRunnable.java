package cmh.tcpthreadpool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable{
    private Socket socket;
    public ServerReaderRunnable(Socket socket){
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
                System.out.println(socket.getRemoteSocketAddress()+"说了："+msg);
            }
        } catch (Exception e) {
            System.out.println(socket.getRemoteSocketAddress()+"它走了，下线了");
        }
    }
}
