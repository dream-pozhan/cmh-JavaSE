package reflectframework;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {
    public static void save(Object obj){
        try(
                PrintStream printStream = new PrintStream(new FileOutputStream("junit_reflect_annotation_proxy_app/src/data.txt",true));
                ) {
            //提取对象的全部成员变量，只能通过反射解决
            Class c = obj.getClass();
            printStream.println("==============="+c.getSimpleName()+"===============");
            //提取全部成员变量
            Field[] fields = c.getDeclaredFields();
            //获取成员变量的信息
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                //提取本成员变量的obj对象中的值,
                String value = field.get(obj)+" ";//字符串拼接
                printStream.println(name+"="+value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
