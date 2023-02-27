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
        map.put("�ֱ�",11);
        System.out.println(map);
        //��ռ���
        //map.clear();
        //System.out.println(map);
        //�ж��Ƿ�Ϊ��
        System.out.println(map.isEmpty());
        //���ݼ���ȡ��Ӧ��ֵpublic V get(Object key)
        Integer value = map.get("Java");
        System.out.println(value);
        System.out.println(map.get("huawei"));
        System.out.println(map.get("iphone"));
        System.out.println(map.get("Vivo"));

        //���ݼ�ɾ������Ԫ��
        map.remove("iphone");
        System.out.println(map);
        //�ж��Ƿ����ĳ����
        System.out.println(map.containsKey("�ֱ�"));
        System.out.println(map.containsKey("iphone"));

        //�ж��Ƿ����ĳ��ֵ
        map.containsValue(11);
        map.containsValue(30);

        //��ȡȫ�����ļ���
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        //��ȡȫ��ֵ�ļ���
        Collection<Integer> values = map.values();
        System.out.println(values);
        //���ϵĴ�С
        System.out.println(map.size());
        //�ϲ�����map����
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
