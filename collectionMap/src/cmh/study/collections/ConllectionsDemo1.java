package cmh.study.collections;

import cmh.study.Apple;

import java.util.*;

public class ConllectionsDemo1 {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<Apple>();
        list.add(new cmh.study.Apple("��ƻ��","red",20.6,600));
        list.add(new cmh.study.Apple("��ƻ��","yellow",20.7,400));
        list.add(new cmh.study.Apple("��ƻ��","green",20.1,450));
        list.add(new cmh.study.Apple("��ƻ��","blue",20.3,300));
        list.add(new Apple("��ƻ��","green",20.5,450));

        //Collections.sort(list);
        //System.out.println(list);

        Collections.sort(list, (o1, o2)-> ( Double.compare(o1.getPrice(),o2.getPrice())));//lamda���ʽ

        System.out.println(list);
    }
}
