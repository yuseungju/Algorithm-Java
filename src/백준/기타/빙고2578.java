//���� ��ó : https://www.acmicpc.net/problem/2578
//���� : ����2578

package ����.��Ÿ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ����2578 {
	public static class Pos{
		public int x;
		public int y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return x+","+y;
		}
	}
	public static void main(String[] args) {
		//������ �Է�
		Scanner sc = new Scanner(System.in);
		int arr[][] =  new int[5][5];//[����][����]
		Pos arrIndex[] =  new Pos[26];//1~25������ ���� ��ġ
		for(int i = 1; i < 26; i++)
			arrIndex[i] = new Pos(-1,-1);
		
		for(int a = 0; a < 5; a++){//���θ�ŭ
			for(int b = 0; b < 5;  b++){//���θ�ŭ
				int num = sc.nextInt();
				arr[a][b] = num;
				arrIndex[num].x = b;
				arrIndex[num].y = a;
			}
		}
		//������� �ҷ����� �����Է�
		Queue<Integer> numSelect = new LinkedList<Integer>();
		for(int a = 0; a < 5; a++){//���θ�ŭ
			for(int b = 0; b < 5;  b++)//���θ�ŭ
				numSelect.add(sc.nextInt());
		}
		int row = 1;
		while(!numSelect.isEmpty()){
			//�����ǿ��� ��ȣ�ϳ��� ����
			Integer eraseArr =  numSelect.peek();
			numSelect.remove();
			result(arr, arrIndex[eraseArr].x, arrIndex[eraseArr].y);
			if(3 <= resultNum){
				System.out.println(row);
				return;
			}
			row++;
		}
		
	}
	public static int resultNum = 0;//���� ���� ��
	public static int res1[] = new int[5];//����
	public static int res2[] = new int[5];//����
	public static int res3[] = new int[2];//�밢��
	public static void result(int arr[][], int x, int y){
		res1[x]++;//���� ������ üũ
		if(res1[x] == 5)
			resultNum++;
		res2[y]++;//���� ������ üũ
		if(res2[y] == 5)
			resultNum++;
		if(y==x){//������ �Ʒ����� �밢�� üũ
			res3[0]++;
			if(res3[0] == 5)
				resultNum++;
		}
		if(x+y == 4){//���� �Ʒ����� �밢�� üũ
			res3[1]++;
			if(res3[1] == 5)
				resultNum++;
		}
		/*System.out.println("chk=>" + x +","+y);
		System.out.println(Arrays.toString(res1));
		System.out.println(Arrays.toString(res2));
		System.out.println(Arrays.toString(res3));
		System.out.println();*/
	}
}
