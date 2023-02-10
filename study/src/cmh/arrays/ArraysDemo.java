package cmh.arrays;


import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr ={14,56,58,10,34,77};
        System.out.println(arr);//输出的是地址
        System.out.println(Arrays.toString(arr));//toString输出的是值
        Arrays.sort(arr);//排序，从小到大
        System.out.println(Arrays.toString(arr));

        //二分查找
        int index = Arrays.binarySearch(arr, 56);
        System.out.println(index);
        //查找的元素不存在时,返回的值为{-（元素应该插入的位置）-1}
        int index2 = Arrays.binarySearch(arr, 11);
        System.out.println(index2);
        //当数组未进行排序的时候，就执行二分法操作，会出现bug
        int [] arr1 = {14,25,98,40,10,22};
        int i = Arrays.binarySearch(arr1, 40);
        System.out.println(i);

    }
}
