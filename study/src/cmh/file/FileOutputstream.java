package cmh.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputstream {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream = new FileOutputStream("study/src/out.txt");//д������ʱ�����֮ǰ������

        outputStream.write(97);
        outputStream.write("\r\n".getBytes());
        outputStream.write('b');
        outputStream.write("\r\n".getBytes());
        byte[] bytes = {'a',96,98,'m'};
        outputStream.write(bytes);
        outputStream.write("\r\n".getBytes());
        //���ܵ���д��һ�����֣���Ϊ����ռ�����ֽڣ�������д������ʱ�ǰ���һ���ֽ�һ���ֽ�д��
        //outputStream.write('��');
        //��������뺺�ֵ���getByte����
        byte[] bytes1 = "������".getBytes();
        outputStream.write(bytes1);
        //д������һ��Ҫˢ��
        outputStream.flush();


    }
}
