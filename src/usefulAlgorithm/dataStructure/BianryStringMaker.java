package usefulAlgorithm.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BianryStringMaker {
	public static int pathValue[][];
	public static int[] dp;
	public static int visit[][];
	public static int n;
	public static int range;
	public static void main(String[] args) {
		System.out.println(getIndexStr(5, 1));
		System.out.println(getIndexStr(5, 2));
		System.out.println(getIndexStr(5, 3));
		System.out.println(getIndexStr(5, 4));
		System.out.println(getIndexStr(5, 5));
	}

	public static Queue<String> getIndexStr(int allCount, int setCount){
		Queue<String> qu = new LinkedList<String>();
		Queue<Integer> last1 = new LinkedList<Integer>();
		Queue<Integer> dept = new LinkedList<Integer>();
		String str = "";
		for(int i = 0; i < allCount; i++)
			str+="0";
		qu.add(str);
		dept.add(0);
		last1.add(-1);
		Integer currentDept = 1;
		while(true){
			currentDept = dept.peek();
			if(setCount <=  currentDept)
				break;
			dept.remove();
			String item  = qu.peek();
			qu.remove();
			Integer currentLast1 = last1.peek();
			last1.remove();
			for(int i = currentLast1+1; i < allCount; i++){
				String insertItem = item.substring(0,i) + 1 + item.substring(i+1, item.length());
				qu.add(insertItem);
				dept.add(currentDept+1);
				last1.add(i);
			}
		}
		return qu;
	}
}





