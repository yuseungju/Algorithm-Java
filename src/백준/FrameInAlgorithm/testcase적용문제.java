package ����.FrameInAlgorithm;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class testcase���빮�� {
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
			testCase = sc.nextInt();//testcase�Է�
		run(testCase);
	}
	///////////////////testcase �ϳ��� ���� �ڵ� ���////////////////////////////
	public static int testCase = 0;//testcase�� ���°�� 1, testcase�� �Է¹޴°�� 0
	public static void solution(){
		print("11");
		println("22");
	}
	
}
