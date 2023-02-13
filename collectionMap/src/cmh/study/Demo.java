package cmh.study;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        Set<Apple> appleSet = new TreeSet<Apple>();
        appleSet.add(new Apple("��ƻ��","red",20.5,600));
        appleSet.add(new Apple("��ƻ��","yellow",20.5,400));
        appleSet.add(new Apple("��ƻ��","green",20.5,450));
        appleSet.add(new Apple("��ƻ��","blue",20.5,300));
        appleSet.add(new Apple("��ƻ��","green",20.5,450));
        System.out.println(appleSet);
        Set<Apple> appleSet1 = new TreeSet<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o2.getWeight()-o1.getWeight();//����
                //return o1.getWeight-o2-getWeight;����
            }
        });
        appleSet1.add(new Apple("��ƻ��","red",20.5,600));
        appleSet1.add(new Apple("��ƻ��","yellow",20.5,400));
        appleSet1.add(new Apple("��ƻ��","green",20.5,450));
        appleSet1.add(new Apple("��ƻ��","blue",20.5,300));
        appleSet1.add(new Apple("��ƻ��","green",20.5,450));
        System.out.println(appleSet1);
    }
}
