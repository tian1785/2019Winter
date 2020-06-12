import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 완전탐색 : 부분집합 --> 조합
public class Solution_2115_벌꿀채취2_태희쌤 {

	static int N,M,C; //  N : 발통 크기, M: 연속된벌통수, C:채취량
	static int[][] map, maxMap; // map : 입력된 벌통 정보,
								// maxMap : i,j위치에서 가질수 있는 최대 이익
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N]; // 0으로 자동초기화
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine(), " "); //한행 입력
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//end input
			//1. 각 i,j 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			//2. 두 일꾼의 조합
			System.out.println("#"+test+" "+getMaxBenefit());
		}
		
	}// end main

	
	private static void makeMaxMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-M; j++) {
				makeMaxSubset(i,j,0,0,0);
			}
		}
	}
	
	// i: 행위치, j:열위치, cnt: 고려한원소수
	// sum: 부분집합에 속한 원소의 합
	// powSum: 부분집합에 속한 원소의 이익	
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		
		if(sum>C) return; // 부분집합의 합이 목표량C를 초과하면 리턴
		if(cnt == M) { 
			// 0,0 M=2
			// 0,0:0 0,1:1 0,2:2
			if(maxMap[i][j-M]<powSum) {
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		
		// i, j위치 원소 선택
		makeMaxSubset(i, j+1, cnt+1, 
				sum+map[i][j], powSum+map[i][j]*map[i][j]);		
		// i, j위치 원소  비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powSum);
	}
	
	private static int getMaxBenefit() {
		int max =0, temp=0; //max : 조합적 선택후의 최대이익값
		//1. 일꾼A 기준선택
		for(int i=0; i<N; i++) {
			for(int j=0; j<= N-M; j++) { // a일꾼
				//2. 일꾼 B 선택
				// 같은 행기준 선택
				for(int j2 = j+M; j2<= N-M; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2];
					if(max <temp) {
						max = temp;
					}
				}
				// 다음행부터 마지막행 까지 선택
				for(int i2 =i+1; i2<N; i2++) {
					for(int j2 =0; j2<= N-M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max<temp) {
							max = temp;
						}
					}
				}
			}
		}
		
		return max;
	}
}
