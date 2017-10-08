//문제 출처 : https://www.acmicpc.net/problem/2580
//제목 : 스도쿠2580

package 백준.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class 스도쿠2580 {
	public static int board[][];
	public static int horizental[][];
	public static int vretical[][];
	public static int square[][][];
	public static ArrayList<Integer> listX = new ArrayList<Integer>();
	public static ArrayList<Integer> listY = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[9][9];//9*9 숫자 보드 
		horizental = new int[9][10];//[가로줄][숫자]
		vretical = new int[9][10];//[세로줄][숫자]
		square = new int[3][3][10];//[세로줄][숫자]
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = sc.nextInt();
				horizental[i][board[i][j]] = 1;
				vretical[j][board[i][j]] = 1;
				square[i/3][j/3][board[i][j]] = 1;
				if(board[i][j] == 0){
					listX.add(j);
					listY.add(i);
				}
			}
		}
		dfs(0);
		printArr(board);
	}
	public static void printArr(int arr[][]){
		for(int i = 0; i < arr.length; i++){
			for(int  j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		System.out.println();
	}
	public static boolean dfs(int it){
		if(listX.size() == it)
			return true;
		int setX = listX.get(it);
		int setY = listY.get(it);
		for(int i = 0; i <= 9; i++){
			if(addNumber(setX, setY ,i)){
				//System.out.println(setX +","+ setY +":"+ i +"->");
				//printArr(board);
				if(dfs(it + 1))
					return true;
				removeNumber(setX, setY ,i);
				//printArr(board);
				//System.out.println("<-"+setX +","+ setY);
			}
		}
		return false;
	}
	public static boolean addNumber(int x, int y, int number){
		if(horizental[y][number] == 1 || vretical[x][number] == 1 || square[y/3][x/3][number] == 1)
			return false;
		horizental[y][number] = 1;
		vretical[x][number] = 1;
		square[y/3][x/3][number] = 1;
		board[y][x] = number;
		return true;
	}	
	public static void removeNumber( int x, int y, int number){
		horizental[y][number] = 0;
		vretical[x][number] = 0;
		square[y/3][x/3][number] = 0;
		board[y][x] = 0;
	}
}
