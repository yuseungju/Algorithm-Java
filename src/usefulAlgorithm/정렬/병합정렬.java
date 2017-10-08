package usefulAlgorithm.정렬;

import java.util.Arrays;

public class 병합정렬 {
	//첫요소와  마지막요소의 인덱스를 이용한 병합정렬
	public static void mergeAsc(int array[], int f, int e){
		if(f >= e)
			return;
		int mid = (f+e)/2;
		mergeAsc(array, f, mid);
		mergeAsc(array, mid + 1, e);
		int arr1[] =  new int[mid - f +1];
		int arr2[] =  new int[e - (mid + 1) + 1];
		for(int a1 = 0; a1 < arr1.length; a1++)
			arr1[a1] = array[a1 + f];
		for(int a2 = 0; a2 < arr2.length; a2++)
			arr2[a2] = array[a2 + mid + 1];
		
		int arr1It = 0;
		int arr2It = 0;
		for(int a=f; a<=e; a++){
			if(arr1.length == arr1It){
				array[a] = arr2[arr2It++];
				continue;
			} else if(arr2.length == arr2It){
				array[a] = arr1[arr1It++];
				continue;
			}
			if(arr1[arr1It] < arr2[arr2It])
				array[a] = arr1[arr1It++];
			else
				array[a] = arr2[arr2It++];
		}
	}

	//첫요소와  마지막요소의 인덱스를 이용한 병합정렬
	public static void mergeDesc(int array[], int f, int e){
		if(f >= e)
			return;
		int mid = (f+e)/2;
		mergeDesc(array, f, mid);
		mergeDesc(array, mid + 1, e);
		int arr1[] =  new int[mid - f +1];
		int arr2[] =  new int[e - (mid + 1) + 1];
		for(int a1 = 0; a1 < arr1.length; a1++)
			arr1[a1] = array[a1 + f];
		for(int a2 = 0; a2 < arr2.length; a2++)
			arr2[a2] = array[a2 + mid + 1];
		
		int arr1It = 0;
		int arr2It = 0;
		for(int a=f; a<=e; a++){
			if(arr1.length == arr1It){
				array[a] = arr2[arr2It++];
				continue;
			} else if(arr2.length == arr2It){
				array[a] = arr1[arr1It++];
				continue;
			}
			if(arr1[arr1It] > arr2[arr2It])
				array[a] = arr1[arr1It++];
			else
				array[a] = arr2[arr2It++];
		}
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		int[] src = {5, 4, 6,7 ,8 ,9, 10, 15, 17, 18, 19, 20, 11, 12, 13, 14, 16};
		System.out.println(Arrays.toString(src));
		mergeAsc(src, 0, src.length-1);
		System.out.println(Arrays.toString(src));
		mergeDesc(src, 0, src.length-1);
		System.out.println(Arrays.toString(src));
	}
}
