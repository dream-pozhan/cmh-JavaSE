package cmh.study;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet();//hashset,���򣬲��ظ�����������
        //Set<String> set = new LinkedHashSet<String>();//linkedhashset���򣬲��ظ���������������
        set.add("Java");
        set.add("Java");
        set.add("HTML");
        set.add("HTML");
        set.add("Spring");
        set.add("Spring");
        System.out.println(set);
    }
}
