package usefulAlgorithm.BFS;

import java.util.Scanner;

public class QueueInBFS {
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
		//큐의 뒤에 요소추가, 한번들어온 요소값을 다시는 추가할 수 없음
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
		//큐에  맨앞 요소 제거
		public void pop(){
			setIndex();
			arr[first] = -1;
			first++;
			size--;
		}
		//큐의 맨앞 요소를 가져옴
		public int top(){
			setIndex();
			return arr[first];
		}
		//큐에서 맨앞 요소에 맞는 라벨값을 가져옴
		public int getLabel() {
			setIndex();
			return this.label[first];
		}
		//큐의 요소와 그 라벨을 붙여  뒤에 추가 , 한번들어온 요소값을 다시는 추가할 수 없음
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
		UserQueInBFS uq =  new UserQueInBFS(10);
		uq.push(5, 0);
		int level=0; 
		while(0 < uq.size()){
			level = uq.getLabel();
			int S = uq.top();
			System.out.print(S +"(Lv" +level+") ");
			uq.pop();
			if(1 <= S-1)
				uq.push(S-1 , level+1);
			if(S+1 <= 10)
				uq.push(S+1 , level+1);
		}
	}
}
