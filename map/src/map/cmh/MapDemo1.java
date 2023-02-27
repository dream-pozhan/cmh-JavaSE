package map.cmh;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        //LinkedHashMap有序，不重复，无索引
        Map<String,Integer> map = new LinkedHashMap<String ,Integer>();
        map.put("鸿星尔克",10);
        map.put("Java",12);
        map.put("枸杞",5);
        map.put("Java",51);
        System.out.println(map);
        //遍历
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            int value = map.get(key);
            System.out.println("key:"+key+"=========>"+"value:"+value);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> entry:entries){
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key+"======"+value);
            System.out.println(entry);
        }
    }
}
