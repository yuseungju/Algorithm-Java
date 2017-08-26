package usefulAlgorithm.dataStructure;

import java.util.Scanner;


public class Stack{
	public static class UserStack{
		public int arr[];
		public int end = 0;
		public int capacitiy = 0;
		public int size = 0;
		UserStack(int capacitiy){
			this.capacitiy = capacitiy;
			arr = new int[this.capacitiy];
		}
		public void push(int item){
			if(capacitiy <= size){
				System.err.println("->err capacitiy");
				return;
			}
			arr[end++] = item;
			size++;
		}
		public int pop(){
			if(isEmpty())
				return -1;
			end--;
			size--;
			return arr[end];
		}
		public int top(){
			if(isEmpty())
				return -1;
			return arr[end-1];
		}
		public int size(){
			return size;
		}
		public boolean isEmpty(){
			if(size <= 0)
				return true;
			return false;
		}
		public void print(){
			System.out.println("size:" + size);
			for(int i = 0; i< end; i++)
				System.out.print(arr[i] +" ");
			System.out.println();
			System.out.println();
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		UserStack userStack = new UserStack(6);
		System.out.println("\npush start\n");
		userStack.push(0);
		userStack.push(1);
		userStack.push(2);
		userStack.push(3);
		userStack.push(4);
		userStack.push(5);
		userStack.push(6);
		System.out.println("\npush end\n");
		while(0 < userStack.size()){
			System.out.print("size:"+ userStack.size() + "\t");
			System.out.println("item:"+ userStack.top());
			userStack.pop();
		}
	}
}
