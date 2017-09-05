//���� ��ó : https://www.acmicpc.net/problem/1016
//���� : ����������1016

package ����.����;
import java.util.Scanner;
public class ����������1016 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = Long.valueOf(sc.next());
		long max = Long.valueOf(sc.next());
		if(max < min){
			System.out.println(0);
			return;
		}
		boolean noNum[] = new boolean[(int)(max - min + 1)];
		for(long i = 2;  i*i <= max; i++){//�������ִ� ��������ŭ
			for(long j = min/i/i; i*i*j <= max; j++){//�������� ����� �Ǵ� ������ ����ŭ
				if(0 <= (i*i*j-min))
					noNum[(int) (i*i*j-min)] = true;
			}
		}
		long result = 0;
		for(int i = 0; i < noNum.length; i++){
			if(!noNum[i])
				result++;
		}
		System.out.println(result);
	}

}