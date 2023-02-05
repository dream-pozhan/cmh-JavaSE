package cmh.api.studydemo;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "李四";
        stu.age = 24;
        System.out.println("姓名："+stu.name+"年龄："+stu.age);
        stu.information();
    }


}
