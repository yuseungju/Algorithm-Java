//문제 출처 : https://www.acmicpc.net/problem/1107
//제목 : 리모컨1107


package 백준.DP;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 리모컨1107 {
	public static boolean possible[];
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int goalNum = sc.nextInt();
		int impossibleSize = sc.nextInt();
		possible = new boolean[10];
		for(int i = 0; i < 10; i++)
			possible[i] = true;
		for(int i = 0; i < impossibleSize; i++)
			possible[sc.nextInt()] = false;
		setDirectNumList();
		
		//인접한 채널번호를 가져옴
		int recentNum = getRecent(goalNum);
		
		//입접합 채널번호로 먼저접근하는 방식과 오로지 +- 를 통해이동하는 경우중 최소값을 선택
		int min = String.valueOf(recentNum).length() + Math.abs(goalNum - recentNum);
		if(Math.abs(goalNum-100) < min)
			min = Math.abs(goalNum-100);
		
		//출력
		System.out.println(min);
	}
	//오로지 번호를 눌러 접근할수있는 채널을 설정한다.
	public static ArrayList<Integer> possibleList = new ArrayList<Integer>();//한번에 누를수있는 채널번호
	public static void setDirectNumList(){
		Queue<Integer> que = new LinkedList<Integer>();
		for(int len = 1; len <= 6; len++){
			if(len == 1){
				for(int n = 0; n < 10; n++){
					if(possible[n]){
						que.add(n);
						possibleList.add(n);
					}
				}
			}else{
				int size = que.size();
				for(int i = 0; i < size; i++){
					int item = que.peek();
					que.remove();
					for(int n = 0; n < 10; n++){
						if(item != 0){
							if(possible[n]){
								que.add(item*10 + n);
								possibleList.add(item*10 + n);
							}
						}
					}
				}
			}
		}
	}
	//가장 인접하는 채널의 번호를 얻는다.
	public static int getRecent(int goalNum){
		int recentNum = Integer.MAX_VALUE/2;
		int minIt = -1;
		for(int i = 0; i < possibleList.size(); i++){
			if(Math.abs(possibleList.get(i) - goalNum) < recentNum){
				recentNum = Math.abs(possibleList.get(i) - goalNum);
				minIt = i;
			}
		}
		if(minIt == -1)
			return Integer.MAX_VALUE/2;
		else
			return possibleList.get(minIt);
	}
}
