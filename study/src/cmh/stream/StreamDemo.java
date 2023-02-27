package cmh.stream;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"����","����","����","������","���޼�","����");
        List<String> zhangList = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("��")){
                zhangList.add(s);
            }
        }
        System.out.println(zhangList);
        List<String> zhangListThree = new ArrayList<>();
        for (String s:list){
            if (s.length() == 3){
                zhangListThree.add(s);
            }
        }
        System.out.println(zhangListThree);

        //stream��
        list.stream().filter(s->s.startsWith("��")).forEach(s-> System.out.println(s));

        //count
        long size = list.stream().filter(s->s.startsWith("��")).count();
        System.out.println(size);
        //limit
        list.stream().filter(s->s.startsWith("��")).limit(2).forEach(s -> System.out.println(s));
        //skip
        System.out.println("++++++++++++++++++++++");
        list.stream().filter(s -> s.startsWith("��")).skip(2).forEach(System.out::println);
        //map
        list.stream().map(s -> "����"+s).forEach(System.out::println);
        //�ӹ�Ϊѧ������
        list.stream().map(s -> new Student(s)).forEach(s -> System.out.println(s));
        //�ϲ���
        Stream<String> s1 = list.stream().filter(s -> s.startsWith("��"));
        Stream<String> s2 = Stream.of("Java1","Java2");
        Stream<String> s3 = Stream.concat(s1,s2);
        s3.forEach(s -> System.out.println(s));
    }
}
