package map.cmh;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        //LinkedHashMap���򣬲��ظ���������
        Map<String,Integer> map = new LinkedHashMap<String ,Integer>();
        map.put("���Ƕ���",10);
        map.put("Java",12);
        map.put("���",5);
        map.put("Java",51);
        System.out.println(map);
        //����
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
