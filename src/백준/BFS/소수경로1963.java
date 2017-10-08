//문제 출처 : https://www.acmicpc.net/problem/1963
//제목 : 소수경로1963

package 백준.BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 소수경로1963 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static int n;
	public static int m;
	public static boolean isNum(int  n){
		if(n == 1)
			return false;
		
		for(int a=0; a < list.size(); a++){//검색의 값보다 작은 값(소수)들로 나누어지는지 확인
			if(n%list.get(a) == 0)//나누어지면
				return false;//소수가아님
			if(list.get(a)* list.get(a) < a)//제곱했을때 찾는 수보다 크면 더이상 나누어지는 수는 없음(다음 수는 더 크게됨)
				break;
		}
		list.add(n);
		return true;//소수임
	}
	public static boolean visit[];
	public static boolean possible[];
	public static void main(String[] args) {
		//소수 가능성을 설정
		possible = new boolean[10000];
		for(int a=1; a<10000; a++)
			isNum(a);
		for(int i = 0; i < list.size(); i++){
			if(1000 <= list.get(i))
				possible[list.get(i)] = true;
		}
		
		int testcase =  sc.nextInt();
		for(int test = 0; test < testcase; test++){
			visit = new boolean[10000];
			n = sc.nextInt();//초기 소수
			m = sc.nextInt();//목표 소수
			Queue<String> que = new LinkedList<String>();
			Queue<Integer> dept = new LinkedList<Integer>();
			//소수 처음값을 시작점으로 추가, 연산처리(dept)수 0
			dept.add(0);
			visit[n] = true;
			que.add(String.valueOf(n));
			int curDept = 0;
			
			while(!que.isEmpty()){
				//탐색할 소수와 탐색할 소수를 얻기까지의 연산수를 가져옴
				String num = que.peek();
				que.remove();
				curDept = dept.peek();//연산수
				dept.remove();
				//정답이면 출력하고 종료
				if(num.equals(String.valueOf(m))){
					System.out.println(curDept);
					break;
				}
				//다음 차례가 될수 있는 소수들의 경우를 모두구함
				for(int i = 0; i <= 9; i++){//대체될 자리의 수는 0~9까지 가능
					//각자리의 수를 변경하여 탐색
					String n1 = i + num.substring(1,4);
					String n2 = num.substring(0,1) + i + num.substring(2,4);
					String n3 = num.substring(0,2) + i + num.substring(3,4);
					String n4 = num.substring(0,3) + i;
					
					//소수이면서 탐색한적이 없다면 탐색할 값으로 추가
					if(!visit[Integer.parseInt(n1)] && possible[Integer.parseInt(n1)]){
						visit[Integer.parseInt(n1)] = true;
						que.add(n1);
						dept.add( curDept + 1);
					}
					if(!visit[Integer.parseInt(n2)]&& possible[Integer.parseInt(n2)]){
						visit[Integer.parseInt(n2)] = true;
						que.add(n2);
						dept.add( curDept + 1);
					}
					if(!visit[Integer.parseInt(n3)]&& possible[Integer.parseInt(n3)]){
						visit[Integer.parseInt(n3)] = true;
						que.add(n3);
						dept.add( curDept + 1);
					}
					if(!visit[Integer.parseInt(n4)]&& possible[Integer.parseInt(n4)]){
						visit[Integer.parseInt(n4)] = true;
						que.add(n4);
						dept.add( curDept + 1);
					}
				}
				
			}
		}
	}
}

