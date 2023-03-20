package reflectframework;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student("孙悟空","男",500,"菩提老祖","吃桃子");
        MybatisUtil.save(student);

        Teacher teacher = new Teacher("张三","男",6000);
        MybatisUtil.save(teacher);
    }
}
