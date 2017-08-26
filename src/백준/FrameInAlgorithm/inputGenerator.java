package น้มุ.FrameInAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class inputGenerator {
	public static void main(String[] args) {
		int arr[]= {1,3,5,7,9,11,13,154,16,21,17};
		System.out.println(Arrays.toString(inputRangeNotOverlap(0,11, arr)));
	}

	public static int[] inputRangeNotOverlap(int min, int size){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[size];
		int it = 0;
		int num;
		for(int i = min; it < size;){
			num = (int) (Math.random() * size);
			if(arr[num] == 0){
				arr[num] = i;
				it++;
				i++;
			}
		}
		return arr;
	}
	public static int[] inputRangeNotOverlap(int min, int size, int except[]){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[size];
		int it = 0;
		int num;
		for(int i = min; it < size;){
			num = (int) (Math.random() * size);
			int j = 0;
			for(j = 0 ; j < except.length; j++){
				if(except[j] == i){
					i++;
					break;
				}
			}
			if(j != except.length)
				continue;
			if(arr[num] == 0){
				arr[num] = i;
				it++;
				i++;
			}
		}
		return arr;
	}
}
