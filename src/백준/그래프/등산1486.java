//문제 출처 : https://www.acmicpc.net/problem/1486
//제목 : 등산1486
//플로이드와샬 알고리즘

package 백준.그래프;
import java.util.Scanner;

public class 등산1486 {
	public static int height;
	public static int width;
	public static int T;
	public static int limitTime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		T = sc.nextInt();
		limitTime = sc.nextInt();
		int xy[][] = new int[height][width];
		for (int i = 0; i < height; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) <= 90)
					xy[i][j] = (int) str.charAt(j) - 65;
				else
					xy[i][j] = (int) str.charAt(j) - 71;
			}
		}
/*		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				System.out.print(xy[i][j] + " ");
			System.out.println();
		}
		System.out.println();*/

		int weight[][][][] = new int[height][width][height][width];// x,y(시작) -> x,y(도착) 에 따른 시간 소요값 (최소)
		for (int i1 = 0; i1 < height; i1++) {
			for (int i2 = 0; i2 < width; i2++) {
				for (int i3 = 0; i3 < height; i3++) {
					for (int i4 = 0; i4 < width; i4++) {
						if (i1 == i3 && i2 == i4) {
							weight[i1][i2][i3][i4] = 0;
						} else if (i1 == i3 && i2 + 1 == i4) {// x,y-> x+1,y
							weight[i1][i2][i3][i4] = getWeight(xy[i1][i2],
									xy[i3][i4]);
						} else if (i1 == i3 && i2 - 1 == i4) {// x,y-> x-1,y
							weight[i1][i2][i3][i4] = getWeight(xy[i1][i2],
									xy[i3][i4]);
						} else if (i1 == i3 + 1 && i2 == i4) {// x,y-> x,y+1
							weight[i1][i2][i3][i4] = getWeight(xy[i1][i2],
									xy[i3][i4]);
						} else if (i1 == i3 - 1 && i2 == i4) {// x,y-> x,y-1
							weight[i1][i2][i3][i4] = getWeight(xy[i1][i2],
									xy[i3][i4]);
						} else {
							weight[i1][i2][i3][i4] = Integer.MAX_VALUE/2;
						}
					}
				}
			}
		}

		for (int ky = 0; ky < height; ky++) {
			for (int kx = 0; kx < width; kx++) {
				for (int sy = 0; sy < height; sy++) {
					for (int sx = 0; sx < width; sx++) {
						for (int ey = 0; ey < height; ey++) {
							for (int ex = 0; ex < width; ex++) {
								if (weight[sy][sx][ky][kx]
										+ weight[ky][kx][ey][ex] < weight[sy][sx][ey][ex]) {
									weight[sy][sx][ey][ex] = weight[sy][sx][ky][kx]
											+ weight[ky][kx][ey][ex];
								}
							}
						}
					}
				}
			}
		}
/*		System.out.println();
		System.out.println();
		System.out.println();
		for (int i2 = 0; i2 < height; i2++) {
			for (int i1 = 0; i1 < height; i1++) {
				for (int i4 = 0; i4 < height; i4++) {
					for (int i3 = 0; i3 < height; i3++) {
						System.err.println("(" + i2 + "," + i1 + ")->(" + i4
								+ "," + i3 + "): " + weight[i1][i2][i3][i4]);
					}
				}
				System.err.println("----------------------------");
			}
		}*/

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++){
				if(weight[0][0][i][j]  + weight[i][j][0][0] <= limitTime){//시간초과가 안났을때 방문좌표
					if(max < xy[i][j]){//방문좌표의 높이를 결과값(최고높이)에 반영
						max = xy[i][j];
						//System.out.println("방문:"+ i+","+j+":"+max);
					}
				}
			}
		}
		System.out.println(max);
	}

	public static int getWeight(int startValue, int arriveValue) {
		if (T < Math.abs(arriveValue - startValue)) 
			return Integer.MAX_VALUE/2;
		if (arriveValue <= startValue) 
			return 1;
		else 
			return (int) Math.pow((arriveValue - startValue), 2);
		
	}
}