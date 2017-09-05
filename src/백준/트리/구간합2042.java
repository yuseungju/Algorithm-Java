//문제 출처 : https://www.acmicpc.net/problem/2042
//제목 : 구간합2042
//세그먼트 트리

package 백준.트리;

import java.util.Scanner;

public class 구간합2042 {
	public static class UserSegmentTreeAlgorithm {
		public long arr[];
		public int height;
		public int allArrSize;

		UserSegmentTreeAlgorithm(int itemSize) {
			height = 0;
			for (height = 0; Math.pow(2, height) < itemSize * 2; height++);
			allArrSize = (int) Math.pow(2, height);
			arr = new long[allArrSize];
		}

		public void deleteItem(int index) {
			index += allArrSize / 2;
			long deleteValue = arr[index];
			while (true) {
				arr[index] -= deleteValue;
				if (index == 1)
					break;
				index = (int) Math.ceil(index / 2);
			}
		}
		public long getValueOfIndex(int index){
			return arr[index+allArrSize/2];
		}
		public void insertItem(int index, int value) {
			index += allArrSize / 2;
			long basicValue = arr[index];
			while (true) {
				arr[index] += (value - basicValue);
				if (index == 1)
					break;
				index = (int) Math.ceil(index / 2);
			}
		}
		public long getFrontSum(int index) {
			index += allArrSize / 2;
			long sum = 0;
			while (true) {
				if (index % 2 == 1)// 홀수이면
					sum += arr[index - 1];// 바로 앞에 매칭되는수를 더함
				if (index == 1)
					break;
				index = (int) Math.ceil(index / 2);
			}
			return sum;
		}

		public void printTree() {
			for (int i = 0; i < height; i++) {
				for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numSize = sc.nextInt();//수의 개수
		int modifyNum =  sc.nextInt();//수의 변경 개수
		int rangeSumNum =  sc.nextInt();//수의 변경 개수
		UserSegmentTreeAlgorithm usta = new UserSegmentTreeAlgorithm(1000001);
		for(int i = 0; i < numSize; i++)
			usta.insertItem(i, sc.nextInt());
		for(int i = 0; i < modifyNum + rangeSumNum; i++){
			int kind= sc.nextInt();
			if(kind == 1){//첫번빼의 수를 두번쨰로 바꿈
				int index =  sc.nextInt()-1;
				usta.deleteItem(index);
				usta.insertItem(index, sc.nextInt());
			}else if(kind == 2){//첫번쨰에서 두번째까지의 구간합을 구함
				int firstIndex = sc.nextInt()-1;
				int endIndex = sc.nextInt()-1;
				System.out.println(
						(long)usta.getFrontSum(endIndex) + (long)usta.getValueOfIndex(endIndex) -
						(long)usta.getFrontSum(firstIndex)
				);
			}
			//usta.printTree();
		}
	}
}