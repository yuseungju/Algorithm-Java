package usefulAlgorithm.Ž��;

import java.util.Scanner;

public class ����Ž�� {
	//���ĵ� ����Ʈ�� ����Ž���Ѵ�.
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
		int[] src =  {-11,-10,2,3,6,9};//���ĵ� ����Ʈ
		System.out.println(binarySearch(src, 4));
		System.out.println(binarySearch(src, -11));
	}
}
