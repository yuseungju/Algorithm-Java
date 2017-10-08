package usefulAlgorithm.정렬;

import java.util.Arrays;

public class 퀵정렬 {
	//첫요소와  마지막요소의 인덱스를 이용한 병합정렬
	public static void quickAsc(int array[], int first, int end){
		int f = first;
		int e = end;
		int midValue =  array[(f+e)/2];
		while(f!=e){
			//작은값의 인덱스설정
			while(true){
				if(array[f] < midValue)
					f++;
				else 
					break;
			}
			//큰값의 인덱스설정
			while(true){
				if(midValue < array[e])
					e--;
				else 
					break;
			}
			int temp =  array[e];
			array[e] =  array[f];
			array[f] =  temp;
			if(array[f] == array[e] && f!=e)
				f++;
		}
		if(first < e-1)
			quickAsc(array, first, e-1);
		if(e+1 < end)
			quickAsc(array, e+1, end);
	} 
	//첫요소와  마지막요소의 인덱스를 이용한 병합정렬
	public static void quickDesc(int array[], int first, int end){
		int f = first;
		int e = end;
		int midValue =  array[(f+e)/2];
		while(f!=e){
			//작은값의 인덱스설정
			while(true){
				if(midValue < array[f])
					f++;
				else 
					break;
			}
			//큰값의 인덱스설정
			while(true){
				if(array[e] < midValue)
					e--;
				else 
					break;
			}
			if(array[f] == array[e] && f!=e){
				f++;
			}else{
				int temp =  array[e];
				array[e] =  array[f];
				array[f] =  temp;
			}
		}
		if(first < e-1)
			quickDesc(array, first, e-1);
		if(e+1 < end)
			quickDesc(array, e+1, end);
	} 
	public static void main(String[] args) {
		int[] src = {5,1,5,2,3,15,5,2,1,10,19,6,5,3,-1,9,9,29,3,3,4,2,2,3,4,5,1,2,3,12,3,2,3,1,2,3,1,-23};
		System.out.println(Arrays.toString(src));
		quickAsc(src, 0, src.length-1);
		System.out.println(Arrays.toString(src));
		quickDesc(src, 0, src.length-1);
		System.out.println(Arrays.toString(src));
	}
}
