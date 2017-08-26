package usefulAlgorithm.dataStructure;
import java.util.ArrayList;
import java.util.Scanner;

public class BellmanFordAlgorithm {
	static public class UserBellmanFormAlgorithm{
		public int vSize;
		public ArrayList<Integer> edge[];
		public int weightFromStart[];
		public int pathWeight[][];
		public int start;
		public UserBellmanFormAlgorithm(int start, int vSize) {
			super();
			this.start = start;
			this.vSize = vSize;
			this.edge = new ArrayList[vSize +1];	
			this.weightFromStart = new int[vSize +1];	
			this.pathWeight = new int[vSize +1][vSize +1];
			for(int i =0 ; i< vSize + 1; i++){
				weightFromStart[i] =  Integer.MAX_VALUE;
				if(i == start)
					weightFromStart[i] = 0;
				for(int j=0; j<vSize + 1; j++)
					pathWeight[i][j] = Integer.MAX_VALUE;
			}
			for(int i = 0; i < vSize + 1; i++)
				edge[i] = new ArrayList<Integer>();
		}
		//연결 설정
		public void setPath(int start, int end, int weight){
			if(weight < pathWeight[start][end]){//경로중복시 보다 적은 경로로 적용
				pathWeight[start][end] = weight;
				edge[start].add(end);
			}
		}
		//시작점에서 연결점까지의 최소비용을 구함
		public void processMinPathFromStart(){
			for (int n = 0; n < vSize + 1; n++) {
				for (int start = 0; start < vSize + 1; start++) {
					for (int j = 0; j <  edge[start].size(); j++) {
						int arrive =  edge[start].get(j);
						if((long)weightFromStart[start] +  pathWeight[start][arrive] < weightFromStart[arrive])
							weightFromStart[arrive] =  weightFromStart[start] +  pathWeight[start][arrive];
					}
				}
			}   
			for (int n = 0; n < vSize + 1; n++) {
				for (int start = 0; start < vSize + 1; start++) {
					for (int j = 0; j <  edge[start].size(); j++) {
						int arrive =  edge[start].get(j);
						if((long)weightFromStart[start] +  pathWeight[start][arrive] < weightFromStart[arrive])
							weightFromStart[arrive] =  Integer.MIN_VALUE;
					}
				}
			}   
		}
		public int getMinPathFromStart(int arrive){
			return weightFromStart[arrive];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vSize = 4;
		int start = 1;
		UserBellmanFormAlgorithm ubfa = new UserBellmanFormAlgorithm(start,vSize);
		ubfa.setPath(1, 2, 11);
		ubfa.setPath(1, 2, 10);
		ubfa.setPath(1, 4, 100);
		ubfa.setPath(4, 4, -1);
		ubfa.processMinPathFromStart();
		for(int i = 1; i < vSize+1; i++){
			System.out.print(start +"->" + i + ": ");
			if(ubfa.getMinPathFromStart(i) == Integer.MIN_VALUE) {
				System.out.println("시작점과의 사이클 형성   -무한");
			}else if(ubfa.getMinPathFromStart(i) == Integer.MAX_VALUE) {
				System.out.println("시작점과 거리연결");
			}else 
				System.out.println(ubfa.getMinPathFromStart(i));
		}
	}
}







