//���� ��ó : https://www.acmicpc.net/problem/1753
//���� : �ִܰ��1753
//���ͽ�Ʈ��, �켱����ť, BFS

package ����.�׷���;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class �����ִܰ��5719 {
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
		public Vertex dp[];//���������� �� ���������� �ִܰ�� ��
		public int history[];//�湮��� (->�ߺ�����)
		public boolean firstShortPath[][]; // ��1���ִܰ�� �������(->���� �ִܰ�ο��� ���ܵ�)
		public String path;
		public int vSize = 0;
		public int start = -1;
		public int arrive = -1;
		public ArrayList<QuePath> lineList[];//��ο���  ����Ʈ�� �ε���:����, ����Ʈ�� �� :����
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
			
			//������ġ������ �̾�����ε��� �߰�
			PriorityQueue<QuePath> searchQue = new PriorityQueue<QuePath>();
			searchQue.add(new QuePath(-1,start,0,start+""));
			dp[start].weight = 0;
			//�̾��� ��ε��� �ּҺ�������ϸ鼭 ������������ �ִܰ�θ� dp�� �߰� 
			while(true){
				if(searchQue.size() == 0)
					break;
				//������ġ������ �̾�����ε��� �߰�
				int shortStart = searchQue.peek().arrive;
				int prevStart = searchQue.peek().start;
				int basicWeight = searchQue.peek().weight;
				String path = searchQue.peek().path;
				searchQue.remove();
				
				//�湮���� ���� �����̸� �ּҰ� ����, �湮���
				if(basicWeight <= dp[shortStart].weight){
					dp[shortStart].preVertex.add(prevStart);
					dp[shortStart].weight = basicWeight;
					history[shortStart] = 1;
				}
				this.path = path;
				
				//�������� ������ ���ο��ε��� ť�� ����
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
			//���� ������ ����
			sp.setStart(sc.nextInt());
			sp.setArrive(sc.nextInt());
			for(int i = 0; i < e; i ++)//��μ���
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
