//문제 출처 : https://www.acmicpc.net/problem/1062
//제목 : 가르침1062

package 백준.시뮬레이션;
import java.util.Arrays;
import java.util.Scanner;

public class 가르침1062 {
	static class Word{
		public boolean alphabets[] = new boolean[26];
		public boolean correct(boolean compare[]){
			for(int i = 0; i < 26; i++){
				if(alphabets[i] && !compare[i])
					return false;
			}
			return true;
		}
		public boolean[] getAlphabets() {
			return alphabets;
		}
		public void setAlphabets(String str) {
			for(int i =0; i < str.length(); i++)
				alphabets[str.charAt(i)-97] = true;
		}
		@Override
		public String toString() {
			return "word [alphabets=" + Arrays.toString(alphabets) + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		useNum = sc.nextInt(); 
		words = new Word[n];
		for(int i = 0; i < n; i++){
			words[i] = new Word();
			words[i].setAlphabets(sc.next());
		}
		dfs(0, 0);
		System.out.println(max);
	}
	public static int useNum;
	public static int max = 0;
	public static boolean visit[] = new boolean[26];
	public static Word words[];
	public static void dfs(int start, int dept){
		int value = 0;
		if(dept == useNum){
			for(int i =0; i < words.length; i++){
				if(words[i].correct(visit)){
					value++;
				}
			}
			if(max < value)
				max = value;
			return;
		}
		for(int i = start; i < 26; i++){
			if(!visit[i]){
				visit[i] = true;
				dfs(i + 1 , dept + 1);
				visit[i] = false;	
			}
		}
	}
}





