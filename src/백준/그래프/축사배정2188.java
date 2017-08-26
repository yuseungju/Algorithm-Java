//���� ��ó : https://www.acmicpc.net/problem/2188
//���� : ������2188
//�̺и�Ī, ��Ʈ��ũ�÷ο�, �ִ�����

package ����.�׷���;
import java.util.ArrayList;
import java.util.Scanner;

public class ������2188 {
	public static ArrayList<Integer> connction[];
	public static int startOfArrive[];
	public static int cowSize;
	public static int cowshedSize;
	public static int overlapCheck[] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cowSize = sc.nextInt()+1;//�� ����
		cowshedSize =  sc.nextInt()+1;//��� ����
		connction = new ArrayList[cowSize];//�ε���:���� ��ȣ , ��: ������ ����ȣ
		startOfArrive = new int[cowshedSize];//��縦 �����ϴ� ���� ��ȣ
		
		for(int j = 1; j < startOfArrive.length; j++)
			startOfArrive[j] = -1;
		
		//�Ҹ��� �����ɼ� �ִ� ��������� ����
		for(int i =1; i<connction.length; i++){
			connction[i] =  new ArrayList<Integer>();
			int cowshedSizeOfCow = sc.nextInt();
			for(int j = 0; j < cowshedSizeOfCow; j++)
				connction[i].add(sc.nextInt());
		}
		
		int maxMatching = 0;
		for(int i = 1; i < cowSize; i++){
			overlapCheck =  new int[cowSize];
			//System.out.println(i+"���� �Ұ� �� ��缳��*************");
			if(getPossibleArrive(i))//i��° �� ������
				maxMatching++;//���������ϸ� �������� +1
		}
		System.out.println(maxMatching);
	}
	public static boolean getPossibleArrive(int start){
		if(overlapCheck[start]  == 1)//���ᱸ�� ���ġ�� �ݺ� ����
			return false;
		overlapCheck[start] = 1; 
		int arrive;//�Ҹ� ������ ����ȣ
		for(int i=0; i< connction[start].size();i++ ){//�Ұ� ���ᰡ���� ��縸ŭ
			arrive = connction[start].get(i);
			if(startOfArrive[arrive] == -1){//�׳� ���� �����ϸ� ���� 
				startOfArrive[arrive] = start;
				//System.out.println(start + "->" + arrive);
				return true;
			}else if(getPossibleArrive(startOfArrive[arrive])){//���� ������ �����ѵ� ���ᰡ���ϸ� ����
				startOfArrive[arrive] = start;
				//System.out.println(start + "->" + arrive);
				return true;
			}
		}
		return false;
	}
}
