package cmh.file;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        search(new File("D:/"),"GuJian3.Trainer.V3.2.0-XiaoXing");
    }
    public static void search(File dir,String fileName){
        //�ж�dir�Ƿ�ΪĿ¼
        if (dir != null && dir.isDirectory() ){
            //��ȡ��ǰĿ¼�µ�һ��Ŀ¼
            File[] files = dir.listFiles();
           if (files != null && files.length >0){
               for (File file : files) {
                   if (file.isFile()){
                       if (file.getName().contains(fileName)){
                           System.out.println("�ҵ��ˣ�"+file.getAbsolutePath());
                       }
                   }else {
                       search(file,fileName);
                   }
               }
           }
        }else {
            System.out.println("�Բ��𣬵�ǰ�����Ĳ����ļ���~~");
        }
    }
}
