package cmh.file;

import cmh.date.SimpleDateDemo;
import cmh.date.SimpleDateFormatDemo;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo {
    public static void main(String[] args) {
        /*File file = new File("C:\\Users\\13255\\Pictures\\Saved Pictures\\yys.jpg");
        //��ȡ����·��
        System.out.println(file.getAbsoluteFile());
        //��ȡ�ļ�����ʱ��·��
        System.out.println(file.getPath());
        //��ȡ�ļ���׺��
        System.out.println(file.getName());
        //��ȡ�ļ���С
        System.out.println(file.length());
        //��ȡ�ļ�����޸�ʱ��
        long time = file.lastModified();
        System.out.println(String.format(String.format("����޸ĵ�ʱ���ǣ�" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time))));*/
        System.out.println(sum(5));
    }
    public static int sum(int number){
        if (number == 1){
            return 1;
        }else{
           return sum(number-1)+number;
        }
    }
}
