package cmh.sort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {10,60,55,32,1,77,43,65,7};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(binarysearch(array, 55));
    }
    public static int binarysearch(int[] arr,int number) {
        int left = 0;
        int right = arr.length - 1;
        //开始循环折半查询
        while (left <= right) {
            int midIndex = (left + right)/2;
            //判断查询的元素与中间元素大小
            if (number > arr[midIndex]) {
                //右边找
                left = midIndex + 1;
            } else if (number < arr[midIndex]) {
                //左边找
                right = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return 0;
    }
}
