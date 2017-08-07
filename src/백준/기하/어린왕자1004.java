//문제 출처 : https://www.acmicpc.net/problem/1004
//제목 : 어린왕자1004

package 백준.기하;
import java.io.IOException;
import java.util.Scanner;

public class 어린왕자1004 {
public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		int[] result = new int[t];
		for(int a=0; a<t; a++){
			int x1 = Integer.parseInt(sc.next());
			int y1 = Integer.parseInt(sc.next());
			int x2 = Integer.parseInt(sc.next());
			int y2 = Integer.parseInt(sc.next());
			int n = Integer.parseInt(sc.next());
			int[] circleX = new int[n];
			int[] circleY = new int[n];
			int[] circleR = new int[n];
			
			for(int b=0; b<n; b++){
				circleX[b] = Integer.parseInt(sc.next());
				circleY[b] = Integer.parseInt(sc.next());
				circleR[b] = Integer.parseInt(sc.next());
			}
			result[a] = 0;
			for(int b=0; b<n; b++){
				if(Math.pow((circleX[b] - x1),2)+ Math.pow((circleY[b] - y1),2) <  Math.pow(circleR[b],2)  &&  
						Math.pow((circleX[b] - x2),2)+ Math.pow((circleY[b] - y2),2) >  Math.pow(circleR[b],2)){
					result[a]++;
				}else if(Math.pow((circleX[b] - x1),2)+ Math.pow((circleY[b] - y1),2) >  Math.pow(circleR[b],2)  &&  
						Math.pow((circleX[b] - x2),2)+ Math.pow((circleY[b] - y2),2) <  Math.pow(circleR[b],2)){
					result[a]++;
				}
			}
			
		}
		for(int a=0; a<t; a++){
			System.out.println(result[a]);
		}
	}
}
