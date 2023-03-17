package cmh.udpbroadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("+++客户端启动+++");
        //创建接收端对象
        DatagramSocket socket = new DatagramSocket(9999);

        //创建一个数据包对象接收对象
        byte[] buffer = new byte[64 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        //等待接受数据
        while (true) {
            socket.receive(packet);
            //取出数据即可
            int length = packet.getLength();
            String rs = new String(buffer,0,length);
            System.out.println("收到了，来自"+packet.getAddress()+"端口是"+packet.getPort()+"的信息"+rs);

        }
    }
}
