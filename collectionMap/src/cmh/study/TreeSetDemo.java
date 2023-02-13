package cmh.study;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        set.add("Java");
        set.add("Python");
        set.add("HTML");
        set.add("张三");
        set.add("java");
        System.out.println(set);
        //treeset会进行值的比较，存储的值都为String时，比较首字符的大小（ASCII码），汉字的值最大，所以排最后
    }
}
