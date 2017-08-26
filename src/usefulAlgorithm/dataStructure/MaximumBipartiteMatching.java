//�̺и�Ī
package usefulAlgorithm.dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumBipartiteMatching {
	public static class UserMaximumBipartiteMatching{
		public ArrayList<Integer> possibleFromLtoR[];//���ᰡ���� ���: R->L ���
		public int connectedLOfR[];//R�� ��Ī��  L�� ��ġ(����� ����)
		public int leftOverlapCheck[];//�����׷��� �����׷쿡 ��Ī�������� üũ�ߴ� ���
		public int leftGroup[];
		public int rightGroup[];
		public int leftSize;
		public int rightSize;
		public int maxMatchingNum = 0;
		public UserMaximumBipartiteMatching(int leftGroup[], int rightGroup[]) {
			this.leftSize = leftGroup.length;
			this.rightSize =  rightGroup.length;
			this.leftGroup = leftGroup;
			this.rightGroup = rightGroup;
			possibleFromLtoR = new ArrayList[leftSize];//����->���� ����  ��Ī���� ���
			for(int i =0; i< possibleFromLtoR.length; i++)
				possibleFromLtoR[i] =  new ArrayList<Integer>();
			connectedLOfR = new int[rightSize];//������ ����� �����׷� ����� �ε���
			//����� ���� �ʱ�ȭ
			for(int j = 0; j < connectedLOfR.length; j++)
				connectedLOfR[j] = -1;
		}
		public void setPossibleIndexPath(int l, int r){
			possibleFromLtoR[l].add(r);
		}
		public void processMatching() {
			maxMatchingNum = 0;
			for(int i = 0; i < leftSize; i++){
				leftOverlapCheck =  new int[leftSize];
				if(getPossibleArrive(i))//i��° �� ������
					maxMatchingNum++;//���������ϸ� �������� +1
			}
		}
		public void printMatchingResult(){
			for(int i = 0; i < connectedLOfR.length; i++){
				if(connectedLOfR[i] != -1)
					System.out.println(leftGroup[connectedLOfR[i]] +"(it:" + connectedLOfR[i] + ") - "+ rightGroup[i] +"(it:" + i + ")");
			}
		}
		public boolean getPossibleArrive(int left){
			if(leftOverlapCheck[left]  == 1)
				return false;
			leftOverlapCheck[left] = 1; 
			int right;
			for(int i=0; i< possibleFromLtoR[left].size();i++ ){//��������ϳ��� ���� ���ᰡ���� �����׷����ŭ
				right = possibleFromLtoR[left].get(i);
				if(connectedLOfR[right] == -1){//�׳� ���� �����ϸ� ���� 
					connectedLOfR[right] = left;
					return true;
				}else if(getPossibleArrive(connectedLOfR[right])){//���� ������ �����ѵ� ���ᰡ���ϸ� ����
					connectedLOfR[right] = left;
					return true;
				}
			}
			return false;
		}
		public int getMaxMatchingNum() {
			return maxMatchingNum;
		}
	}
	public static void main(String[] args) {
		int left[] = {1,3,5,7,9,11,13,15,17,19};
		int right[] = {2,4,6,8,10,12,14,16,18,20,22,24,26};
		UserMaximumBipartiteMatching umbm = new UserMaximumBipartiteMatching(left,right);
		umbm.setPossibleIndexPath(0,0);
		umbm.setPossibleIndexPath(0,1);
		umbm.setPossibleIndexPath(0,2);
		umbm.setPossibleIndexPath(1,0);
		umbm.setPossibleIndexPath(1,1);
		umbm.setPossibleIndexPath(1,2);
		umbm.setPossibleIndexPath(1,3);
		umbm.setPossibleIndexPath(6,4);
		umbm.setPossibleIndexPath(6,5);
		umbm.processMatching();
		umbm.printMatchingResult();
	}
}



