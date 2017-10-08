//���� ��ó : https://www.acmicpc.net/problem/6679
//���� : �̱��ѳ��ڸ�����6679


package ����.����;
import java.util.ArrayList;
import java.util.Collections;

public class �̱��ѳ��ڸ�����6679 {
	public static int arr12[];
	public static void main(String[] args) {
		for(int  i = 1000; i <= 9999; i++){
			ArrayList<Integer> l1 = toN(i,10);
			ArrayList<Integer> l2 = toN(i,12);
			ArrayList<Integer> l3 = toN(i,16);
			if(sumOfElements(l1) == sumOfElements(l2) &&  sumOfElements(l2) == sumOfElements(l3)){
				System.out.println(i);
			}
		}
	}
	//���ϴ� ����, ������ ������ �´� ���� ����Ʈ�� ������
	public static ArrayList<Integer> toN(int n, int express){
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true){
			list.add(n%express);
			n/=express;
			if(n == 0)
				break;
		}
		Collections.reverse(list);
		return list;
	}
	//����Ʈ ��ҵ��� ����
	public static int sumOfElements(ArrayList<Integer> list){
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		return sum;
	}
}
