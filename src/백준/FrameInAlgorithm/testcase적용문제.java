package 백준.FrameInAlgorithm;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class testcase적용문제 {
	public static Scanner sc = new Scanner(System.in);
	public static String  result = "";
	public static void run(int testCase){
		for(int t = 0; t < testCase; t++)
			solution();
		System.out.println(result);
	}
	public static void print(String str){
		result += str;
	}
	public static void println(String str){
		result += str + "\n";
	}
	public static void main(String[] args) {
		if(testCase == 0)
			testCase = sc.nextInt();//testcase입력
		run(testCase);
	}
	///////////////////testcase 하나에 대한 코드 답안////////////////////////////
	public static int testCase = 0;//testcase가 없는경우 1, testcase를 입력받는경우 0
	public static void solution(){
		print("11");
		println("22");
	}
	
}
