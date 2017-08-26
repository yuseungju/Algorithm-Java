//문제 출처 : https://www.acmicpc.net/problem/1753
//제목 : 최단경로1753
//다익스트라, 우선순위큐, BFS

package 백준.그래프;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최단경로1753 {
	static class ShortestPath{
		public class QuePath implements Comparable<QuePath>{
			int weight;
			int arrive;
			public QuePath(int arrive,int weight) {
				super();
				this.weight = weight;
				this.arrive = arrive;
			}
			@Override
		    public int compareTo(QuePath target) {
		        if (this.weight > target.weight) {
		            return 1;
		        } else if (this.weight < target.weight) {
		            return -1;
		        }
		        return 0;
		    }
		}
		public int dp[] = new int[20001];
		public int vSize = 0;
		public int start = -1;
		public int arrive = -10;
		public ArrayList<QuePath> lineList[];//경로연결  리스트의 인덱스:시작, 리스트의 값 :도착
		ShortestPath(int vSize){
			this.vSize =  vSize;
			lineList = new ArrayList[vSize+1];
			for(int i = 0; i < lineList.length; i++){
				lineList[i] = new ArrayList<QuePath>();
				dp[i] = -1;
			}
		}
		public void setPath(int start, int end, int weight){
			lineList[start].add(new QuePath(end,weight));
		}
		public void processMinPath(){
			PriorityQueue<QuePath> searchQue = new PriorityQueue<QuePath>();
			int history[] = new int[vSize+1];
			
			//시작위치에서의 이어진경로들을 추가
			searchQue.add(new QuePath(start,0));
			dp[start] = 0;
			
			while(true){
				if(searchQue.size() == 0)
					break;
				//시작위치에서의 이어진경로들을 추가
				int shortStart = searchQue.peek().arrive;
				int basicWeight = searchQue.peek().weight;
				
				searchQue.remove();
				//이전에 경로를 탐색해봤던 정점이면 탐색x
				if(history[shortStart]  != 0)
					continue;
				
				//방문하지 않은 정점이면 최소값 설정, 방문기록
				dp[shortStart] = basicWeight;
				history[shortStart] = 1;
				
				//정점에서 나오는 새로운경로들을 큐에 삽입
				int shortArrive;
				int newWeight;
				for(int i = 0; i < lineList[shortStart].size(); i++){
					if(history[lineList[shortStart].get(i).arrive] == 0){
						shortArrive = lineList[shortStart].get(i).arrive;
						newWeight = basicWeight + lineList[shortStart].get(i).weight;
						searchQue.add(new QuePath(shortArrive,newWeight));
					}
				}
			}
		}
		public void setStart(int start) {
			this.start = start;
		}
		public void setArrive(int arrive) {
			this.arrive = arrive;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShortestPath sp = new ShortestPath(sc.nextInt());
		int e = sc.nextInt();
		sp.setStart(sc.nextInt());
		for(int i = 0; i < e; i ++)
			sp.setPath( sc.nextInt(),  sc.nextInt(),  sc.nextInt());
		sp.processMinPath();
		for(int a=1; a<=sp.vSize; a++){
			if(sp.dp[a] == -1)
				System.out.println("INF");
			else
				System.out.println(sp.dp[a]);
		}
	}
}
