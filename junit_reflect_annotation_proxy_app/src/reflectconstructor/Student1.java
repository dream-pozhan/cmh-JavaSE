package reflectconstructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class Student1 {
    @Test
    public void testStudent(){
        Class c = Student.class;
        //获取构造器
        //获取全部构造器对象,若构造器的权限为private,则无法获取
        Constructor [] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            //构造器名称====>构造器里的参数个数
            System.out.println(constructor.getName()+"=========>"+constructor.getParameterCount());
        }
    }
    @Test
    public void testStudent01(){
        Class c = Student.class;
        //获取全部构造器，无论权限getDeclaredconstructor
        Constructor [] constructors1 = c.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            //构造器名称====>构造器里的参数个数
            System.out.println(constructor.getName()+"=========>"+constructor.getParameterCount());
        }
    }
    //获取单个构造器，权限为public的
    //getConstructor(根据参数类型查找获取)
    @Test
    public void testStudent02() throws Exception {
        Class c = Student.class;
        Constructor constructor = c.getConstructor();
        System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());
        //获取有参数构造器
        Constructor constructor1 = c.getConstructor(String.class,int.class);
        System.out.println(constructor1.getName()+"=====>"+constructor1.getParameterCount());
    }
    //获取单个构造器，无论权限
    //getDeclaredConstructor(根据参数类型查找获取)
    @Test
    public void testStudent03() throws Exception {
        Class c = Student.class;
        Constructor constructor = c.getDeclaredConstructor();
        System.out.println(constructor.getName()+"=====>"+constructor.getParameterCount());
        //获取有参数构造器
        Constructor constructor1 = c.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor1.getName()+"=====>"+constructor1.getParameterCount());
    }




}
