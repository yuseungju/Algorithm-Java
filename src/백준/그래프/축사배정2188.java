//문제 출처 : https://www.acmicpc.net/problem/2188
//제목 : 축사배정2188
//이분매칭, 네트워크플로우, 최대유량

package 백준.그래프;
import java.util.ArrayList;
import java.util.Scanner;

public class 축사배정2188 {
	public static ArrayList<Integer> connction[];
	public static int startOfArrive[];
	public static int cowSize;
	public static int cowshedSize;
	public static int overlapCheck[] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cowSize = sc.nextInt()+1;//소 개수
		cowshedSize =  sc.nextInt()+1;//축사 개수
		connction = new ArrayList[cowSize];//인덱스:소의 번호 , 값: 가능한 축사번호
		startOfArrive = new int[cowshedSize];//축사를 차지하는 소의 번호
		
		for(int j = 1; j < startOfArrive.length; j++)
			startOfArrive[j] = -1;
		
		//소마다 배정될수 있는 축사정보를 저장
		for(int i =1; i<connction.length; i++){
			connction[i] =  new ArrayList<Integer>();
			int cowshedSizeOfCow = sc.nextInt();
			for(int j = 0; j < cowshedSizeOfCow; j++)
				connction[i].add(sc.nextInt());
		}
		
		int maxMatching = 0;
		for(int i = 1; i < cowSize; i++){
			overlapCheck =  new int[cowSize];
			//System.out.println(i+"번쨰 소가 들어갈 축사설정*************");
			if(getPossibleArrive(i))//i번째 소 축사배정
				maxMatching++;//배정가능하면 배정축사수 +1
		}
		System.out.println(maxMatching);
	}
	public static boolean getPossibleArrive(int start){
		if(overlapCheck[start]  == 1)//연결구조 재배치중 반복 제거
			return false;
		overlapCheck[start] = 1; 
		int arrive;//소를 연결할 축사번호
		for(int i=0; i< connction[start].size();i++ ){//소가 연결가능한 축사만큼
			arrive = connction[start].get(i);
			if(startOfArrive[arrive] == -1){//그냥 연결 가능하면 연결 
				startOfArrive[arrive] = start;
				//System.out.println(start + "->" + arrive);
				return true;
			}else if(getPossibleArrive(startOfArrive[arrive])){//이전 연결을 수정한뒤 연결가능하면 연결
				startOfArrive[arrive] = start;
				//System.out.println(start + "->" + arrive);
				return true;
			}
		}
		return false;
	}
}
