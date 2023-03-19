package reflectfield;

import org.junit.Test;

import java.lang.reflect.Field;

public class Field1 {
    /*
    * 获取全部成员变量
    * */
    @Test
    public void test1(){
        //获取类对象
        Class c = People.class;
        //获取全部成员变量
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()+"===>"+field.getType());
        }
    }
    /*
    * 获取单个成员变量
    * */
    @Test
    public void test2() throws Exception {
        //获取类对象被
        Class c = People.class;
        //获取单个成员变量
        Field age = c.getDeclaredField("age");
        System.out.println(age.getName()+"===>"+age.getType());

    }
}
