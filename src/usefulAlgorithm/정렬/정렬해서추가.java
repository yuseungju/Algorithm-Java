package usefulAlgorithm.정렬;

import java.util.Arrays;

public class 정렬해서추가 {
	public static void insertAscArray(int[] arr, int lastIndex, int item){
		if(arr.length-2 <= lastIndex )
			return;
		for(int a = lastIndex + 1; 0 < a; a--){
			if(arr[a-1] <= item){
				arr[a] = item;
				break;
			}else{
				arr[a] = arr[a-1];
			}
			if(a == 1)
				arr[0] = item;
		}
	}
	public static void insertDescArray(int[] arr, int lastIndex, int item){
		if(arr.length-2 <= lastIndex )
			return;
		for(int a = lastIndex + 1; 0 < a; a--){
			if(item <= arr[a-1]){
				arr[a] = item;
				break;
			}else{
				arr[a] = arr[a-1];
			}
			if(a == 1)
				arr[0] = item;
		}
	}
	public static void main(String[] args) {
		//오름차순 배열에 삽입시
		int[] src1 = {1,2,3,5,6,7,8,9,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println("before : "+Arrays.toString(src1));
		insertAscArray(src1, 8, 4);
		System.out.println("after  : "+Arrays.toString(src1));
		
		//내림차순 배열에 삽입시
		int[] src2 = {10,9,8,7,6,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println("before : "+ Arrays.toString(src2));
		insertDescArray(src2, 8, 5);
		System.out.println("after  : "+Arrays.toString(src2));
	}
}
