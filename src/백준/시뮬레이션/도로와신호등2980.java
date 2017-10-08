//���� ��ó : https://www.acmicpc.net/problem/2980
//���� : ���οͽ�ȣ��2980

package ����.�ùķ��̼�;
import java.util.ArrayList;
import java.util.Scanner;

public class ���οͽ�ȣ��2980 {
	static class Light{
		int green;
		int red;
		int pos;
		int currentRed;
		int currentGreen;
		char current;
		public Light(int pos, int red, int green) {
			super();
			this.green = green;
			this.red = red;
			this.pos = pos;
			currentRed = 0;
			currentGreen = 0;
			current = 'r';
		}
		public void nextTime(){
			if(current == 'r'){
				currentRed++;
				if(currentRed == red){
					current = 'g';
					currentRed = 0;
				}
			}else{
				currentGreen++;
				if(currentGreen == green){
					current = 'r';
					currentGreen = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int length = sc.nextInt();
		ArrayList<Light> list = new ArrayList<Light>();
		for(int  i =0; i < num; i++)
			list.add(new Light(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		int moveTime = 0;
		for(int x = 0; x < length; moveTime++, x++){
			//��ȣ���� ������ �׳��̵�
			if(list.isEmpty())
				continue;
			
			if(x == list.get(0).pos){
				if(list.get(0).current == 'g')
					list.remove(0);
				else
					x--;
			}
			allNext(list);
		}
		System.out.println(moveTime);
	}

	public static void allNext(ArrayList<Light> list) {
		for (int i = 0; i < list.size(); i++)
			list.get(i).nextTime();
	}
}
