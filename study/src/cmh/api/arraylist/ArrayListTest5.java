package cmh.api.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest5 {
    public static void main(String[] args) {
        //����ѧ����Ϣ
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180523", "������", 26, "����1"));
        students.add(new Student("20180514", "����ũ", 25, "����2"));
        students.add(new Student("20180556", "��ةة", 24, "����3"));
        students.add(new Student("20180578", "����͢", 26, "����4"));
        //�������飬��������ѧ����Ϣ
        for (int i = 0; i < students.size(); i++) {
            Student s1 = students.get(i);
            System.out.println("ѧ�ţ�" + s1.getStudyNumber() + "������" + s1.getName() + "���䣺" + s1.getAge() + "רҵ:" + s1.getClassName());
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("������ѧ����ѧ�ţ�");
            String number = sc.next();
            Student s = getStudentByID(students,number);
            if (s == null){
                System.out.println("���޴��ˣ�");
            }else{
                System.out.println("��ѯ��ѧ����ϢΪ��");
                System.out.println("ѧ�ţ�" + s.getStudyNumber() + "������" + s.getName() + "���䣺" + s.getAge() + "רҵ:" + s.getClassName());
            }

        }
    }

    //���巽������ѧ��id

    /**
     *����ѧ����ѧ�Ų�ѯ����ѧ������
     * @param students �洢��ѧ������ļ���
     * @param studyNumber ѧ����id
     * @return ����ѧ������/null
     */
    public static Student getStudentByID(ArrayList<Student> students,String studyNumber){
        //����ѧ������
        for (int i = 0; i < students.size(); i++) {
            Student s2 = students.get(i);
            //�Ƚ�ѧ��id
            if(s2.getStudyNumber().equals(studyNumber)){
                //ѧ��һ�£�����ѧ������
                return s2;
            }
        }
        //������δ�ҵ�����null
        return null;
        }
    }

