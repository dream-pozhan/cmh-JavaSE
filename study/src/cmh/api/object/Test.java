package cmh.api.object;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("����",25,"�������");
        Student student1 = new Student("����",25,"�������");
        System.out.println(student.equals(student1));
    }
}
