//문제 출처 : https://www.acmicpc.net/problem/1057
//제목 : 토너먼트1057


package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class 토너먼트1057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int person1 =  sc.nextInt(); 
		int person2 =  sc.nextInt();
		ArrayList<Integer>  list = new ArrayList<Integer>();
		for(int  i = 1; i <= n ; i++)
			list.add(i);

		int count = 1;
		int result = -1;
		while(!list.isEmpty()){
			for(int  i = 0; i < list.size()-1; i++){
				if((list.get(i) == person1 && list.get(i+1) == person2)
						|| (list.get(i) == person2 && list.get(i+1) == person1)){//두선수가만나면
					result = count;
					list.clear();
				}else if(list.get(i) == person1 || list.get(i) == person2){//해당 선수의 경기이면 
					list.remove(i+1);
				}else{
					list.remove(i);
				}
				//System.out.println(list);
			}
			//System.out.println(count);
			count++;
		}
		System.out.println(result);
		
	}
}
