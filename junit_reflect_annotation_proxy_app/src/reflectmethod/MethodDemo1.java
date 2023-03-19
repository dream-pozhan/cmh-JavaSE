package reflectmethod;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo1 {
    /*
    * 获取所以成员方法对象
    * */
    @Test
    public void test(){
        //获取类对象
        Class c = Dog.class;
        //提取全部方法（包括私有）
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+"返回值类型"+method.getReturnType()+"参数个数"+method.getParameterCount());
        }
    }
    /*
    * 获取单个成员方法
    * */
    @Test
    public void test1() throws Exception {
        //获取类对象
        Class c = Dog.class;
        //提取单个方法
        Method method = c.getDeclaredMethod("eat");
        System.out.println(method.getName()+"返回值类型"+method.getReturnType()+"参数个数"+method.getParameterCount());
        Method method1 = c.getDeclaredMethod("eat",String.class);
        System.out.println(method1.getName()+"返回值类型"+method1.getReturnType()+"参数个数"+method1.getParameterCount());
    }
    @Test
    public void test2() throws Exception {
        //获取类对象
        Class c = Dog.class;
        //提取单个方法
        Method method = c.getDeclaredMethod("eat");
        Method method1 = c.getDeclaredMethod("eat",String.class);
        //调用方法
        //实例化对象
        //暴力破解权限
        method.setAccessible(true);
        method1.setAccessible(true);

        Dog dog = new Dog();
        Object rs = method.invoke(dog);//调用了eat()方法，
        System.out.println(rs);//返回NULL

        Object rs1 = method1.invoke(dog,"骨头");//调用了eat(String name)方法
        System.out.println(rs1);//返回狗吃骨头，狗吃的很开心

    }
}
