package cmh.study;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        set.add("Java");
        set.add("Python");
        set.add("HTML");
        set.add("����");
        set.add("java");
        System.out.println(set);
        //treeset�����ֵ�ıȽϣ��洢��ֵ��ΪStringʱ���Ƚ����ַ��Ĵ�С��ASCII�룩�����ֵ�ֵ������������
    }
}
