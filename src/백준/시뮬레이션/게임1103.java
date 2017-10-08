//���� ��ó : https://www.acmicpc.net/problem/1103
//���� : ����1103

package ����.�ùķ��̼�;
import java.util.Arrays;
import java.util.Scanner;

public class ����1103 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt() + 2;
		width =  sc.nextInt() + 2; 
		arr =  new int[height][width];
		visit = new boolean[height][width];
		partMax = new int[height][width];
		for (int y = 1; y < height - 1; y++) {
			String str = sc.next();
			for (int x = 1; x < width - 1; x++) 
				if(str.charAt(x-1) != 'H')
					arr[y][x] =Integer.parseInt(str.charAt(x-1) + "");
		}
		//for(int i = 0; i < height; i++){
		//	System.out.println(Arrays.toString(arr[i])); 
		//}
		partMax[1][1] = -1;
		dfs(1,1,0);
		System.out.println(max);
		
	}
	public static int height;
	public static int width;
	public static int arr[][];
	public static boolean visit[][];
	public static int partMax[][];
	public static int max = Integer.MIN_VALUE;
	public static void dfs(int x, int y, int dept){
		if(max == -1)//�̹� ������ �����ϴ� ��Ȳ�̶��
			return;
		
		//������ ����ų� ���� ���ۿ� ���߸���
		if(y <= 0 || x <= 0 || height-1 <= y || width-1 <= x || arr[y][x] == 0){
			if(max < dept)
				max = dept;
				return;
		}
		
		if(dept <= partMax[y][x])
			return;
		partMax[y][x] = dept;
		
		//������ �����
		if(visit[y][x] == true){
			max = -1;
			return;
		}
		
		//������ ���� ���ο� �湮 �������� ��� Ž���� �����ϸ�
		visit[y][x] = true;
		dfs(x + arr[y][x], y, dept+1);//���������� �̵�
		dfs(x , y + arr[y][x], dept+1);//�Ʒ��� �̵�
		dfs(x , y - arr[y][x], dept+1);//���� �̵�
		dfs(x - arr[y][x], y, dept+1);//�������� �̵�
		visit[y][x] = false;
	}
}
