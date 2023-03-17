package cmh.udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("+++客户端启动+++");
        //创建接收端对象
        DatagramSocket socket = new DatagramSocket(8888);

        //创建一个数据包对象接收对象
        byte[] buffer = new byte[64 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        //等待接受数据
        socket.receive(packet);
        //取出数据即可
        int length = packet.getLength();
        String rs = new String(buffer,0,length);
        System.out.println("收到了"+rs);
        //获取对方ip地址
        String ip = packet.getSocketAddress().toString();
        System.out.println("对方IP地址为"+ip);
        //获取端口号
        int port = packet.getPort();
        System.out.println(port);
        socket.close();
    }
}
