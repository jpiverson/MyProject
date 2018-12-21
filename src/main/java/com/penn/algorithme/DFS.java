package com.penn.algorithme;

public class DFS {

	public static int[] a = new int[10];

	public static int[] book = new int[10];

	public static int total = 0;

	public static void dfs(int step) {

		int i = 0;

		if (step == 10) {
			if ((a[1] * 100 + a[2] * 10 + a[3]) + (a[4] * 100 + a[5] * 10 + a[6]) == (a[7] * 100 + a[8] * 10 + a[9])) {
				total++;
				System.out.println(String.format("%d%d%d + %d%d%d = %d%d%d\n", a[1], a[2], a[3], a[4], a[5], a[6], a[7],
						a[8], a[9]));
				return;
			}
		}

		for (i = 1; i <= 9; i++) {

			if (book[i] == 0) {
				a[step] = i;
				book[i] = 1;
				dfs(step + 1);
				book[i] = 0;
			}

		}
		return;

	}

	public static void main(String[] args) {

		dfs(1);
		System.out.println("total:::" + (total / 2));

	}

}
