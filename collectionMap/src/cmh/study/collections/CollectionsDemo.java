package cmh.study.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //list.add("张三");
        //list.add("王五");
        //list.add("赵四");
        //list.add("王麻子");
        //conllections批量添加元素
        Collections.addAll(list,"张三","王五","赵四","王麻子");
        System.out.println(list);

        //shuffle随机打乱list顺序(打乱方法：随机给予一个索引，然后值交换顺序)
        Collections.shuffle(list);
        System.out.println(list);

        //sort排序
        List<Integer> list1 = new ArrayList<Integer>();
        Collections.addAll(list1,1,245,21,98,46,32);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);

    }
}
