package map.cmh;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("���Ƕ���",2);
        map.put("���",100);
        map.put("Java",1);
        map.put("Java",50);
        //map�еļ�����ظ�������ĸ���ǰ���
        System.out.println(map);

        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key+"---->"+value);
            }
        });
        map.forEach( (key,  value) ->{
                System.out.println(key+"---->"+value);

        });
    }
}
