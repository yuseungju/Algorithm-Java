package 백준.큐;

import java.io.IOException;
//문제 출처 : https://www.acmicpc.net/problem/10866
//제목 :덱10866
import java.util.Scanner;
public class 덱10866 {
	/*
	push_front X: 정수 X를 덱의 앞에 넣는다.
	push_back X: 정수 X를 덱의 뒤에 넣는다.
	pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 덱에 들어있는 정수의 개수를 출력한다.
	empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/
	public static class UserDeque{
		int arr[];
		int f, e; 
		int capacity;
		int size = 0;
		UserDeque(int capacity){
			this.capacity = capacity;
			arr = new int[this.capacity];
			this.f = 1; 
			this.e = 0;
		} 
		public void pushFront(int item){
			if(size == capacity){
				System.err.println("err, anymore don't add");
				return;	
			}
			f--;
			f = (capacity + f)%capacity;
			arr[f] = item;
			size++;
		}
		public void pushBack(int item){
			if(size == capacity){
				System.err.println("err, anymore don't add");
				return;	
			}
			e++;
			e = (capacity + e)%capacity;
			arr[e] = item;
			if(capacity <= e)
				e = 0;
			size++;
		}
		public int front(){
			if(size != 0)
				return arr[f];
			return -1;
		}
		public int back(){
			if(size != 0)
				return arr[e];
			return -1;
		}
		public int popFront(){
			int num = -1;
			if(size != 0){
				num = arr[f];
				f++;
				f = (capacity + f)%capacity;
				size --;
			}
			return num;
		}
		public int popBack(){
			int num  = -1;
			if(size != 0){
				num =  arr[e];
				e--;
				e = (capacity + e)%capacity;
				size --;
			}
			return num;
		}
		public int getSize(){
			return size;
		}
		public int isEmpty(){
			if(size == 0)
				return 1;
			else 
				return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		UserDeque udq = new UserDeque(5);
		Scanner sc = new Scanner(System.in);
		int n  =  sc.nextInt();
		for(int i = 0 ; i < n; i++){
			String in =  sc.next();
			if(in.equals("push_back")){
				udq.pushBack(sc.nextInt());
			}else if(in.equals("push_front")){
				udq.pushFront(sc.nextInt());
			}else if(in.equals("front")){
				System.out.println(udq.front());
			}else if(in.equals("back")){
				System.out.println(udq.back());
			}else if(in.equals("pop_front")){
				System.out.println(udq.popFront());
			}else if(in.equals("pop_back")){
				System.out.println(udq.popBack());
			}else if(in.equals("size")){
				System.out.println(udq.getSize());
			}else if(in.equals("empty")){
				System.out.println(udq.isEmpty());
			}
			//System.out.println(Arrays.toString(udq.arr));
		}
	}
}








