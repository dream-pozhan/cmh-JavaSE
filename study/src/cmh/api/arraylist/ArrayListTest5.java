package cmh.api.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest5 {
    public static void main(String[] args) {
        //存入学生信息
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180523", "蔡徐坤", 26, "歌手1"));
        students.add(new Student("20180514", "陈立农", 25, "歌手2"));
        students.add(new Student("20180556", "范丞丞", 24, "歌手3"));
        students.add(new Student("20180578", "朱正廷", 26, "歌手4"));
        //遍历数组，输出存入的学生信息
        for (int i = 0; i < students.size(); i++) {
            Student s1 = students.get(i);
            System.out.println("学号：" + s1.getStudyNumber() + "姓名：" + s1.getName() + "年龄：" + s1.getAge() + "专业:" + s1.getClassName());
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生的学号：");
            String number = sc.next();
            Student s = getStudentByID(students,number);
            if (s == null){
                System.out.println("查无此人！");
            }else{
                System.out.println("查询的学生信息为：");
                System.out.println("学号：" + s.getStudyNumber() + "姓名：" + s.getName() + "年龄：" + s.getAge() + "专业:" + s.getClassName());
            }

        }
    }

    //定义方法搜索学生id

    /**
     *根据学生的学号查询返回学生对象
     * @param students 存储的学生对象的集合
     * @param studyNumber 学生的id
     * @return 返回学生对象/null
     */
    public static Student getStudentByID(ArrayList<Student> students,String studyNumber){
        //遍历学生对象
        for (int i = 0; i < students.size(); i++) {
            Student s2 = students.get(i);
            //比较学生id
            if(s2.getStudyNumber().equals(studyNumber)){
                //学号一致，返回学生对象
                return s2;
            }
        }
        //遍历完未找到返回null
        return null;
        }
    }

