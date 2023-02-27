package cmh.file;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        search(new File("D:/"),"GuJian3.Trainer.V3.2.0-XiaoXing");
    }
    public static void search(File dir,String fileName){
        //判断dir是否为目录
        if (dir != null && dir.isDirectory() ){
            //提取当前目录下的一级目录
            File[] files = dir.listFiles();
           if (files != null && files.length >0){
               for (File file : files) {
                   if (file.isFile()){
                       if (file.getName().contains(fileName)){
                           System.out.println("找到了："+file.getAbsolutePath());
                       }
                   }else {
                       search(file,fileName);
                   }
               }
           }
        }else {
            System.out.println("对不起，当前搜索的不是文件夹~~");
        }
    }
}
