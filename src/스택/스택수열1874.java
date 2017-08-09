//문제 출처 : https://www.acmicpc.net/problem/1874
//제목 : 스택수열1874

package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 스택수열1874 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder result =  new  StringBuilder();
		int n =  sc.nextInt();
		int arr[] = new int[n+1];
		int lastIndex = 0;
		arr[lastIndex] = 0;
		int currentNum =1;
		int purposeItem;
		int topItem;
		int number[] = new int[n];
		for(int a=0; a<n; a++)
			number[a] = sc.nextInt();
		for(int a=0; a<n; a++){
			purposeItem  = number[a];
			while(true){
				topItem = arr[lastIndex];
				if(topItem < purposeItem){
					if(currentNum + 1 < arr[lastIndex]){
						System.out.println("NO");
						return;
					}
					arr[++lastIndex] = currentNum++;
					result.append( "+\n");
					
				}else if(purposeItem == topItem){
					lastIndex--;
					result.append( "-\n");
					break;
				}else{
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println(result);
	}
}


