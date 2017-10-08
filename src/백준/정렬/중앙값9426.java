//문제 출처 : https://www.acmicpc.net/problem/9426
//제목 : 중앙값9426

package 백준.정렬;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 중앙값9426 {
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int k = Integer.parseInt( st.nextToken() );
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		System.out.println(getSumMidValue(arr, k));
	}
	//중앙값의 합을 가져옴
	public static long getSumMidValue(int src[], int k){
		long sumMidValue = 0;
		int srcDelIt = 0;
		int srcAddIt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < k;  i++)
			list.add(src[srcAddIt++]);
		Collections.sort(list);
		//System.out.println(list);
		
		sumMidValue = list.get((k-1)/2);
		//System.out.println(list.get((k-1)/2));
		while(srcAddIt != src.length){
			//삭제 
			int delItem = src[srcDelIt++];
			//System.out.print("del" + delItem +"   "  );
			int f = 0;
			int e =  list.size()-1;
			int m = (f+e)/2;
			while(true){
				m = (f+e)/2;
				if(f == m){
					if(list.get(e) <= delItem)
						e = f = e;
					else if(delItem <= list.get(f))
						e = f;
					break;
				}
				if(list.get(m) < delItem)
					f = m;
				else if(list.get(m) > delItem)
					e = m;
				else {
					e = f = m;
					break;
				}
			}
			list.remove(e);
			
			//추가 
			int addItem = src[srcAddIt++];
			//System.out.print("add" + addItem +"   "  );
			f = 0;
			e =  list.size()-1;
			m = (f+e)/2;
			if(e < 0){
				sumMidValue += addItem;
				list.add(addItem);
				//System.out.println(addItem);
				continue;
			}
			while(0 <= e){
				m = (f+e)/2;
				if(f == m){
					if(list.get(e) <= addItem)
						e = f = e+1;
					else if(addItem < list.get(f))
						e = f;
					break;
				}
				if(list.get(m) < addItem)
					f = m;
				else if(list.get(m) > addItem)
					e = m;
				else {
					e = f = m;
					break;
				}
			}
			list.add(e, addItem);
			sumMidValue+=list.get((k-1)/2);
			//System.out.println(list.get((k-1)/2));
			//System.out.println(list);
		}
		return sumMidValue;
	}

	public static int getPartSort(int arr[], int first, int end, int targetIt){
		int f = first;
		int e = end;
		int midValue = arr[(f+e)/2];
		while(f!=e){
			while(true){
				if(arr[f] < midValue)
					f++;
				else break;
			}
			while(true){
				if(midValue < arr[e])
					e--;
				else break;
			}
			if(arr[e] == arr[f] && f!=e){
				f++;
			}else{
				int temp = arr[e]; 
				arr[e] = arr[f];
				arr[f] = temp;
			}
		}
		
		if(targetIt < e){
			return getPartSort(arr,  first, e-1, targetIt);
		}else if(e < targetIt){
			return getPartSort(arr, e+1, end, targetIt);
		}else{
			return arr[targetIt];
		}
	}
}
