//���� ��ó : https://www.acmicpc.net/problem/3653
//���� : ��ȭ����3653
//���׸�Ʈ Ʈ��

package ����.Ʈ��;
import java.util.Scanner;

public class ��ȭ����3653 {
	public static int arr[];
	public static int height;
	public static int allArrSize;
	public static  int pos[];
	private static void setAllTree(){
		height = 0;
		pos = new int[1000000+1];
		for(height = 0; Math.pow(2,height) < 1000000*2; height++);
		allArrSize = (int) Math.pow(2,height) * 2; 
		height++;
		arr = new int[allArrSize];
	}
	public static void initBook(int realItemSize){
		int boolNum = 1;
		for(int i = allArrSize*3/4; i < allArrSize*3/4 + realItemSize; i++){
			arr[i] = 1;
			pos[boolNum++] = i;
		}
		for(int first = height-2; 0 <=  first; first--){
			for(int j = (int) Math.pow(2, first); j < (int) Math.pow(2, first+1); j++)
				arr[j] = arr[j*2] + arr[j*2 + 1];
		}
	}
	public static void deleteItem(int index){
		while(true){
			arr[index] -= 1;
			if(index == 1)
				break;
			index = (int) Math.ceil(index/2);
		}
	}
	public static void insertItem(int index){
		while(true){
			arr[index] += 1;
			if(index == 1)
				break;
			index = (int) Math.ceil(index/2);
		}
	}
	public static int getFrontNum(int index){
		int sum = 0;
		while(true){
			if(index%2 == 1)//Ȧ���̸�
				sum += arr[index-1];//�ٷ� �տ� ��Ī�Ǵ¼��� ����
			if(index == 1)
				break;
			index = (int) Math.ceil(index/2);
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			setAllTree();
			initBook(sc.nextInt());
			int getNum = sc.nextInt();
			int insertIndex = allArrSize*3/4-1;
			for(int i = 0; i <getNum; i++){
				int boolNum = sc.nextInt();
				int bookIndex = pos[boolNum];
				System.out.print(getFrontNum(bookIndex)+" ");
				deleteItem(bookIndex);
				insertItem(insertIndex);
				pos[boolNum] = insertIndex;
				insertIndex--;
			}
			System.out.println();
		}
	}
}