package com.penn.algorithme;

/*
 * 
 * 
 *      1   2   3   4   5  
 *    _____________________                  1  
 * 1  | 0 | 1 | 1 | + | 1 |                / | \
 * 2  | 1 | 0 | + | 1 | + |               /  |  \
 * 3  | 1 | + | 0 | + | 1 |              2   3---5
 * 4  | + | 1 | + | 0 | + |              |
 * 5  | 1 | + | 1 | + | 0 |              |
 *    ---------------------              4 
 * 
 * 二维数组中第i行第j列表示的就是顶点i到顶点j是否有边。
 * 1表示有边，+表示没有边，自己到自己(i=j)设为0. 这种存储图成为图的邻接矩阵存储发
 */
public class UndigraphDFS {

	int[] book = new int[101];// 已经访问的顶点
	int sum = 0;// 已经访问顶点的个数
	int n = 0;// 图的顶点的个数
	int[][] e = new int[101][101];// 图的边(邻接矩阵)

	/**
	 * 
	 * @param cur 当前正在遍历的定点
	 */
	void dfs(int cur) {

		System.out.println("cur:::" + cur);
		sum++;
		if (sum == n) {
			return;
		}
		for (int i = 1; i <= n; i++) {// 从1号顶点到n号顶点依次尝试，看那些年顶点与当前顶点cur有边相连
			// 判断为当前顶点cur到顶点i是否有边，并判断顶点i是否已经访问过
			if (e[cur][i] == 1 && book[i] == 0) {
				book[i] = 1;
				dfs(i);
			}
		}
		return;
	}

	void initAndRun(int n) {
		UndigraphDFS dfs = new UndigraphDFS();
		dfs.n = n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				if (i == j) {
					dfs.e[i][j] = 0;
				} else {
					dfs.e[i][j] = 99999999;
				}
			}
		}
		dfs.e[1][2] = 1;
		dfs.e[2][1] = 1;
		dfs.e[1][3] = 1;
		dfs.e[3][1] = 1;
		dfs.e[1][5] = 1;
		dfs.e[5][1] = 1;
		dfs.e[2][4] = 1;
		dfs.e[4][2] = 1;
		dfs.e[3][5] = 1;
		dfs.e[5][3] = 1;
		dfs.book[1] = 1;
		dfs.dfs(1);
	}

	public static void main(String[] args) {
		UndigraphDFS undigraphDFS = new UndigraphDFS();
		undigraphDFS.initAndRun(5);
	}
}
