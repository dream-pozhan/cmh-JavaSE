package cmh.study.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //list.add("����");
        //list.add("����");
        //list.add("����");
        //list.add("������");
        //conllections�������Ԫ��
        Collections.addAll(list,"����","����","����","������");
        System.out.println(list);

        //shuffle�������list˳��(���ҷ������������һ��������Ȼ��ֵ����˳��)
        Collections.shuffle(list);
        System.out.println(list);

        //sort����
        List<Integer> list1 = new ArrayList<Integer>();
        Collections.addAll(list1,1,245,21,98,46,32);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);

    }
}
