package usefulAlgorithm.Math;
import java.util.ArrayList;
import java.util.Collections;

public class ���� {
	public static void main(String[] args) {
		ArrayList<Integer> l1 = toN(16*16*16*13 + 16*16*14 + 15,16);
		for(int i = 0; i < l1.size(); i++){
			if(l1.get(i) == 10)
				System.out.print('A');
			else if(l1.get(i) == 11)
				System.out.print('B');
			else if(l1.get(i) == 12)
				System.out.print('C');
			else if(l1.get(i) == 13)
				System.out.print('D');
			else if(l1.get(i) == 14)
				System.out.print('E');
			else if(l1.get(i) == 15)
				System.out.print('F');
			else
				System.out.print(l1.get(i));
		}
	}
	//���ϴ� ����, ������ ������ �´� ���� ����Ʈ�� ������(���ĺ��� �ƴ� ���� ���ڰ����� ������)
	public static ArrayList<Integer> toN(int n, int express){
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true){
			list.add(n%express);
			n/=express;
			if(n == 0)
				break;
		}
		Collections.reverse(list);
		return list;
	}
}

