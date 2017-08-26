//문제 출처 : https://www.acmicpc.net/problem/10845
//제목 : 큐10845

package 백준.큐;

import java.util.Scanner;

public class 큐10845 {
	public static class CircularUserQue{
		public int arr[];
		public int first = 0;
		public int end = 0;
		public int capacitiy = 0;
		public int size = 0;
		CircularUserQue(int capacitiy){
			this.capacitiy = capacitiy;
			arr = new int[this.capacitiy];
			for(int a=0; a<arr.length; a++)
				arr[a] = -1;
		}
		public void push(int item){
			if(capacitiy <= size){
				System.err.println("->err capacitiy");
				return;
			}
			setIndex();
			arr[end++] = item;
			size++;
		}
		public int pop(){
			setIndex();
			if(size <= 0)//큐값이 없을때 -1리턴
				return -1;
			int popItem = arr[first];
			arr[first] = -1;
			first++;
			size--;
			return popItem;
		}		
		public int front(){
			setIndex();
			if(size <= 0)//큐값이 없을때 -1리턴
				return -1;
			return arr[first];
		}
		public int back(){
			if(size <= 0)//큐값이 없을때 -1리턴
				return -1;
			setIndex();
			return arr[end-1];
		}
		public void setIndex(){
			if(capacitiy <= end){
				end%=capacitiy;
			}
			if(capacitiy <= first){
				first%=capacitiy;
			}
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
			for(int i = first; i< first + size; i++)
				System.out.print(arr[i%capacitiy] +" ");
			System.out.println();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		CircularUserQue cuq = new CircularUserQue(n);
		for(int a=0; a<n; a++){
			String command = sc.next();
			if(command.equals("push")){
				int pushNum = sc.nextInt();
				cuq.push(pushNum);
			}else if(command.equals("pop")){
				System.out.println(cuq.pop());
			}else if(command.equals("front")){
				System.out.println(cuq.front());
			}else if(command.equals("back")){
				System.out.println(cuq.back());
			}else if(command.equals("size")){
				System.out.println(cuq.size());
			}else if(command.equals("empty")){
				if(cuq.isEmpty())
					System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}
