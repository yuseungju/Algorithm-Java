//문제 출처 : https://www.acmicpc.net/problem/2578
//제목 : 빙고2578

package 백준.기타;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 빙고2578 {
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
		//빙고판 입력
		Scanner sc = new Scanner(System.in);
		int arr[][] =  new int[5][5];//[세로][가로]
		Pos arrIndex[] =  new Pos[26];//1~25까지의 수의 위치
		for(int i = 1; i < 26; i++)
			arrIndex[i] = new Pos(-1,-1);
		
		for(int a = 0; a < 5; a++){//세로만큼
			for(int b = 0; b < 5;  b++){//가로만큼
				int num = sc.nextInt();
				arr[a][b] = num;
				arrIndex[num].x = b;
				arrIndex[num].y = a;
			}
		}
		//순서대로 불려지는 숫자입력
		Queue<Integer> numSelect = new LinkedList<Integer>();
		for(int a = 0; a < 5; a++){//세로만큼
			for(int b = 0; b < 5;  b++)//가로만큼
				numSelect.add(sc.nextInt());
		}
		int row = 1;
		while(!numSelect.isEmpty()){
			//빙고판에서 번호하나를 지움
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
	public static int resultNum = 0;//정답 줄의 수
	public static int res1[] = new int[5];//가로
	public static int res2[] = new int[5];//세로
	public static int res3[] = new int[2];//대각선
	public static void result(int arr[][], int x, int y){
		res1[x]++;//가로 빙고줄 체크
		if(res1[x] == 5)
			resultNum++;
		res2[y]++;//세로 빙고줄 체크
		if(res2[y] == 5)
			resultNum++;
		if(y==x){//오른쪽 아래방향 대각선 체크
			res3[0]++;
			if(res3[0] == 5)
				resultNum++;
		}
		if(x+y == 4){//왼쪽 아래방향 대각선 체크
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
