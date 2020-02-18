import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {

	static int R, C;
	static int map[][];
	static int visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int test=1; test<=T; test++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			visit = 0;
			map = new int[R][C];
			for(int i=0; i<R; i++) {
				String s = br.readLine();
				for(int j=0; j<C; j++) {
					map[i][j] = (int)(s.charAt(j) - 'A');
				}
			} //입력 완료
			
			bfs();
			
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		
	}

}
