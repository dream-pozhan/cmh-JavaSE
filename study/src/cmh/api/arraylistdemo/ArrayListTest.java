package cmh.api.arraylistdemo;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(98);
        arrayList.add(77);
        arrayList.add(66);
        arrayList.add(89);
        arrayList.add(79);
        arrayList.add(10);
        arrayList.add(50);
        arrayList.add(100);
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            int score = arrayList.get(i);
            if(score < 80){
                arrayList.remove(i);
                i--;//�ⲽ���Ի��bug,��Ϊÿ��arraylist��С��80�ı�ɾ���󣬺����������ǰ�ƣ�����77������Ϊ1����77��ɾ����66��ǰ�ƣ�������Ϊ��1������ʱi����ƣ�����66δ��ɾ����������bug
            }
        }
        System.out.println(arrayList);

    }
}
