package usefulAlgorithm.Math;

public class �ִ밪 {
	public static int getMaxIt(int arr[]){
		int maxIt = -1;
		int maxValue = Integer.MIN_VALUE;
		for(int a=0; a<arr.length; a++){
			if(maxValue < arr[a]){
				maxValue = arr[a];
				maxIt = a;
			}
		}
		return maxIt;
	}
	public static int getMax(int arr[]){
		int maxValue = Integer.MIN_VALUE;
		for(int a=0; a<arr.length; a++){
			if(maxValue < arr[a]){
				maxValue = arr[a];
			}
		}
		return maxValue;
	}
	public static void main(String[] args) {
		int[] arr=  {2,3,5,6,1,562,562,89,12,3,23,3,99,102};
		System.out.println(arr[getMaxIt(arr)]);
		System.out.println(getMax(arr));
	}
}

