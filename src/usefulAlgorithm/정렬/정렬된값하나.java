package usefulAlgorithm.정렬;

import java.util.Arrays;

public class 정렬된값하나 {
	public static int getPartSort(int arr[], int first, int end, int targetIt){
		int f = first;
		int e = end;
		int midValue = arr[(f+e)/2];
		while(f!=e){
			while(true){
				if(arr[f] < midValue)
					f++;
				else break;
			}
			while(true){
				if(midValue < arr[e])
					e--;
				else break;
			}
			if(arr[e] == arr[f] && f!=e){
				f++;
			}else{
				int temp = arr[e]; 
				arr[e] = arr[f];
				arr[f] = temp;
			}
		}
		
		if(targetIt < e){
			return getPartSort(arr,  first, e-1, targetIt);
		}else if(e < targetIt){
			return getPartSort(arr, e+1, end, targetIt);
		}else{
			return arr[targetIt];
		}
	}
	public static void main(String[] args) {
		int[] src = {5,1,5,2,3,5,8,8,-10,2,-12,10,99,16,15,13};
		System.out.println(Arrays.toString(src));
		for(int i = 0; i < src.length; i++)
			System.out.print(getPartSort(src, 0, src.length-1, i) + " ");
	}
}
