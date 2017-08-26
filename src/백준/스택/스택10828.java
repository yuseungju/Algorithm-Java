//문제 출처 : https://www.acmicpc.net/problem/10828 
//제목 : 스택10828

package 백준.스택;

import java.util.Scanner;

public class 스택10828 {
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		UserStack us = new UserStack(n);
		for(int a=0; a<n; a++){
			String command = sc.next();
			if(command.equals("push")){
				int pushNum = sc.nextInt();
				us.push(pushNum);
			}else if(command.equals("pop")){
				System.out.println(us.pop());
			}else if(command.equals("top")){
				System.out.println(us.top());
			}else if(command.equals("size")){
				System.out.println(us.size());
			}else if(command.equals("empty")){
				if(us.isEmpty())
					System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}