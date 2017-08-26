package usefulAlgorithm.dataStructure;

import java.util.Scanner;

public class CircularQueue {
	public static class CircularUserQue {
		public int arr[];
		public int first = 0;
		public int end = 0;
		public int capacitiy = 0;
		public int size = 0;

		CircularUserQue(int capacitiy) {
			this.capacitiy = capacitiy;
			arr = new int[this.capacitiy];
			for (int a = 0; a < arr.length; a++)
				arr[a] = -1;
		}

		public void push(int item) {
			if (capacitiy <= size) {
				System.err.println("->err capacitiy");
				return;
			}
			setIndex();
			arr[end++] = item;
			size++;
		}

		public int pop() {
			setIndex();
			if (size <= 0)// 큐값이 없을때 -1리턴
				return -1;
			int popItem = arr[first];
			arr[first] = -1;
			first++;
			size--;
			return popItem;
		}

		public int front() {
			setIndex();
			if (size <= 0)// 큐값이 없을때 -1리턴
				return -1;
			return arr[first];
		}

		public int back() {
			if (size <= 0)// 큐값이 없을때 -1리턴
				return -1;
			setIndex();
			return arr[end - 1];
		}

		public void setIndex() {
			if (capacitiy <= end) {
				end %= capacitiy;
			}
			if (capacitiy <= first) {
				first %= capacitiy;
			}
		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			if (size <= 0)
				return true;
			return false;
		}

		public void print() {
			System.out.println("size:" + size);
			for (int i = first; i < first + size; i++)
				System.out.print(arr[i % capacitiy] + " ");
			System.out.println();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		CircularUserQue uq = new CircularUserQue(8);
		for (int a = 1; a < 11; a++) {
			System.out.print("push(" + a + ")");
			uq.push(a);
			uq.print();
			System.out.print("push(" + a + ")");
			uq.push(a);
			uq.print();
			System.out.print("pop()");
			uq.pop();
			uq.print();
		}
	}
}
