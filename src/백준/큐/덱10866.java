package ����.ť;

import java.io.IOException;
//���� ��ó : https://www.acmicpc.net/problem/10866
//���� :��10866
import java.util.Scanner;
public class ��10866 {
	/*
	push_front X: ���� X�� ���� �տ� �ִ´�.
	push_back X: ���� X�� ���� �ڿ� �ִ´�.
	pop_front: ���� ���� �տ� �ִ� ���� ����, �� ���� ����Ѵ�. ����, ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
	pop_back: ���� ���� �ڿ� �ִ� ���� ����, �� ���� ����Ѵ�. ����, ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
	size: ���� ����ִ� ������ ������ ����Ѵ�.
	empty: ���� ��������� 1��, �ƴϸ� 0�� ����Ѵ�.
	front: ���� ���� �տ� �ִ� ������ ����Ѵ�. ���� ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
	back: ���� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.*/
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








