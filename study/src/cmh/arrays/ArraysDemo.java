package cmh.arrays;


import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr ={14,56,58,10,34,77};
        System.out.println(arr);//������ǵ�ַ
        System.out.println(Arrays.toString(arr));//toString�������ֵ
        Arrays.sort(arr);//���򣬴�С����
        System.out.println(Arrays.toString(arr));

        //���ֲ���
        int index = Arrays.binarySearch(arr, 56);
        System.out.println(index);
        //���ҵ�Ԫ�ز�����ʱ,���ص�ֵΪ{-��Ԫ��Ӧ�ò����λ�ã�-1}
        int index2 = Arrays.binarySearch(arr, 11);
        System.out.println(index2);
        //������δ���������ʱ�򣬾�ִ�ж��ַ������������bug
        int [] arr1 = {14,25,98,40,10,22};
        int i = Arrays.binarySearch(arr1, 40);
        System.out.println(i);

    }
}
