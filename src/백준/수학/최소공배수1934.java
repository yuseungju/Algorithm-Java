//���� ��ó : https://www.acmicpc.net/problem/1934
//���� : �ּҰ����1934
//��Ŭ���� ȣ����

package ����.����;
import java.util.Scanner;

public class �ּҰ����1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			//n1�� n2���� ũ�� ����
			if(n1 < n2){
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}
			int gdc;
			int n = n1;
			int remainder = n2;
			while(true){
				if(remainder == 0){
					gdc = n;
					break;
				}else{
					int tempRemainder = n%remainder;
					n = remainder;
					remainder = tempRemainder;
				}
			}
			System.out.println(n1 * n2 /gdc);
		}
	}
}
