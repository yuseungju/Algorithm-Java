//문제 출처 : https://www.acmicpc.net/problem/1342
//제목 : 행운의문자열1342


package 백준.DFS;
import java.util.Scanner;

public class 행운의문자열1342 {
	public static int result = 0;
	public static int allLength = 0;
	public static  int usefulCount[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		usefulCount = new int[26];//-97로 알파벳의 인덱스접근
		for(int i = 0; i < str.length(); i++){
			usefulCount[str.charAt(i) - 97]++;
			allLength++;
		}
		searchAllCase();
		System.out.println(result);
	}
	public static void searchAllCase(){
		for(int i = 0; i < 26; i++){
			if(0 < usefulCount[i]){
				usefulCount[i] --;
				dfs(i, 0);
				usefulCount[i] ++;
			}
		}
	}
	public static void dfs(int it, int dept){
		dept ++;
		if(dept == allLength){
			result++;
			return;
		}
		for(int i = 0; i < 26; i++){
			if(0 < usefulCount[i] && i != it){
				usefulCount[i] --;
				dfs(i, dept);
				usefulCount[i] ++;
			}
		}
	}
}





