//���� ��ó : https://www.acmicpc.net/problem/5014
//���� : ��ŸƮ��ũ5014


package ����.BFS;

import java.util.Scanner;

public class ��ŸƮ��ũ5014 {
	public static class UserQueInBFS{
		public int arr[];
		public int history[];//�ѹ���ϵ����ִ°����� Ȯ��
		public int first = 0;
		public int end = 0;
		public int capacitiy = 0;
		public int size = 0;
		public int label[];//��ҿ� �Բ� ����� ǥ��
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
			if(history[item] != -1)//ť�� ���� ������ִ� �������̸� ��������
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
			if(history[item] != -1)//ť�� ���� ������ִ� �������̸� ��������
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
		int F = sc.nextInt();//���� ���� 1~ F
		int S = sc.nextInt();//���
		int G = sc.nextInt();//����
		int U = sc.nextInt();//�����̵�����
		int D = sc.nextInt();//�Ʒ����̵�����

		UserQueInBFS uq =  new UserQueInBFS(F);
		uq.push(S, 0);
		int level=0; 
		//bfs����
		while(0 < uq.size()){
			level = uq.getLabel();
			S = uq.top();
			uq.pop();
			if(S == G)//���� ��� ���� �����ϸ�
				break;//����
			//Ž��
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
