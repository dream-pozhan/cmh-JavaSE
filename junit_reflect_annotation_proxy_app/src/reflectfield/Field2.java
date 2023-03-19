package reflectfield;

import org.junit.Test;

import java.lang.reflect.Field;

public class Field2 {
    @Test
    public void test() throws Exception {
        //获取类对象
        Class c = People.class;
        //获取单个成员对象
        Field ageField = c.getDeclaredField("age");
        //暴力破解权限
        ageField.setAccessible(true);
        //为成员变量赋值
        //set（Object object，Object value）
        People people = new People();
        ageField.set(people,18);
        System.out.println(people);
        //成员变量取值
        int age = (int) ageField.get(people);
        System.out.println(age);
    }
}
