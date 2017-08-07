package usefulAlgorithm.최대최소;

public class 최소값 {
	public static int getMinIt(int arr[]){
		int minIt = -1;
		int minValue = Integer.MAX_VALUE;
		for(int a=0; a<arr.length; a++){
			if(minValue > arr[a]){
				minValue = arr[a];
				minIt = a;
			}
		}
		return minIt;
	}
	public static int getMin(int arr[]){
		int minValue = Integer.MAX_VALUE;
		for(int a=0; a<arr.length; a++){
			if(minValue > arr[a]){
				minValue = arr[a];
			}
		}
		return minValue;
	}
	public static void main(String[] args) {
		int[] arr=  {2,3,5,6,1,562,562,89,12,3,23,3,99,102};
		System.out.println(arr[getMinIt(arr)]);
		System.out.println(getMin(arr));
	}
}

