package reflect;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //第一种方式forName()
        Class c1 = Class.forName("reflect.Student");
        System.out.println(c1);
        //第二种方法 类名.class
        Class c2 = Student.class;
        System.out.println(c2);
        //第三种方式，实例化对象，调用getClass
        Student student = new Student();
        Class c3 = student.getClass();
        System.out.println(c3);


    }
}
