package usefulAlgorithm.Math;

import java.util.ArrayList;

public class �Ҽ�_�����������ʴ¼� {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	//���⵵ ��(root-n)
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=0; a < list.size(); a++){
			if(n%list.get(a) == 0)
				return false;//�Ҽ����ƴ�
			if(list.get(a)* list.get(a) < a)
				break;
		}
		list.add(n);
		return true;//�Ҽ���
	}
	public static void main(String[] args) {
		System.out.println(isNum(1));
		System.out.println(isNum(1230));
		System.out.println(isNum(2));
		System.out.println(isNum(3));
		System.out.println(isNum(1993));
		System.out.println(isNum(1237));
	}
}
