package cmh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("+++客户端启动后+++");
        //创建发送对象
        DatagramSocket socket = new DatagramSocket();
        //
        byte[] buffer = "我是一颗快乐的韭菜".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(),8888);
        //发送数据出去
        socket.send(packet);

        socket.close();
    }
}
