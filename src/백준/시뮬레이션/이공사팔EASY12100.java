//���� ��ó : https://www.acmicpc.net/problem/12100
//���� : 2048(easy)12100

package ����.�ùķ��̼�;

import java.util.Scanner;

public class �̰�����EASY12100 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) 
				arr[i][j] = sc.nextInt();
		}
		dfs(arr, 0);
		System.out.println(max);
	}

	public static int max = 0;
	public static void dfs(int arr[][],  int dept){
		if(dept == 5){
			int value= getMax(arr);
			if(max < value)
				max = value;
			return;
		}
		int copyArr1[][] = new int[arr.length][arr[0].length];
		int copyArr2[][] = new int[arr.length][arr[0].length];
		int copyArr3[][] = new int[arr.length][arr[0].length];
		int copyArr4[][] = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++){
			for(int  j = 0; j < arr[i].length; j++){
				copyArr1[i][j] = copyArr2[i][j] = copyArr3[i][j] = copyArr4[i][j] =  arr[i][j];
			}
		}
		//�̵���Ŵ
		moveR(copyArr1);
		dfs(copyArr1, dept + 1);
		moveL(copyArr2);
		dfs(copyArr2, dept + 1);
		moveU(copyArr3);
		dfs(copyArr3, dept + 1);
		moveD(copyArr4);
		dfs(copyArr4, dept + 1);
		
	}
	public static void print(int arr[][]){
		/*for(int i =0 ; i < arr.length ; i++){
			for(int j=0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		System.out.println();*/
	}

	public static int getMax(int arr[][]) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}
		return max;
	}
	public static void moveR(int arr[][]){
		int  n=  arr.length;
		// ���������� �̵�
		for (int y = 0; y < n; y++) {
			int visitX = n - 1;
			for (int x = visitX - 1; 0 <= x; x--) {
				for (int tailX = x + 1; tailX <= visitX; tailX++) {
					print(arr);
					if (arr[y][x] == 0)// ���� ��ġ�� 0�̸� �ƹ��͵� ��������
						break;
					// 0�̸� ������� //0�̸� ��ȯ
					if (arr[y][tailX] == 0) {
						int temp = arr[y][x];
						arr[y][x] = arr[y][tailX];
						arr[y][tailX] = temp;
						x++;
						continue;
					}
					// ��ġ��
					if (arr[y][tailX] != 0 && arr[y][x] == arr[y][tailX]) {
						arr[y][tailX] *= 2;
						arr[y][x] = 0;
						visitX = tailX - 1;
						break;
					} else {// �����������ϸ�
						visitX = x;
						break;
					}
				}
			}
		}
	}
	public static void moveL(int arr[][]){
		int  n=  arr.length;
		// ���������� �̵�
		for (int y = 0; y < n; y++) {
			int visitX = 0;//
			for (int x = visitX + 1; x < n ; x++) {
				for (int tailX = x - 1; visitX <= tailX; tailX--) {
					print(arr);
					if (arr[y][x] == 0)// ���� ��ġ�� 0�̸� �ƹ��͵� ��������
						break;
					// 0�̸� ������� //0�̸� ��ȯ
					if (arr[y][tailX] == 0) {
						int temp = arr[y][x];
						arr[y][x] = arr[y][tailX];
						arr[y][tailX] = temp;
						x--;
						continue;
					}
					// ��ġ��
					if (arr[y][tailX] != 0 && arr[y][x] == arr[y][tailX]) {
						arr[y][tailX] *= 2;
						arr[y][x] = 0;
						visitX = tailX + 1;
						break;
					} else {// �����������ϸ�
						visitX = x;
						break;
					}
				}
			}
		}
	}
	public static void moveD(int arr[][]){
		int  n =  arr.length;
		// ���������� �̵�
		for (int x = 0; x < n; x++) {
			int visitY = n - 1;
			for (int y = visitY - 1; 0 <= y; y--) {
				for (int tailY = y + 1; tailY <= visitY; tailY++) {
					print(arr);
					if (arr[y][x] == 0)// ���� ��ġ�� 0�̸� �ƹ��͵� ��������
						break;
					// 0�̸� ������� //0�̸� ��ȯ
					if (arr[tailY][x] == 0) {
						int temp = arr[y][x];
						arr[y][x] = arr[tailY][x];
						arr[tailY][x] = temp;
						y++;
						continue;
					}
					// ��ġ��
					if (arr[tailY][x] != 0 && arr[y][x] == arr[tailY][x]) {
						arr[tailY][x] *= 2;
						arr[y][x] = 0;
						visitY = tailY - 1;
						break;
					} else {// �����������ϸ�
						visitY = y;
						break;
					}
				}
			}
		}
	}
	public static void moveU(int arr[][]){
		int  n=  arr.length;
		// ���������� �̵�
		for (int x = 0; x < n; x++) {
			int visitY = 0;//
			for (int y = visitY + 1; y < n ; y++) {
				for (int tailY = y - 1; visitY <= tailY; tailY--) {
					print(arr);
					if (arr[y][x] == 0)// ���� ��ġ�� 0�̸� �ƹ��͵� ��������
						break;
					// 0�̸� ������� //0�̸� ��ȯ
					if (arr[tailY][x] == 0) {
						int temp = arr[y][x];
						arr[y][x] = arr[tailY][x];
						arr[tailY][x] = temp;
						y--;
						continue;
					}
					// ��ġ��
					if (arr[tailY][x] != 0 && arr[y][x] == arr[tailY][x]) {
						arr[tailY][x] *= 2;
						arr[y][x] = 0;
						visitY = tailY + 1;
						break;
					} else {// �����������ϸ�
						visitY = y;
						break;
					}
				}
			}
		}
	}
}
