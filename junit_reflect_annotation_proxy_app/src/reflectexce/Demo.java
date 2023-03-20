package reflectexce;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo {
    /*
    * 反射可以绕过编译阶段，为ArrayList<Interger>添加String类型值
    * */
    @Test
    public void test() throws Exception {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list1.getClass() == list2.getClass());
        //获取list1和list2的字节码文件，可以发现其字节码都是相同的，泛型在编译后产生的字节码文件中已经被擦除了
        /*
        * 往ArrayList<Integer>中添加String类型的值
        * */
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(11);
        list3.add(12);
        //获取Class文件
        Class c = ArrayList.class;
        Method add = c.getDeclaredMethod("add", Object.class);
        Boolean Boolean = (boolean)add.invoke(list3, "黑马");
        System.out.println(list3);
        //不用反射也可以为Integer类型的ArrayList添加String类型的值
        ArrayList list4 = list3;
        list4.add("张三");
        System.out.println(list3);//原理：编译过后，泛型被擦除，list3和list4都是ArrayList类型
    }
}
