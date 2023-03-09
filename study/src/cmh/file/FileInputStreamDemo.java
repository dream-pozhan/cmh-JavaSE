package cmh.file;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception{
        InputStream inputStream = new FileInputStream("study//src//data.txt");
        int b = inputStream.read();
        System.out.println((char) b);

        int b1 = inputStream.read();
        System.out.println((char) b1);

        int b2 = inputStream.read();
        System.out.println((char) b2);

        int b3 = inputStream.read();
        System.out.println((char) b3);

        int b4 = inputStream.read();
        System.out.println(b4);
    }
}
