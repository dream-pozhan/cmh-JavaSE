package cmh.study;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<Student>();
        Student student1 = new Student("����",24, '��');
        Student student2 = new Student("����",25,'��');
        Student student3 = new Student("����",24,'��');
        //��д��hashcode������equals��������ʱhashset�в�������ظ���ֵ
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        System.out.println(studentSet);

    }
}
