package cmh.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputstream {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream = new FileOutputStream("study/src/out.txt");//写入数据时会清空之前的数据

        outputStream.write(97);
        outputStream.write("\r\n".getBytes());
        outputStream.write('b');
        outputStream.write("\r\n".getBytes());
        byte[] bytes = {'a',96,98,'m'};
        outputStream.write(bytes);
        outputStream.write("\r\n".getBytes());
        //不能单独写入一个汉字，因为汉字占三个字节，而单独写入数据时是按照一个字节一个字节写入
        //outputStream.write('你');
        //用数组存入汉字调用getByte方法
        byte[] bytes1 = "蔡徐坤".getBytes();
        outputStream.write(bytes1);
        //写入数据一定要刷新
        outputStream.flush();


    }
}
