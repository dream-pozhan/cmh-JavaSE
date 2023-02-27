package map.cmh;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("鸿星尔克",2);
        map.put("枸杞",100);
        map.put("Java",1);
        map.put("Java",50);
        //map中的键如果重复，后面的覆盖前面的
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
