package cmh.study;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        Set<Apple> appleSet = new TreeSet<Apple>();
        appleSet.add(new Apple("ºìÆ»¹û","red",20.5,600));
        appleSet.add(new Apple("»ÆÆ»¹û","yellow",20.5,400));
        appleSet.add(new Apple("ÂÌÆ»¹û","green",20.5,450));
        appleSet.add(new Apple("À¶Æ»¹û","blue",20.5,300));
        appleSet.add(new Apple("ÇàÆ»¹û","green",20.5,450));
        System.out.println(appleSet);
        Set<Apple> appleSet1 = new TreeSet<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o2.getWeight()-o1.getWeight();//½µÐò
                //return o1.getWeight-o2-getWeight;ÉýÐò
            }
        });
        appleSet1.add(new Apple("ºìÆ»¹û","red",20.5,600));
        appleSet1.add(new Apple("»ÆÆ»¹û","yellow",20.5,400));
        appleSet1.add(new Apple("ÂÌÆ»¹û","green",20.5,450));
        appleSet1.add(new Apple("À¶Æ»¹û","blue",20.5,300));
        appleSet1.add(new Apple("ÇàÆ»¹û","green",20.5,450));
        System.out.println(appleSet1);
    }
}
