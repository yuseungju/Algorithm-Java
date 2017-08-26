//문제 출처 : https://www.acmicpc.net/problem/5014
//제목 : 스타트링크5014


package 백준.BFS;

import java.util.Scanner;

public class 스타트링크5014 {
	public static class UserQueInBFS{
		public int arr[];
		public int history[];//한번등록된적있는값인지 확인
		public int first = 0;
		public int end = 0;
		public int capacitiy = 0;
		public int size = 0;
		public int label[];//요소와 함께 저장될 표식
		UserQueInBFS(int capacitiy){
			this.capacitiy = capacitiy;
			arr = new int[this.capacitiy];
			label = new int[this.capacitiy];
			history = new int[this.capacitiy+1];
			history[0] = -1;
			for(int a=0; a<capacitiy; a++){
				arr[a] = -1;
				label[a] = -1;
				history[a+1] = -1;
			}
		}
		public void push(int item){
			if(history[item] != -1)//큐에 들어온 기록이있는 데이터이면 넣지않음
				return;
			if(capacitiy <= size){
				System.err.println("err capacitiy");
				return;
			}
			setIndex();
			arr[end++] = item;
			history[item] = 1;
			size++;
		}
		public void pop(){
			setIndex();
			arr[first] = -1;
			first++;
			size--;
		}
		public int top(){
			setIndex();
			return arr[first];
		}
		public int getLabel() {
			setIndex();
			return this.label[first];
		}
		public void push(int item, int label) {
			if(history[item] != -1)//큐에 들어온 기록이있는 데이터이면 넣지않음
				return;
			if(capacitiy <= size){
				System.err.println("err capacitiy");
				return;
			}
			setIndex();
			this.label[end] = label;
			arr[end++] = item;
			history[item] = 1;
			size++;
		}
		public void setIndex(){
			if(capacitiy <= end){
				end%=capacitiy;
			}
			if(capacitiy <= first){
				first%=capacitiy;
			}
		}
		public void print(){
			System.out.println("size:" + size);
			for(int i = first; i< first + size; i++)
				System.out.print(arr[i%capacitiy] +" ");
			System.out.println();
		}
		public int size(){
			return size;
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int F = sc.nextInt();//층수 범위 1~ F
		int S = sc.nextInt();//출발
		int G = sc.nextInt();//도착
		int U = sc.nextInt();//위로이동단위
		int D = sc.nextInt();//아래로이동단위

		UserQueInBFS uq =  new UserQueInBFS(F);
		uq.push(S, 0);
		int level=0; 
		//bfs시작
		while(0 < uq.size()){
			level = uq.getLabel();
			S = uq.top();
			uq.pop();
			if(S == G)//도착 요소 까지 도달하면
				break;//종료
			//탐색
			if(S+U <= F)
				uq.push(S+U , level+1);
			if(0 <= S-D)
				uq.push(S-D, level+1);
		}
		if(S == G)
			System.out.println(uq.getLabel());
		else 
			System.out.println("use the stairs");
	}
}
