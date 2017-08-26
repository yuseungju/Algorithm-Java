//문제 출처 : https://www.acmicpc.net/problem/1966
//제목 : 프린터큐1966

package 백준.큐;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐1966 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			Queue<Integer> qu = new LinkedList<Integer>();
			LinkedList<Integer> priorityList = new LinkedList<Integer>();
			
			int n = sc.nextInt();
			int targetIt = sc.nextInt();//프린트해야할 인쇄물의 자리(0부터 시작)
			for(int a=0; a<n; a++){
				//인쇄물들의 중요도설정(0부터 설정)
				int importN = sc.nextInt();
				qu.add(importN);//인쇄물들의 자리에 따라 중요도를 담음
				priorityList.add(importN);//중요도를 저장만함
			}
			Collections.sort(priorityList);
			Collections.reverse(priorityList);//저장된 가장큰 중요도부터 정렬
			
			int priorityIt = 0;
			int item;
			int priority;
			priority = priorityList.get(priorityIt++);//인쇄될수 있는 유일한 중요도를 하나 설정
			while(true){
				item = qu.peek();//현재 인쇄물의 중요도
				if(targetIt == 0 && priority == item){//타겟이 인쇄가능하면
					break;
				} else if(targetIt == 0){//타겟차례이지만 인쇄불가능시 큐의뒤로이동
					targetIt = qu.size(); 
					qu.add(item);
				} else if(priority != item){//현재요소가 처리할수 있는 요소가 아니면 뒤에 추가(나중에 다시처리해야되므로)
					qu.add(item);
				} else{ //처리되면
					priority = priorityList.get(priorityIt++);//현재 인쇄물이처리됐으면  중요도도 다음으로 이동
				}
				qu.remove();//체크한 건 제거
				targetIt--;//목표의 요소 인덱스는 큐의 앞으로 한칸 이동
			}
			System.out.println(priorityIt);
		}
	}
}
