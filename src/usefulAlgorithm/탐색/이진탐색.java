package usefulAlgorithm.탐색;

import java.util.Scanner;

public class 이진탐색 {
	//정렬된 리스트를 이진탐색한다.
	public static boolean binarySearch(int [] arr, int findNum){
		int f = 0; 
		int e = arr.length;
		int m = (f+e)/2;
		while(true){
			if(m == f)
				return false;
			if(arr[m] < findNum){
				f = m;
			}else if(arr[m] > findNum){
				e = m;
			}
			m = (f+e)/2;
			if(arr[m] == findNum)
				return true;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] src =  {-11,-10,2,3,6,9};//정렬된 리스트
		System.out.println(binarySearch(src, 4));
		System.out.println(binarySearch(src, -11));
	}
}
