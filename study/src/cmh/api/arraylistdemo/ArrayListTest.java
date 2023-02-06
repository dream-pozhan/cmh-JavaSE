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
                i--;//这步忽略会出bug,因为每当arraylist中小于80的被删除后，后面的整数会前移，例如77，索引为1，当77被删除，66往前移，索引变为了1，，此时i向后移，导致66未被删除，出现了bug
            }
        }
        System.out.println(arrayList);

    }
}
