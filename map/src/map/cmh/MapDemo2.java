package map.cmh;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Java",10);
        map.put("huawei",12);
        map.put("iphone",30);
        map.put("手表",11);
        System.out.println(map);
        //清空集合
        //map.clear();
        //System.out.println(map);
        //判断是否为空
        System.out.println(map.isEmpty());
        //根据键获取对应的值public V get(Object key)
        Integer value = map.get("Java");
        System.out.println(value);
        System.out.println(map.get("huawei"));
        System.out.println(map.get("iphone"));
        System.out.println(map.get("Vivo"));

        //根据键删除整个元素
        map.remove("iphone");
        System.out.println(map);
        //判断是否包括某个键
        System.out.println(map.containsKey("手表"));
        System.out.println(map.containsKey("iphone"));

        //判断是否包括某个值
        map.containsValue(11);
        map.containsValue(30);

        //获取全部键的集合
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        //获取全部值的集合
        Collection<Integer> values = map.values();
        System.out.println(values);
        //集合的大小
        System.out.println(map.size());
        //合并其他map集合
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("java1",1);
        map1.put("java2",20);
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("java2",30);
        map2.put("java3",40);
        map1.putAll(map2);
        System.out.println(map1);



    }
}
