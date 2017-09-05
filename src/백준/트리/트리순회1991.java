package 백준.트리;

import java.util.Arrays;
import java.util.Scanner;

public class 트리순회1991 {
	public static  int branchR[];
	public static  int branchL[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		branchR = new int[n];
		branchL = new int[n];
		//입력된 알파벳을 인덱스 0~25의 값으로 변환 
		for(int i = 0; i < n; i++){
			int root = getIndexOfAlpha(sc);
			branchL[root] = getIndexOfAlpha(sc);
			branchR[root] = getIndexOfAlpha(sc);
		}
		searchPreorder(0);//전위탐색
		System.out.println();
		searchInorder(0);//중위탐색
		System.out.println();
		searchPostorder(0);//후위탐색
	}
	//전위탐색
	public static void searchPreorder(int index){
		if(index == -1)
			return;
		System.out.print((char)(index + 'A'));
		searchPreorder(branchL[index]);
		searchPreorder(branchR[index]);
	}
	//중위탐색
	public static void searchInorder(int index){
		if(index == -1)
			return;
		searchInorder(branchL[index]);
		System.out.print((char)(index + 'A'));
		searchInorder(branchR[index]);
	}
	//후위탐색
	public static void searchPostorder(int index){
		if(index == -1)
			return;
		searchPostorder(branchL[index]);
		searchPostorder(branchR[index]);
		System.out.print((char)(index + 'A'));
	}
	public static int getIndexOfAlpha(Scanner sc){
		char in = sc.next().charAt(0);
		if(in == '.')
			return -1;
		else
			return in - 'A';
	}
}
