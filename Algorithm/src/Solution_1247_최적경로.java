
public class Solution_1247_최적경로 {

	static int N,CX,CY,HX,HY,min;
	static int[][] customers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		go(0,0,CX,CY,0);
		System.out.println(min);
	}
	
	private static void go(int count, int visited, int bx, int by, int result) {
		
		if(result >= min) return; // 가지치기 : 기존까지 순열로 처리 중인 고객집들까지 이동했던 거리가 기존 min 값보다 크다면
								  // 		 더 이상 고객집을 방문해도 이동거리는 커질 수 밖에 없으므로 가지치기
		
		if(count ==N) { // 기저조건
			result += Math.abs(bx-HX) + Math.abs(by-HY);
			if(min > result) {
				min = result;
			}
			return;
		}
		
		for (int i=0; i<N; i++) { // 모든 고객 집을 다 count 위치에 시도
			if( (visited & 1<<i) == 0) { //visited && 1<<i : i고객집이 기준 순열에 처리되었는지 확인 :
										 // 0 -> 처리 안됨, 0 아님 -> 처리되었음
				// visited|(1<<i) : 기존 순열상태에 i고객집 추가
				go(count+1, visited|(1<<i),customers[i][0], customers[i][1], 
						result + Math.abs(bx - customers[i][0])+Math.abs(by - customers[i][1]));
				
			}
		}
	}

}
