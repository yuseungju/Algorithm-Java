//문제 출처 : https://www.acmicpc.net/problem/1022
//제목 : 소용돌이예쁘게출력하기1022

package 백준.규칙;

import java.util.Scanner;

public class 소용돌이예쁘게출력하기1022 {
	public static void main(String[] args) {
		//출력할 좌표 범위 입력
		Scanner sc = new Scanner(System.in);
		int y1 =  sc.nextInt(); 
		int x1 =  sc.nextInt(); 
		int y2 =  sc.nextInt(); 
		int x2 =  sc.nextInt(); 
		
		//판의 사이즈를 구하기위해 가장 큰 좌표를 구함
		int max;
		max = Math.max(Math.abs(y1), Math.abs(y2));
		max = Math.max(max, Math.abs(x1));
		max = Math.max(max, Math.abs(x2));
		
		//좌표판 생성
		int width = max*2+1;
		int height = max*2+1;
		y1 += height/2;
		x1 += width/2;
		y2 += height/2;
		x2 += width/2;
		int boardPart[][] = new int[y2 - y1 + 1][x2 - x1 + 1];
		
		//좌표판을 규칙에 맞게 채움
		//규칙: 오,위,왼,아,오  1,1,2,2,2      1,3,4,4,4    1,5,6,6,6   
		int currentX = width/2;
		int currentY = height/2;
		int increase[] = {1,1,2,2,2};
		if(currentY <= y2 && y1 <= currentY && currentX <= x2 && x1 <= currentX)
			boardPart[currentY-y1][currentX-x1] = 1;
		
		//전체보드를 계산해가면서, 정답범위인 경우 정답배열을 채움
		int place = 0;
		for(int circleIt = 2; circleIt <= height*width;){
			//한바퀴(다섯방향)를 채움
			for(int pos = 0;  pos < 5;  pos++){
				//한방향을 채움
				for(int i = 0; i < increase[pos]; i++){
					if(pos == 0)//방향이 오른쪽이면
						currentX++;
					else if(pos == 1)//방향이 위쪽이면
						currentY--;
					else if(pos == 2)//방향이 왼이면
						currentX--;
					else if(pos == 3)//방향이 아래쪽이면
						currentY++;
					else if(pos == 4)//방향이 오른쪽이면
						currentX++;
					//정답범위이면 숫자보관
					if(currentY <= y2 && y1 <= currentY && currentX <= x2 && x1 <= currentX){
						boardPart[currentY-y1][currentX-x1] = circleIt;
						if(place < (int) Math.log10(circleIt)+1)
							place = (int) Math.log10(circleIt)+1;
					}
					circleIt++;
				}
			}
			//방향마다의 증가단위를 2씩올림
			increase[1] += 2;
			increase[2] += 2;
			increase[3] += 2;
			increase[4] += 2;
		}
		
		//정답 배열 출력
		for(int  i = 0; i < boardPart.length; i++){
			for(int j = 0; j < boardPart[i].length; j++){
				for(int p = (int) Math.log10(boardPart[i][j])+1; p < place; p++)
					System.out.print(" ");
				System.out.print(boardPart[i][j]+" ");
			}
			System.out.println();
		}
	}
}
