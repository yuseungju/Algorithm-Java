package 백준.미해결;

import java.util.Scanner;

public class M2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int allNum = sc.nextInt();
		int personNum = sc.nextInt();
		allNum%= personNum;
		if(allNum == 0){
			System.out.println(0);
			return;
		}
		
		//각 소시지를 사람 수만큼 조각으로 분할 (ex: 3개 4명 -> 12조각)하여  조각을 묶어서 할당
		double allCount = allNum*personNum;//모든소시지의 모든 조각수
		double allocCount = allCount/personNum;//한사람에게 할당되는 조각수
		int currentIt = 0;//할당되고 있는 소시지의 인덱스
		double currentPiece = personNum;//남은 소시지 조각의 개수
		int result = 0;
		while(true){
			//한사람에게 할당 해줄때 의 개수
			currentPiece -= allocCount;//현재 소시지의 조각을 할당한만큼 제외
			if(0 != currentPiece)//소시지하나를 완벽하게 할당하지 못했으면 (중간을 나눔 칼질)
				result++;
			if(currentIt == allNum-1 && currentPiece == 0)//할당될 마지막 소시지가 끝났으면 
				break;
			if(currentPiece < allocCount){//현재 소시지에서 남은 조각이 한사람에게 할당될 양이 되지않으면 
				currentPiece += personNum;//다음 소시지의 조각들을 합침
				currentIt++;//다음 소시지를 가리킴
			}
		}
		System.out.println(result);
	}
}
