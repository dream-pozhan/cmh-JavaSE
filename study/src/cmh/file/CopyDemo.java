package cmh.file;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("F:\\pic\\Jillian Rae - Wayward One.mp3");
            OutputStream outputStream = new FileOutputStream("F:\\pic\\new.mp3");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            System.out.println("复制完成~~");
            //关闭流
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
