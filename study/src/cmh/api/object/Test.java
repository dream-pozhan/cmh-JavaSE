package cmh.api.object;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("张三",25,"软件工程");
        Student student1 = new Student("张三",25,"软件工程");
        System.out.println(student.equals(student1));
    }
}
