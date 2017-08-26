package usefulAlgorithm.dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimAlgorithm {
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
				return start +"-"+ end;
			}
		}
		public long minPathValue = 0;
		public String pathStr ="";
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
				pathStr +=(min.start + "-" + min.end + " (+"+min.weight + ")\n");
			}
		}
		public String getMinPathInfor(){
			return this.pathStr;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������: 6  /������: 9");
		UserPrimAlgorithm upa = new UserPrimAlgorithm(6);
		//��μ���
		upa.setPath(1,2,5);
		upa.setPath(1,3,4);
		upa.setPath(2,3,2);
		upa.setPath(2,4,7);
		upa.setPath(3,4,6);
		upa.setPath(3,5,11);
		upa.setPath(4,5,3);
		upa.setPath(4,6,8);
		upa.setPath(5,6,8);
		upa.processMinPath();
		System.out.println(upa.getMinPathInfor());
		System.out.print("�ּҺ��: ");
		System.out.println(upa.minPathValue);
		
	}
}
