//문제 출처 : https://www.acmicpc.net/problem/1021
//제목 : 회전하는큐1021

package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class 회전하는큐1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int allNum =sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= allNum; i++)
			list.add(i);

		int n = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			input.add(sc.nextInt());
		
		int count = 0;
		for(int i = 0; i < n; i++){
			int find = input.get(0);
			if(getRecent(list, find) == 'r'){
				while(true){
					if(list.get(0) != find){
						count++;
						rightMove(list);
					}else{
						list.remove(0);
						break;
					}
				}
			}else{
				while(true){
					if(list.get(0) != find){
						count++;
						leftMove(list);
					}else{
						list.remove(0);
						break;
					}
				}
			}
			input.remove(0);
		}
		System.out.println(count);
	}
	
	public static void rightMove(ArrayList<Integer> list){
		list.add(0,list.get(list.size()-1));
		list.remove(list.size()-1);
	}
	public static void leftMove(ArrayList<Integer> list){
		list.add(list.get(0));
		list.remove(0);
	}
	public static char getRecent(ArrayList<Integer> list, int item){
		int r = list.size()-1;
		int l = 0;
		while(true){
			if(list.get(l) == item)
				return 'l';
			
			if(list.get(r) == item)
				return 'r';
			r--;
			l++;
		}
	}
}
