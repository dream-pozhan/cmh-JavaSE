package cmh.udpmulticast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("+++客户端启动后+++");
        //创建发送对象
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请说：");
            String msg = scanner.nextLine();
            if (msg.equals("exit")){
                System.out.println("离线成功~~");
                socket.close();
                break;
            }
            byte[] buffer = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("224.0.1.1"),9999);
            //发送数据出去
            socket.send(packet);
        }


    }
}
