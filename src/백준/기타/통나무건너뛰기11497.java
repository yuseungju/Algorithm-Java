//���� ��ó : https://www.acmicpc.net/problem/11497
//���� : �볪���ǳʶٱ�11497

package ����.��Ÿ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class �볪���ǳʶٱ�11497 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
			for(int test = 0; test < testcase; test++){
			int n = sc.nextInt();
			ArrayList<Integer>  list = new ArrayList<Integer>();
			ArrayList<Integer>  listResult = new ArrayList<Integer>();
			for(int i = 0; i < n; i++)
				list.add(sc.nextInt());
			Collections.sort(list);
	
			for(int i = 0; i < n; i++){
				if(i%2 == 0)
					listResult.add(list.get(i));
				else
					listResult.add(0, list.get(i));
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++){
				if(max < Math.abs(listResult.get(i) - listResult.get((i+1)%listResult.size())))
					max = Math.abs(listResult.get(i) - listResult.get((i+1)%listResult.size()));
			}
			System.out.println(max);
		}
	}
}
