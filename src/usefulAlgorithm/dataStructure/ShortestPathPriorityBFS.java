package usefulAlgorithm.dataStructure;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathPriorityBFS {
	static class ShortestPath{
		public class QuePath implements Comparable<QuePath>{
			int weight;
			int arrive;
			String path;
			public QuePath(int arrive,int weight, String path) {
				super();
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
		public int shortestPathValue;
		public String shortestPathStr;
		public int vSize = 0;
		public int start = -1;
		public int arrive = -1;
		public ArrayList<QuePath> lineList[];//��ο���  ����Ʈ�� �ε���:����, ����Ʈ�� �� :����
		ShortestPath(int vSize){
			this.vSize =  vSize;
			lineList = new ArrayList[vSize+1];
			shortestPathValue = Integer.MAX_VALUE;
			shortestPathStr ="";
			for(int i = 0; i < lineList.length; i++){
				lineList[i] = new ArrayList<QuePath>();
			}
		}
		public void setPath(int start, int end, int weight){
			lineList[start].add(new QuePath(end,weight,""));
		}
		public void processMinPath(){
			PriorityQueue<QuePath> searchQue = new PriorityQueue<QuePath>();
			int history[] = new int[vSize+1];
			
			//������ġ������ �̾�����ε��� �߰�
			searchQue.add(new QuePath(start,0,""+start));
			
			while(!searchQue.isEmpty()){
				//������ġ������ �̾�����ε��� �߰�
				int shortStart = searchQue.peek().arrive;
				int basicWeight = searchQue.peek().weight;
				String basicPath = searchQue.peek().path;
				searchQue.remove();
				
				//������ ��θ� Ž���غô� �����̸� Ž��x
				if(shortStart == this.arrive){
					shortestPathValue = basicWeight;
					shortestPathStr = basicPath;
					break;
				}
				
				//�湮���� ���� �����̸� �ּҰ� ����, �湮���
				if(history[shortStart] != 0)
					continue;
				history[shortStart] = 1;
				
				//�������� ������ ���ο��ε��� ť�� ����
				int shortArrive;
				int newWeight;
				String newPath="";
				for(int i = 0; i < lineList[shortStart].size(); i++){
					if(history[lineList[shortStart].get(i).arrive] == 0){
						shortArrive = lineList[shortStart].get(i).arrive;
						newWeight = basicWeight + lineList[shortStart].get(i).weight;
						newPath = basicPath + "->"+ shortArrive;
						searchQue.add(new QuePath(shortArrive,newWeight, newPath));
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
		int vSize = 5;
		int start = 1;
		int arrive = 4;
		ShortestPath sp = new ShortestPath(vSize);
		sp.setStart(start);
		sp.setArrive(arrive);
		sp.setPath(5,1,1);
		sp.setPath(1,2,2);
		sp.setPath(1,3,3);
		sp.setPath(2,3,4);
		sp.setPath(2,4,5);
		sp.setPath(3,4,6);
		sp.processMinPath();

		System.out.println("�ּҰ��: "+ sp.shortestPathStr);
		System.out.println("�ּҺ��: " + sp.shortestPathValue);
	}
}
