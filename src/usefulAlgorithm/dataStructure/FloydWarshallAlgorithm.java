package usefulAlgorithm.dataStructure;

public class FloydWarshallAlgorithm {
	static class UserFloydWarshallAlgorithm{
		public int vSize = 0;
		public int weight[][];
		UserFloydWarshallAlgorithm(int vSize){
			weight = new int[vSize+1][vSize+1];
			for(int i = 1; i <= vSize; i++){
				for(int j = 1; j <= vSize; j++){
					if(i == j)
						weight[i][j]=0;
					else
						weight[i][j] = Integer.MAX_VALUE;
				}
			}
			this.vSize = vSize;
		}
		public void setPath(int start, int end, int weightValue){
			weight[start][end] = weightValue;
		}
		public void processMinIntervalPath(){
			for(int mid=1; mid<=vSize; mid++){
				for(int start=1; start<=vSize; start++){
					for(int end=1; end<=vSize; end++){
						if((long)weight[start][mid] + weight[mid][end] < weight[start][end]){
							weight[start][end] = weight[start][mid] + weight[mid][end];
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int vSize = 5;
		UserFloydWarshallAlgorithm ufwa = new UserFloydWarshallAlgorithm(vSize);
		ufwa.setPath(5,1,1);
		ufwa.setPath(1,2,2);
		ufwa.setPath(1,3,3);
		ufwa.setPath(2,3,4);
		ufwa.setPath(2,4,5);
		ufwa.setPath(3,4,6);
		ufwa.processMinIntervalPath();
		System.out.println("최소경로 1->4: "+ ufwa.weight[1][4]);
		System.out.println("최소경로 2->3: "+ ufwa.weight[2][3]);
		System.out.println("최소경로 4->4: "+ ufwa.weight[4][4]);
		System.out.println("최소경로 3->1(불가능): "+ ufwa.weight[3][1]);
	}
}
