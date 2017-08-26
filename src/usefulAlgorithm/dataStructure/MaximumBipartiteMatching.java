//이분매칭
package usefulAlgorithm.dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumBipartiteMatching {
	public static class UserMaximumBipartiteMatching{
		public ArrayList<Integer> possibleFromLtoR[];//연결가능한 경로: R->L 경로
		public int connectedLOfR[];//R에 매칭된  L의 위치(연결된 상태)
		public int leftOverlapCheck[];//좌측그룹이 우측그룹에 매칭가능한지 체크했던 기록
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
			possibleFromLtoR = new ArrayList[leftSize];//좌측->우측 간에  매칭가능 경로
			for(int i =0; i< possibleFromLtoR.length; i++)
				possibleFromLtoR[i] =  new ArrayList<Integer>();
			connectedLOfR = new int[rightSize];//우측과 연결된 좌측그룹 요소의 인덱스
			//연결된 상태 초기화
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
				if(getPossibleArrive(i))//i번째 소 축사배정
					maxMatchingNum++;//배정가능하면 배정축사수 +1
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
			for(int i=0; i< possibleFromLtoR[left].size();i++ ){//좌측요소하나에 대해 연결가능한 우측그룹수만큼
				right = possibleFromLtoR[left].get(i);
				if(connectedLOfR[right] == -1){//그냥 연결 가능하면 연결 
					connectedLOfR[right] = left;
					return true;
				}else if(getPossibleArrive(connectedLOfR[right])){//이전 연결을 수정한뒤 연결가능하면 연결
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



