package cmh.file;

import cmh.date.SimpleDateDemo;
import cmh.date.SimpleDateFormatDemo;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo {
    public static void main(String[] args) {
        /*File file = new File("C:\\Users\\13255\\Pictures\\Saved Pictures\\yys.jpg");
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取文件定义时的路径
        System.out.println(file.getPath());
        //获取文件后缀名
        System.out.println(file.getName());
        //获取文件大小
        System.out.println(file.length());
        //获取文件最后修改时间
        long time = file.lastModified();
        System.out.println(String.format(String.format("最后修改的时间是：" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time))));*/
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
