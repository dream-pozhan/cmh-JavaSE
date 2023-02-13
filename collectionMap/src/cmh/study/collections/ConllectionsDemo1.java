package cmh.study.collections;

import cmh.study.Apple;

import java.util.*;

public class ConllectionsDemo1 {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<Apple>();
        list.add(new cmh.study.Apple("红苹果","red",20.6,600));
        list.add(new cmh.study.Apple("黄苹果","yellow",20.7,400));
        list.add(new cmh.study.Apple("绿苹果","green",20.1,450));
        list.add(new cmh.study.Apple("蓝苹果","blue",20.3,300));
        list.add(new Apple("青苹果","green",20.5,450));

        //Collections.sort(list);
        //System.out.println(list);

        Collections.sort(list, (o1, o2)-> ( Double.compare(o1.getPrice(),o2.getPrice())));//lamda表达式

        System.out.println(list);
    }
}
