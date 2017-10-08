package 백준.미해결;

import java.util.ArrayList;
import java.util.Scanner;

public class 마이다스Q지하철노선 {
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
		public ArrayList<Integer> lineList[];//경로연결  리스트의 인덱스:시작, 리스트의 값 :도착
		public int lineWeight[][];//경로에대한 비용
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
			//경로 연결 설정
			lineList[v1].add(v2);
			lineList[v2].add(v1);
			this.eSize++;
		}
		public void processMinPath(){
			int historyV[] = new int[vSize+1];
			int findV = 1;
			ArrayList<Line> currentLine = new ArrayList<Line>();
			for(int a = 0; a < vSize-1; a++){
				//경로 추가 업데이트
				int arrive = -1;
				for(int i =0 ; i <lineList[findV].size(); i++){
					arrive = lineList[findV].get(i);
					currentLine.add(new Line(findV, arrive, lineWeight[findV][arrive]));
				}
				//경로추가한 정점을 찾을 정점에서 제외
				historyV[findV] = 1;
				
				//최소경로 선택
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
		System.out.println("정점수: 6  /간선수: 9");
		UserPrimAlgorithm upa = new UserPrimAlgorithm(4);
		
		//경로설정
		upa.setPath(1,2,5);
		upa.setPath(1,2,3);
		upa.setPath(1,3,10);
		upa.setPath(1,4,1);
		upa.setPath(2,3,4);
		upa.setPath(3,4,2);
		upa.processMinPath();
		System.out.println(upa.getMinPathInfor());
		System.out.println(upa.minPathValue);
		
	}
}



