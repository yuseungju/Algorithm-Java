//문제 출처 : https://www.acmicpc.net/problem/1254
//제목 : 팰린드롬만들기1254


package 백준.기타;
import java.util.ArrayList;
import java.util.Scanner;

public class 팰린드롬만들기1254 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =  sc.next();
		int deleteIndex = str.length();
		char arr[] = new char[str.length()*2];
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0;  i < str.length(); i++){
			arr[i] = str.charAt(i);
			arr[str.length()*2 -1 - i] = str.charAt(i);
		}
		for(int  i = 0; i < arr.length; i++)
			list.add(arr[i]);

		int length = 0;
		while(deleteIndex != list.size()){
			list.remove(deleteIndex);
			if(checkPossible(list))
				length = list.size();
		}
		System.out.println(length);
	}
	public static boolean checkPossible(ArrayList<Character> list){
		int i = 0;
		int j = list.size() - 1;
		while(i <= j){
			if(list.get(i) != list.get(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
