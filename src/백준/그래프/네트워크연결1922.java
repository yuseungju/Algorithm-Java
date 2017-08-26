//���� ��ó : https://www.acmicpc.net/problem/1922
//���� : ��Ʈ��ũ����1922
//���ͽ�Ʈ��, �켱����ť, BFS

package ����.�׷���;
import java.util.ArrayList;
import java.util.Scanner;

public class ��Ʈ��ũ����1922 {
	static class UserPrimAlgorithm{
		public class Line{
			Line(int start, int end, int weight){
				this.weight = weight;
				this.start = start;
				this.end = end;
			}
			public int start;
			public int end; 
			public int weight;
			public String toString() {
				return start +"->"+ end;
			}
		}
		public long minPathValue = 0;
		public int vSize;
		public int eSize = 0;
		public ArrayList<Integer> lineList[];//��ο���  ����Ʈ�� �ε���:����, ����Ʈ�� �� :����
		public int lineWeight[][];//��ο����� ���
		UserPrimAlgorithm(int vSize){
			this.vSize =  vSize;
			lineWeight = new int[vSize+1][vSize+1];
			lineList = new ArrayList[vSize+1];
			for(int i = 0; i < lineList.length; i++)
				lineList[i] = new ArrayList<Integer>();
		}
		public void setPath(int v1, int v2, int weight){
			lineWeight[v1][v2] = weight;
			lineWeight[v2][v1] = weight;
			//��� ���� ����
			lineList[v1].add(v2);
			lineList[v2].add(v1);
			this.eSize++;
		}
		public void processMinPath(){
			int historyV[] = new int[vSize+1];
			int findV = 1;
			ArrayList<Line> currentLine = new ArrayList<Line>();
			for(int a = 0; a < vSize-1; a++){
				//��� �߰� ������Ʈ
				int arrive = -1;
				for(int i =0 ; i <lineList[findV].size(); i++){
					arrive = lineList[findV].get(i);
					currentLine.add(new Line(findV, arrive, lineWeight[findV][arrive]));
				}
				//����߰��� ������ ã�� �������� ����
				historyV[findV] = 1;
				
				//�ּҰ�� ����
				Line min = new Line(-1,-1,Integer.MAX_VALUE);
				for(int i = 0; i < currentLine.size() ; i++){
					if(historyV[currentLine.get(i).end] != 0){
						currentLine.remove(i--);
						continue;
					}
					if(currentLine.get(i).weight < min.weight){
						min.weight = currentLine.get(i).weight;
						min.end = currentLine.get(i).end;
						min.start = currentLine.get(i).start;
					}
				}
				findV = min.end;
				minPathValue += min.weight;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserPrimAlgorithm upa = new UserPrimAlgorithm(sc.nextInt());
		int e =  sc.nextInt();
		//��μ���
		for(int a=0; a<e; a++)
			upa.setPath(sc.nextInt(), sc.nextInt(), sc.nextInt());
		//�ּҺ����
		upa.processMinPath();
		System.out.println(upa.minPathValue);
	}
}

