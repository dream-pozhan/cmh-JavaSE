package reflectconstructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class Student2 {
    @Test
    public void testStudent02() throws Exception {
        Class c = Student.class;
        Constructor constructor = c.getDeclaredConstructor();
        System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());
        //若构造器的权限是private，可以暴力破解权限，仅限本次
        constructor.setAccessible(true);//权限被打开
        //通过反射创建对象
        Student student = (Student) constructor.newInstance();
        System.out.println(student);
        System.out.println("--------------------------");
        //获取有参数构造器
        Constructor constructor1 = c.getConstructor(String.class,int.class);
        System.out.println(constructor1.getName()+"=====>"+constructor1.getParameterCount());
        //通过反射创建对象
        Student student1 = (Student) constructor1.newInstance("孙悟空",500);
        System.out.println(student1);
    }
}
