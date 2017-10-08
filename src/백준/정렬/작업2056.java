//문제 출처 : https://www.acmicpc.net/problem/2056
//제목 : 작업2056
//위상정렬

package 백준.정렬;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업2056 {
	static class Work{
		int time; 
		int vNum;
		public Work(int vNum , int time) {
			super();
			this.time = time;
			this.vNum = vNum;
		}
		@Override
		public String toString() {
			return  vNum+ "번 :" +time ;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int visitCount[] = new int[n];
		int time[] = new int[n];
		ArrayList<Integer> startPath[] = new ArrayList[n];
		for(int i= 0; i < n; i++)
			startPath[i] = new ArrayList<Integer>();
		for(int arrive = 0; arrive < n; arrive++){
			time[arrive] = sc.nextInt();//해당 정점에서의 소요 시간 설정
			int numPrev = sc.nextInt(); //기준지점에서의 시작정점 개수입력
			visitCount[arrive] = numPrev;//선행되어야 하는 경로의 수 설정
			//출발정점 -> 도착정점 경로 설정 
			for(int j =0; j <  numPrev; j++){
				int start = sc.nextInt()-1;//정점 인덱스 1->0 으로 맞춤 
				startPath[start].add(arrive);
				
			}
		}
		
		ArrayList<Work> possibleStart = new ArrayList<Work>();
		
		for(int i = 0; i < visitCount.length; i++){
			if(visitCount[i] == 0)
				possibleStart.add(new Work(i, time[i]));
		}
		int result = Integer.MIN_VALUE;
		while(!possibleStart.isEmpty()){
			//수행할 정점을 선택 (정점들중 최소시간을 가진값)
			int minIt = 0;
			int minValue = Integer.MAX_VALUE;
			for(int i = 0; i < possibleStart.size();i++){
				if(possibleStart.get(i).time < minValue){
					minValue = possibleStart.get(i).time;
					minIt = i;
				} 
			}
			int selectV = possibleStart.get(minIt).vNum;
			int selectTime = possibleStart.get(minIt).time;
			possibleStart.remove(minIt);//수행하면 제거 
			if(result < selectTime)
				result = selectTime;
			//System.out.println(selectV);
			//이동 가능한 정점의 선행 정점수를 1감소
			for(int i = 0; i < startPath[selectV].size(); i++){
				visitCount[startPath[selectV].get(i)] --;//선행정점수 감소
				if(visitCount[startPath[selectV].get(i)] == 0){//선행할 정점이 더이상없으면
					int nextV = startPath[selectV].get(i);
					int nextTime = selectTime + time[nextV];
					possibleStart.add(new Work(nextV, nextTime));//수행가능 출발점으로 추가
				}
			}
		}
		System.out.println(result);
	}
}
