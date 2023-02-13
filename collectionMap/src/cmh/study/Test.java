package cmh.study;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<Student>();
        Student student1 = new Student("张三",24, '男');
        Student student2 = new Student("李四",25,'男');
        Student student3 = new Student("张三",24,'男');
        //重写了hashcode方法和equals方法，此时hashset中不会出现重复的值
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        System.out.println(studentSet);

    }
}
