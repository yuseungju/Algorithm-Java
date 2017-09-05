package usefulAlgorithm.dataStructure;

import java.util.Scanner;

public class SegmentTreeAlgorithm {
	public static class UserSegmentTreeAlgorithm{
		public int arr[];
		public int height;
		public int allArrSize;
		public int pos[];
		UserSegmentTreeAlgorithm(int itemSize, int limitMaxValue){
			height = 0;
			pos = new int[limitMaxValue+1];
			for(height = 0; Math.pow(2,height) < itemSize*2; height++);
			allArrSize = (int) Math.pow(2,height) ; 
			arr = new int[allArrSize];
		}
		public void deleteItem(int index){
			pos[index] = 0;
			index += allArrSize/2;
			int deleteValue = arr[index];
			while(true){
				arr[index] -= deleteValue;
				if(index == 1)
					break;
				index = (int) Math.ceil(index/2);
			}
		}
		public void insertItem(int index, int value){
			pos[value] = index;
			index += allArrSize/2;
			int basicValue = arr[index];
			while(true){
				arr[index] += (value-basicValue);
				if(index == 1)
					break;
				index = (int) Math.ceil(index/2);
			}
		}
		public int getIndexOfValue(int item){
			return pos[item];
		}
		public int getValueOfIndex(int index){
			return arr[index+allArrSize/2];
		}
		public int getFrontSum(int index){
			index += allArrSize/2;
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
		public void printTree(){
			for(int i=0; i<height; i++){
				for(int j = (int) Math.pow(2,i); j < (int) Math.pow(2,i+1); j++){
					System.out.print(arr[j] +" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserSegmentTreeAlgorithm usta =  new UserSegmentTreeAlgorithm(7, 77);
		usta.insertItem(0, 11);
		usta.insertItem(1, 22);
		usta.insertItem(2, 33);
		usta.insertItem(3, 44);
		usta.insertItem(7, 77);
		usta.printTree();
		System.out.println("3��°�� �� :"+ usta.getValueOfIndex(3));
		System.out.println("������: 0~3 : " + (usta.getFrontSum(3) + usta.getValueOfIndex(3)));
		System.out.println("������: 0~2 : " + usta.getFrontSum(3) +"\n");
		
		System.out.println("3��° ������");
		usta.deleteItem(3); 
		usta.printTree();

		System.out.println("77�� ������");
		usta.deleteItem(usta.getIndexOfValue(77));
		usta.printTree();
	}
}
