//���� ��ó : https://www.acmicpc.net/problem/1017
//���� : �Ҽ���1017
//�̺и�Ī

package ����.�׷���;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class �Ҽ���1017 {
	public static ArrayList<Integer> primList = new ArrayList<Integer>();
	public static boolean isPrime(int  n){
		if(n == 1)
			return false;
		for(int a=0; a < primList.size(); a++){
			if(n == primList.get(a))//�Ҽ�����Ʈ�� �����ϴ°��̸� �Ҽ�
				return true;//�Ҽ���
			if(n < primList.get(a))//�Ҽ���ϰ��� ���Ұ����� Ŀ����
				return false;//���̻� �������
			if(n%primList.get(a) == 0)
				return false;//�Ҽ����ƴ�
			if(primList.get(a)* primList.get(a) < a)
				break;
		}
		primList.add(n);//�Ҽ���Ͽ� �Ҽ� �߰�
		return true;//�Ҽ���
	}
	public static int Arr1FromArr2[];
	public static int visitArr1[];
	public static boolean prime[][];
	public static int arr1[];
	public static int arr2[];
	public static int arrSize = 0;
	public static int pair1 = 0;
	public static int pair2 = 0;
	
	public static void main(String[] args) {
		//�Ҽ��� �̸� 2000���� ���
		for(int a=1; a<=2000; a++)
			isPrime(a);
		Scanner sc = new Scanner(System.in);
		//���� �Է�, Ȧ�� ¦�� �и�
		int numSize = sc.nextInt();
		arr1 = new int[numSize];
		arr2 = new int[numSize];
		int arr1Size = 0;
		int arr2Size = 0;
		int firstNum = arr1[arr1Size++] = sc.nextInt();
		for(int a = 1; a < numSize; a++){
			int num =  sc.nextInt();
			if(num%2 == firstNum%2)
				arr1[arr1Size++] = num;
			else
				arr2[arr2Size++] = num;
		}
		//Ȧ���� ¦���� ������ ���������� �����ѼҼ����� �Ұ���
		if(arr1Size != arr2Size){
			System.out.println(-1);
			return;
		}
		arrSize = arr1Size;
		
		//�Ҽ����� �̸� ����
		prime = new boolean[arrSize][arrSize];
		for(int a=0; a<arrSize; a++){
			for(int b=0; b<arrSize; b++)
				prime[a][b] = isPrime(arr2[b]+arr1[a]);
		}
		
		//�Ҽ����� �ɼ��ִ� ����� ù��° ��ҿ� ��Ī�Ǵ� ���� ����� ����
		ArrayList<Integer> result =  new ArrayList<Integer>();
		for(int i2 = 0; i2 < arrSize; i2++){
			//ù��°��ҿ� ���� �Ҽ����Ǵ� ���� ����
			pair1 = 0;
			pair2 = i2;
			boolean allConnented = true;//������ �Ҽ����� �������� ����
			if(prime[pair1][pair2]){//ù��°������ ���� �Ҽ��� �̷�� �� �ΰ��� ������ �ٸ������� ���� �Ҽ����Ǵ���Ȯ��	
				//System.out.println("��������Ȯ�� :"+ arr1[pair1]+"+"+ arr2[pair2]);
				Arr1FromArr2 = new int[arrSize];
				Arr1FromArr2[pair2] = pair1;
				for(int i1 = 1; i1 < arrSize; i1++){
					visitArr1 = new int[arrSize];
					if(!setConnect(i1)){//�ѹ��̶� �ڽ��ǽ��� ã���� ������(���� �Ҽ����Ǵ� ��������)
						allConnented = false;
						break;
					}
				}
				if(allConnented){//��翬���� ����������
					result.add(arr2[pair2]);
					/*for(int i = 0; i < Arr1FromArr2.length; i++)
						System.out.println(arr1[Arr1FromArr2[i]] +"-" + arr2[i] +":"+ (arr1[Arr1FromArr2[i]]  + arr2[i]));
					System.out.println();*/
				}
			}
		}
		Collections.sort(result);
		for(int i = 0; i < result.size(); i++)
			System.out.print(result.get(i) + " ");
		if(result.size() == 0)
			System.out.println(-1);
	}
	public static boolean setConnect(int it1){
		if(visitArr1[it1] == 1)
			return false;
		visitArr1[it1] = 1;
		for(int it2=0; it2<arrSize; it2++){
			if(prime[it1][it2] && pair1 != it1 && pair2 != it2){//���ᰡ���ϸ�(���� �Ҽ�)
				if(Arr1FromArr2[it2] == 0){//���� ����� ���� ���ٸ�
					Arr1FromArr2[it2] = it1;//�ٷο���
					return true;
				}
				if(setConnect(Arr1FromArr2[it2])){//�̹� ������ִٸ� �� ����� ���� �ٸ����� ����
					Arr1FromArr2[it2] = it1;//����
					return true;
				}
			}
		}
		return false;
	}
}



