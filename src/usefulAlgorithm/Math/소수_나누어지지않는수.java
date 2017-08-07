package usefulAlgorithm.Math;

import java.util.ArrayList;

public class 소수_나누어지지않는수 {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	//복잡도 Θ(root-n)
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=0; a < list.size(); a++){
			if(n%list.get(a) == 0)
				return false;//소수가아님
			if(list.get(a)* list.get(a) < a)
				break;
		}
		list.add(n);
		return true;//소수임
	}
	public static void main(String[] args) {
		System.out.println(isNum(1));
		System.out.println(isNum(1230));
		System.out.println(isNum(2));
		System.out.println(isNum(3));
		System.out.println(isNum(1993));
		System.out.println(isNum(1237));
	}
}
