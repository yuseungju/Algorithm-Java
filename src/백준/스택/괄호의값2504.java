//문제 출처 : https://www.acmicpc.net/problem/2504
//제목 : 괄호의값2504


package 백준.스택;
import java.util.Scanner;
import java.util.Stack;

public class 괄호의값2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer str = new StringBuffer(sc.next());
		Stack<String> st = new Stack<String>();
		int it = 0;
		String stItem = "";
		int charNum = str.length();
		try{
			while(true){
				st.push(str.charAt(it)+"");
				if(')' == str.charAt(it)){//'(' 문자가 나올때까지  내부 요소를 더한다, / '('문자가 나오면 *2을 해준다				
					st.pop();// ')' 제거
					stItem = st.pop();
					int sum = 0;
					while(!stItem.equals("(")){
						if(isNumber(stItem))
							sum += Integer.parseInt(stItem);
						stItem = st.pop();
					}
					if(sum == 0)
						sum = 1;
					st.push(String.valueOf(sum * 2));
					charNum-=2;
				}else if(']' ==  str.charAt(it)){//   '[' 문자가 나올때까지  내부 요소를 더한다, / '['문자가 나오면 *3을 해준다
					st.pop();// ')' 제거
					stItem = st.pop();
					int sum = 0;
					while(!stItem.equals("[")){
						if(isNumber(stItem))
							sum += Integer.parseInt(stItem);
						stItem = st.pop();
					}
					if(sum == 0)
						sum = 1;
					st.push(String.valueOf(sum * 3));
					charNum-=2;
				}
				if(charNum == 0){//모든괄호를 다 사용했으면
					int sum = 0;
					while(!st.isEmpty()){
						sum += Integer.parseInt(st.pop());
					}
					System.out.println(sum);
					return;
				}
				it++;
			}
		}catch(Exception e){
			System.out.println(0);
		}
	}
	public static boolean isNumber(String str){
		try{
			Integer.parseInt(str);
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
