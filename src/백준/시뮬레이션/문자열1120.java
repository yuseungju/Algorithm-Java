//문제 출처 : https://www.acmicpc.net/problem/1120
//제목 : 문자열1120

package 백준.시뮬레이션;
import java.util.Scanner;

public class 문자열1120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strSmall = sc.next();
		String strBig = sc.next();
		int min = Integer.MAX_VALUE;
		for(int i =0; strSmall.length() + i <= strBig.length(); i++){
			int value = getNotSame(strSmall, strBig.substring(i, i + strSmall.length()));
			if(value < min)
				min = value;
		}
		System.out.println(min);
	}
	public static int getNotSame(String str1, String str2){
		int num = 0;
		for(int i = 0; i < str1.length(); i++){
			if(str1.charAt(i) != str2.charAt(i))
				num++;
		}
		return num;
	}
}
