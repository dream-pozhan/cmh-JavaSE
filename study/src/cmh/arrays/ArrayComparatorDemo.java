package cmh.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayComparatorDemo {
    public static void main(String[] args) {
        Integer [] arr1 = {14,25,10,69,76,1};
        //比较器降序排列
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            /*public int compare(Integer o1, Integer o2) {
                if (o1-o2>0){
                    return 1;
                }else{
                    return  -1;
                }
            }*/
            /*public int compare(Integer o1,Integer o2){
                if (o2 -o1>0){
                    return 1;
                }else {
                    return -1;
                }
            }*/
            //简化方法

            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(arr1));


        //类对象比较
        Student[] students = new Student[3];
        students[0] =new Student("张三",25,175.5);
        students[1] =new Student("李四",20,185.5);
        students[2] =new Student("王五",18,195.5);

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄排序
                //return o1.getAge()-o2.getAge();
                //按照身高排
                return Double.compare(o2.getHeight(),o1.getHeight());
            }
        });
        System.out.println(Arrays.toString(students));
    }
}
