//���� ��ó : https://www.acmicpc.net/problem/9517
//���� : ���̷���ũ�ξ�Ƽ��9517

package ����.�ùķ��̼�;
import java.util.Scanner;

public class ���̷���ũ�ξ�Ƽ��9517 {
	static class Time{
		int h;
		int m;
		int s;
		public Time(int h, int m, int s) {
			super();
			this.h = h;
			this.m = m;
			this.s = s;
		}
		public void plus(int second){
			s += second;
			if(60 <= s){
				m += s/60;
				s %= 60;
			} 
			if(60 <= m){
				h += m/60;
				m %= 60;
			} 
		}
		public String toString() {
			return "Time [h=" + h + ", m=" + m + ", s=" + s + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int currentPerson = sc.nextInt();
		int n = sc.nextInt();
		Time allTime = new Time(0,0,0);
		int result = -1;
		for(int i =0; i < n; i++){
			//�ð���������
			int spendTime = sc.nextInt();
			allTime.plus(spendTime);
			//�ش�ð��� �ٵǸ� ���ӿ���
			if(210 <= allTime.s + allTime.m * 60){
				if(result == -1)
					result = currentPerson;
			}
			//���� ����
			if('T' == sc.next().charAt(0))
				currentPerson = next(8,currentPerson);//�������
		}
		System.out.println(result);
	}
	public static int next(int limit, int n){
		n++;
		if(n <= limit)
			return n;
		return 1;
	}
}
