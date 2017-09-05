//문제 출처 : https://www.acmicpc.net/problem/2371
//제목 : 파일구별하기2371

package 백준.기타;

import java.util.ArrayList;
import java.util.Scanner;

public class 파일구별하기2371 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		ArrayList<Integer>  list = new ArrayList<Integer>();
		ArrayList<Integer> arr[] =  new ArrayList[n];
		for(int i = 0; i < arr.length; i++)
			arr[i] = new ArrayList<Integer>();
		
		for(int fileIt = 0;  fileIt < n; fileIt++){
			while(true){
				int byteItem = sc.nextInt();
				if(byteItem == -1)
					break;
				else
					arr[fileIt].add(byteItem);
			}
		}
		
		boolean same = false;
		int  k = 0;
		while(true){
			same = false;
			for(int i= 0; i < n-1 && !same; i++){
				for(int j = i+1; j < n && !same;  j++){
					if(arr[i].size() -1 < k || arr[j].size() -1 < k)
						continue;
					/*System.out.println(i+" list (it"+ k + ")");
					System.out.println(j+" list (it"+ k + ")");
					System.out.println(arr[i].get(k) + " == "  +arr[j].get(k));*/
					if(arr[i].get(k) == arr[j].get(k))
						same = true;
				}
			}	
			if(!same){
				System.out.println(k+1);
				return;
			}
			k++;
		}
	}
}




