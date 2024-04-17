package sort.counting_sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] arr = {3, 6, 2, 1, 4};

        System.out.println(Arrays.toString(countingSort(arr)));
    }

    static int[] countingSort(int[] arr) {

        // count 배열: arr 요소의 최댓값이 포함될 수 있는 길이
        int[] count = new int[100];

        // 배열의 요소들의 개수를 세어 count 배열에 저장
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // count 배열을 누적합 배열로 만들기
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[arr.length];

        // 역방향 순회를 통해 누적합 배열을 보고 위치를 찾
        for (int i = arr.length - 1; i >= 0 ; i--) {
            sorted[--count[arr[i]]] = arr[i];
        }

        return sorted;

    }


}
