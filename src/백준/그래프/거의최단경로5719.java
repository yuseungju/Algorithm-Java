//문제 출처 : https://www.acmicpc.net/problem/1753
//제목 : 최단경로1753
//다익스트라, 우선순위큐, BFS

package 백준.그래프;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 거의최단경로5719 {
	static class ShortestPath{
		public class QuePath implements Comparable<QuePath>{
			int weight;
			int arrive;
			int start;
			String path;
			public QuePath(int start, int arrive,int weight, String path) {
				super();
				this.start = start;
				this.weight = weight;
				this.arrive = arrive;
				this.path = path;
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
		public class Vertex{
			ArrayList<Integer> preVertex = new ArrayList<Integer>();
			int weight;
			public Vertex(int weight) {
				this.weight = weight;
			}
			@Override
			public String toString() {
				return preVertex + "("+weight+")";
			}
			
		}
		public Vertex dp[];//시작점에서 각 정점까지의 최단경로 값
		public int history[];//방문기록 (->중복제거)
		public boolean firstShortPath[][]; // 제1의최단경로 정점기록(->거의 최단경로에서 제외됨)
		public String path;
		public int vSize = 0;
		public int start = -1;
		public int arrive = -1;
		public ArrayList<QuePath> lineList[];//경로연결  리스트의 인덱스:시작, 리스트의 값 :도착
		ShortestPath(int vSize){
			this.vSize =  vSize;
			lineList = new ArrayList[vSize];
			firstShortPath =  new boolean[vSize][vSize];
			history = new int[vSize];
			for(int i = 0; i < lineList.length; i++)
				lineList[i] = new ArrayList<QuePath>();
		}
		public void setPath(int start, int end, int weight){
			lineList[start].add(new QuePath(start,end,weight,""));
		}
		public void processMinPath(){
			history = new int[vSize];
			dp = new Vertex[vSize];
			for(int i = 0; i < lineList.length; i++)
				dp[i] = new Vertex(Integer.MAX_VALUE);
			
			//시작위치에서의 이어진경로들을 추가
			PriorityQueue<QuePath> searchQue = new PriorityQueue<QuePath>();
			searchQue.add(new QuePath(-1,start,0,start+""));
			dp[start].weight = 0;
			//이어진 경로들의 최소비용을비교하면서 각정점까지의 최단경로를 dp에 추가 
			while(true){
				if(searchQue.size() == 0)
					break;
				//시작위치에서의 이어진경로들을 추가
				int shortStart = searchQue.peek().arrive;
				int prevStart = searchQue.peek().start;
				int basicWeight = searchQue.peek().weight;
				String path = searchQue.peek().path;
				searchQue.remove();
				
				//방문하지 않은 정점이면 최소값 설정, 방문기록
				if(basicWeight <= dp[shortStart].weight){
					dp[shortStart].preVertex.add(prevStart);
					dp[shortStart].weight = basicWeight;
					history[shortStart] = 1;
				}
				this.path = path;
				
				//정점에서 나오는 새로운경로들을 큐에 삽입
				int shortArrive;
				int newWeight;
				for(int i = 0; i < lineList[shortStart].size(); i++){
					if(history[lineList[shortStart].get(i).arrive] == 0){
						shortArrive = lineList[shortStart].get(i).arrive;
						if(!firstShortPath[shortStart][shortArrive]){
							newWeight = basicWeight + lineList[shortStart].get(i).weight;
							searchQue.add(new QuePath(shortStart, shortArrive,newWeight, path+" " + shortArrive));
						}
					}
				}
			}
			dp[start].preVertex = new ArrayList<Integer>();
		}
		public void setStart(int start) {
			this.start = start;
		}
		public void setArrive(int arrive) {
			this.arrive = arrive;
		}
		public void exceptSolutionHistory(){
			Queue<Integer> shortStart = new LinkedList();
			Queue<Integer> shortArrive = new LinkedList();
			shortStart.add(arrive);
			shortArrive.add(-1);
			while(!shortStart.isEmpty()){
				int st = shortStart.peek();
				int ar = shortArrive.peek();
				shortStart.remove();
				shortArrive.remove();
				ArrayList<Integer> prev = dp[st].preVertex;
				for(int a=0; a< prev.size(); a++){
					shortArrive.add(st);
					shortStart.add(prev.get(a));
					firstShortPath[prev.get(a)][st] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int v = sc.nextInt();
			int e = sc.nextInt();
			if(v==0&&e==0)
				break;
			ShortestPath sp = new ShortestPath(v);
			//시작 도착점 설정
			sp.setStart(sc.nextInt());
			sp.setArrive(sc.nextInt());
			for(int i = 0; i < e; i ++)//경로설정
				sp.setPath( sc.nextInt(),  sc.nextInt(),  sc.nextInt());
			sp.processMinPath();
			/*for(int a=0; a<uda.vSize; a++){
				System.out.println(uda.dp[a].weight);
				System.out.println(uda.dp[a].preVertex);
			}*/
			sp.exceptSolutionHistory();
			sp.processMinPath();
			if(sp.dp[sp.arrive].weight == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(sp.dp[sp.arrive].weight);
			/*
			for(int a=0; a<uda.vSize; a++){
				System.out.println(uda.dp[a].weight);
				System.out.println(uda.dp[a].preVertex);
			}*/
		}
	}
}
