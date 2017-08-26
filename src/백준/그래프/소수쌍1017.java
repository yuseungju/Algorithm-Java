//문제 출처 : https://www.acmicpc.net/problem/1017
//제목 : 소수쌍1017
//이분매칭

package 백준.그래프;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class 소수쌍1017 {
	public static ArrayList<Integer> primList = new ArrayList<Integer>();
	public static boolean isPrime(int  n){
		if(n == 1)
			return false;
		for(int a=0; a < primList.size(); a++){
			if(n == primList.get(a))//소수리스트에 존재하는값이면 소수
				return true;//소수임
			if(n < primList.get(a))//소수목록값이 비교할값보다 커지면
				return false;//더이상 조사안함
			if(n%primList.get(a) == 0)
				return false;//소수가아님
			if(primList.get(a)* primList.get(a) < a)
				break;
		}
		primList.add(n);//소수목록에 소수 추가
		return true;//소수임
	}
	public static int Arr1FromArr2[];
	public static int visitArr1[];
	public static boolean prime[][];
	public static int arr1[];
	public static int arr2[];
	public static int arrSize = 0;
	public static int pair1 = 0;
	public static int pair2 = 0;
	
	public static void main(String[] args) {
		//소수값 미리 2000까지 계산
		for(int a=1; a<=2000; a++)
			isPrime(a);
		Scanner sc = new Scanner(System.in);
		//숫자 입력, 홀수 짝수 분리
		int numSize = sc.nextInt();
		arr1 = new int[numSize];
		arr2 = new int[numSize];
		int arr1Size = 0;
		int arr2Size = 0;
		int firstNum = arr1[arr1Size++] = sc.nextInt();
		for(int a = 1; a < numSize; a++){
			int num =  sc.nextInt();
			if(num%2 == firstNum%2)
				arr1[arr1Size++] = num;
			else
				arr2[arr2Size++] = num;
		}
		//홀수와 짝수의 개수가 같지않으면 완전한소수쌍이 불가능
		if(arr1Size != arr2Size){
			System.out.println(-1);
			return;
		}
		arrSize = arr1Size;
		
		//소수인지 미리 설정
		prime = new boolean[arrSize][arrSize];
		for(int a=0; a<arrSize; a++){
			for(int b=0; b<arrSize; b++)
				prime[a][b] = isPrime(arr2[b]+arr1[a]);
		}
		
		//소수쌍이 될수있는 경우중 첫번째 요소와 매칭되는 값을 결과로 저장
		ArrayList<Integer> result =  new ArrayList<Integer>();
		for(int i2 = 0; i2 < arrSize; i2++){
			//첫번째요소와 합이 소수가되는 쌍을 설정
			pair1 = 0;
			pair2 = i2;
			boolean allConnented = true;//완전한 소수쌍이 가능한지 여부
			if(prime[pair1][pair2]){//첫번째값과의 합이 소수를 이루면 그 두값을 제외한 다른값들의 쌍이 소수가되는지확인	
				//System.out.println("가능한지확인 :"+ arr1[pair1]+"+"+ arr2[pair2]);
				Arr1FromArr2 = new int[arrSize];
				Arr1FromArr2[pair2] = pair1;
				for(int i1 = 1; i1 < arrSize; i1++){
					visitArr1 = new int[arrSize];
					if(!setConnect(i1)){//한번이라도 자신의쌍을 찾을수 없으면(합이 소수가되는 조건으로)
						allConnented = false;
						break;
					}
				}
				if(allConnented){//모든연결이 성공했으면
					result.add(arr2[pair2]);
					/*for(int i = 0; i < Arr1FromArr2.length; i++)
						System.out.println(arr1[Arr1FromArr2[i]] +"-" + arr2[i] +":"+ (arr1[Arr1FromArr2[i]]  + arr2[i]));
					System.out.println();*/
				}
			}
		}
		Collections.sort(result);
		for(int i = 0; i < result.size(); i++)
			System.out.print(result.get(i) + " ");
		if(result.size() == 0)
			System.out.println(-1);
	}
	public static boolean setConnect(int it1){
		if(visitArr1[it1] == 1)
			return false;
		visitArr1[it1] = 1;
		for(int it2=0; it2<arrSize; it2++){
			if(prime[it1][it2] && pair1 != it1 && pair2 != it2){//연결가능하면(합이 소수)
				if(Arr1FromArr2[it2] == 0){//아직 연결된 값이 없다면
					Arr1FromArr2[it2] = it1;//바로연결
					return true;
				}
				if(setConnect(Arr1FromArr2[it2])){//이미 연결돼있다면 그 연결된 값을 다른값과 연결
					Arr1FromArr2[it2] = it1;//연결
					return true;
				}
			}
		}
		return false;
	}
}



