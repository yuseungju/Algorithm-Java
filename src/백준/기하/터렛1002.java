//문제 출처 : https://www.acmicpc.net/problem/1002
//제목 : 터렛1002

package 백준.기하;
import java.io.IOException;
import java.util.Scanner;

public class 터렛1002 {
public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		int result[] = new int[t];
		for(int a=0; a<t; a++){
			int x1 =  Integer.parseInt(sc.next()) ;
			int y1 =  Integer.parseInt(sc.next()) ;
			int r1 =  Integer.parseInt(sc.next()) ;
			int x2 =  Integer.parseInt(sc.next()) ;
			int y2 =  Integer.parseInt(sc.next()) ;
			int r2 =  Integer.parseInt(sc.next()) ;
		
			double distance = Math.pow(x1- x2, 2) + Math.pow(y1-y2, 2);
			if(x1 ==  x2 && y1 == y2 && r1 == r2)
				result[a] = -1;
			else if(Math.pow(r1 - r2,2) < distance && distance < Math.pow(r1 + r2,2))
				result[a] = 2;
			else if(Math.pow(r1 - r2,2) == distance || Math.pow(r1 + r2,2) == distance)
				result[a] = 1;
			else
				result[a] = 0;
		}
		for(int a=0; a<t; a++)
			System.out.println(result[a]);
	}
}
