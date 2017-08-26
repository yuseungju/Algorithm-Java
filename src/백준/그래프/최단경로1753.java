//���� ��ó : https://www.acmicpc.net/problem/1753
//���� : �ִܰ��1753
//���ͽ�Ʈ��, �켱����ť, BFS

package ����.�׷���;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class �ִܰ��1753 {
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
		public ArrayList<QuePath> lineList[];//��ο���  ����Ʈ�� �ε���:����, ����Ʈ�� �� :����
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
			
			//������ġ������ �̾�����ε��� �߰�
			searchQue.add(new QuePath(start,0));
			dp[start] = 0;
			
			while(true){
				if(searchQue.size() == 0)
					break;
				//������ġ������ �̾�����ε��� �߰�
				int shortStart = searchQue.peek().arrive;
				int basicWeight = searchQue.peek().weight;
				
				searchQue.remove();
				//������ ��θ� Ž���غô� �����̸� Ž��x
				if(history[shortStart]  != 0)
					continue;
				
				//�湮���� ���� �����̸� �ּҰ� ����, �湮���
				dp[shortStart] = basicWeight;
				history[shortStart] = 1;
				
				//�������� ������ ���ο��ε��� ť�� ����
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
