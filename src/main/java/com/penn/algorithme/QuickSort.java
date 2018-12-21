package com.penn.algorithme;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		System.out.println(Arrays.toString(arr));
		int pivot = arr[left];// 基准数
		System.out.println("pivot:::" + pivot);
		int i = left;
		int j = right;
		while (i != j) {

			// 顺序很重要，先从右往左找
			while (arr[j] >= pivot && i < j) {
				j--;
			}
			// 再从左往右找
			while (arr[i] <= pivot && i < j) {
				i++;
			}
			// 交换两个数在数组中的位置
			if (i < j) { // 当哨兵i和哨兵j没有相遇时
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// 将基准数归位
		arr[left] = arr[i];
		arr[i] = pivot;
		quickSort(arr, left, i - 1);// 继续处理左边的，这里时一个递归的过程
		quickSort(arr, i + 1, right);// 继续处理右边的，这里时一个递归的过程
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 7, 9, 10, 8, 2, 3, 1, 6, 12 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
