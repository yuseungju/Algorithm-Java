//문제 출처 : https://www.acmicpc.net/problem/6679
//제목 : 싱기한네자리숫자6679


package 백준.수학;
import java.util.ArrayList;
import java.util.Collections;

public class 싱기한네자리숫자6679 {
	public static int arr12[];
	public static void main(String[] args) {
		for(int  i = 1000; i <= 9999; i++){
			ArrayList<Integer> l1 = toN(i,10);
			ArrayList<Integer> l2 = toN(i,12);
			ArrayList<Integer> l3 = toN(i,16);
			if(sumOfElements(l1) == sumOfElements(l2) &&  sumOfElements(l2) == sumOfElements(l3)){
				System.out.println(i);
			}
		}
	}
	//원하는 수와, 진법의 종류에 맞는 수를 리스트로 가져옴
	public static ArrayList<Integer> toN(int n, int express){
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true){
			list.add(n%express);
			n/=express;
			if(n == 0)
				break;
		}
		Collections.reverse(list);
		return list;
	}
	//리스트 요소들의 총합
	public static int sumOfElements(ArrayList<Integer> list){
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		return sum;
	}
}
