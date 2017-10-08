//문제 출처 : https://www.acmicpc.net/problem/2931
//제목 : 가스관2931


package 백준.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 가스관2931 {
	static class Pos{
		int x;
		int y;
		char expression;
		boolean visit[] = new boolean[4];
		public int getExpression() {
			return expression;
		}
		public void setExpression(char expression) {
			this.expression = expression;
		}
		public boolean isVisit(char point){
			if(point == 'u')
				return visit[0];
			if(point == 'd')
				return visit[1];
			if(point == 'l')
				return visit[2];
			if(point == 'r')
				return visit[3];
			return false;
		}
		public void setVisit(char point) {
			if(point == 'u')
				this.visit[0] =  true;
			if(point == 'd')
				this.visit[1] =  true;
			if(point == 'l')
				this.visit[2] =  true;
			if(point == 'r')
				this.visit[3] =  true;
		}
		public void outVisit(char point) {
			if(point == 'u')
				this.visit[0] =  false;
			if(point == 'd')
				this.visit[1] =  false;
			if(point == 'l')
				this.visit[2] =  false;
			if(point == 'r')
				this.visit[3] =  false;
		}
		
		public Pos(int x, int y, char expression) {
			super();
			this.x = x;
			this.y = y;
			this.expression = expression;
			if(expression == '1' || expression == '2'
					||expression == '3'||expression == '4'
					||expression == '-' ||expression == '|')
				resutlDept += 2;
			else if(expression == '+')
				resutlDept += 4;
		}
		@Override
		public String toString() {
			return x + "," + y + "("+expression+")  visit:" + Arrays.toString(visit);
		}
		
	}
	public static Pos arr[][];
	public static int height;
	public static int width;
	public static int resutlDept = 0;
	public static void main(String[] args) {
		//입력 
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		arr = new Pos[height][width];
		int startX = -1;
		int startY = -1;
		int endX = -1;
		int endY = -1;
		for(int i = 0; i < height; i++){
			String str = sc.next();
			for(int  j = 0; j < width; j++){
				//가스관 정보입력
				arr[i][j] =  new Pos(j,i,str.charAt(j));
				if(arr[i][j].expression == 'M'){
					startX = j;
					startY = i;
				}
				if(arr[i][j].expression == 'Z'){
					endX = j;
					endY = i;
				}
			}
		}
		//추가할 가스관의 좌표와 종류를 구함
		Pos pos1 = new Pos(endX, endY, ' ');
		Pos pos2 = new Pos(startX, startY, ' ');
		if(existPos(endX -1 , endY)){
			pos1.x -=1;
		}else if(existPos(endX +1 , endY)){
			pos1.x +=1;
		}else if(existPos(endX , endY-1)){
			pos1.y -=1;
		}else if(existPos(endX , endY+1)){
			pos1.y +=1;
		}else{
			nearPos.add(arr[endY][endX]);
		}
		if(existPos(startX -1 , startY)){
			pos2.x -=1;
		}else if(existPos(startX +1 , startY)){
			pos2.x +=1;
		}else if(existPos(startX , startY-1)){
			pos2.y -=1;
		}else if(existPos(startX , startY+1)){
			pos2.y +=1;
		}else{
			nearPos.add(arr[startY][startX]);
		}
		nextPos(pos2.x, pos2.y);
		System.out.println(pos1.x + ","+ pos1.y + ","+ pos2.x +","+ pos2.y);
		nextPos(pos1.x, pos1.y);
		System.out.println(pos1.x + ","+ pos1.y + ","+ pos2.x +","+ pos2.y);
		if(result == null)
			result = new Pos((pos2.x + pos1.x)/2, (pos2.y + pos1.y)/2, ' ');
		
		if(0 <= result.x-1 && validate(arr[result.y][result.x-1].expression , '+', 'h') == 1)
			nearPos.add(arr[result.y][result.x-1]);
		if(result.x+1 < width && validate('+', arr[result.y][result.x+1].expression ,  'h') == 1)
			nearPos.add(arr[result.y][result.x+1]);
		if(result.y+1 < height &&validate('+', arr[result.y+1][result.x].expression ,  'v') == 1)
			nearPos.add(arr[result.y+1][result.x]);
		if(0 <= result.y-1 &&validate(arr[result.y-1][result.x].expression , '+', 'v') == 1)
			nearPos.add(arr[result.y-1][result.x]);
		
		boolean r = false;
		boolean l = false;
		boolean u = false;
		boolean d = false;
		for(int i = 0; i < nearPos.size(); i++){
			if(nearPos.get(i).x < result.x)
				l = true;
			else if(nearPos.get(i).x > result.x)
				r = true;
			else if(nearPos.get(i).y < result.y)
				u = true;
			else if(nearPos.get(i).y > result.y)
				d = true;
		}

		if(l && r && u && d)
			result.expression = '+';
		else if(l && r)
			result.expression = '-';
		else if(u && d)
			result.expression = '|';
		else if(d && r)
			result.expression = '1';
		else if(d && l)
			result.expression = '4';
		else if(u && r)
			result.expression = '2';
		else if(u && l)
			result.expression = '3';
		
		System.out.println((result.y+1) +" " + (result.x+1) + " " + result.expression);
	}
	public static Pos result;
	public static ArrayList<Pos> nearPos = new ArrayList<Pos>();
	public static boolean existPos(int x, int y){
		if(0<= y && y < height && x < width && 0<= x){
			if( arr[y][x].expression == '-' 
					|| arr[y][x].expression == '+' || arr[y][x].expression == '|'
					|| arr[y][x].expression == '1' || arr[y][x].expression == '2'
					|| arr[y][x].expression == '3' || arr[y][x].expression == '4'
			)return true;
		}
		
		return false;
	}
	public static void nextPos(int x, int y){
		if(0 <= y-1 && !arr[y][x].isVisit('u')){
			if(validate(arr[y-1][x].expression, arr[y][x].expression, 'v') == 1){
				arr[y][x].setVisit('u');
				arr[y-1][x].setVisit('d');
				nextPos(x,y-1);
			}else if(validate(arr[y-1][x].expression, arr[y][x].expression, 'v') == 2){
				result = arr[y-1][x];
			}
		}
		if(y+1 < height && !arr[y][x].isVisit('d')){
			if(validate(arr[y][x].expression, arr[y+1][x].expression, 'v') == 1){
				arr[y][x].setVisit('d');
				arr[y+1][x].setVisit('u');
				nextPos(x,y+1);
			}else if(validate(arr[y][x].expression, arr[y+1][x].expression, 'v') == 2){
				result = arr[y+1][x];
			}
		}
		if(0 <= x-1 && !arr[y][x].isVisit('l')){
			if(validate(arr[y][x-1].expression, arr[y][x].expression, 'h') == 1){
				arr[y][x].setVisit('l');
				arr[y][x-1].setVisit('r');
				nextPos(x-1,y);
			}else if(validate(arr[y][x-1].expression, arr[y][x].expression, 'h') == 2){
				result = arr[y][x-1];
			}
		}
		if(x+1 < width && !arr[y][x].isVisit('r')){
			if(validate(arr[y][x].expression, arr[y][x+1].expression, 'h') == 1){
				arr[y][x].setVisit('r');
				arr[y][x+1].setVisit('l');
				nextPos(x+1,y);
			}else if(validate(arr[y][x].expression, arr[y][x+1].expression, 'h') == 2){
				result = arr[y][x+1];
			}
		}
	}
	public static int validate(char v1, char v2, char point){
		//v1 :좌  상
		//v2 :우  하
		if(point == 'v'){//수직방향
			if(v1 == '|' || v1 == '+' || v1 == '1' ||v1 == '4' ){//상의 모형
				if(v2 == '|' || v2 == '+' || v2 == '2' ||v2 == '3' ){//하의 모형
					return 1;
					//return "correct";
				}
			}
		}else if(point == 'h'){//수평방향
			if(v1 == '-' || v1 == '+' || v1 == '1' ||v1 == '2'){//좌의 모형
				if(v2 == '-' || v2 == '+' || v2 == '3' ||v2 == '4'){//우의 모형
					return 1;
					//return "correct";
				}
			}
		}
		
		if(point == 'v'){//수직방향
			if(v1 == '|' || v1 == '+' || v1 == '1' ||v1 == '4' || (v1 == '.' && v2 != '.' )){//상의 모형
				if(v2 == '|' || v2 == '+' || v2 == '2' ||v2 == '3'|| (v2 == '.' && v1 != '.' )){//하의 모형
					return 2;
					//return "possible";
				}
			}
		}else if(point == 'h'){//수평방향
			if(v1 == '-' || v1 == '+' || v1 == '1' ||v1 == '2' || (v1 == '.' && v2 != '.' )){//좌의 모형
				if(v2 == '-' || v2 == '+' || v2 == '3' ||v2 == '4'|| (v2 == '.' && v1 != '.' )){//우의 모형
					return 2;
					//return "possible";
				}
			}
		}
		return -1;
		//return "invalidate";
	}
}
