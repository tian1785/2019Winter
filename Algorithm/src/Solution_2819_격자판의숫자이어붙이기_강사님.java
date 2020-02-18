import java.util.HashSet;
import java.util.Scanner;

public class Solution_2819_격자판의숫자이어붙이기_강사님 {

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static HashSet<Integer> set;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test=1; test<=T; test++) {
			map = new int[4][4];
			set = new HashSet<>();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(0, map[i][j], i, j);					
				}
			}
			
			System.out.println("#"+test+" "+ set.size());
		}
	}

	private static void dfs(int idx, int now, int r, int c) {
		if(idx == 6) {
			set.add(now);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			
			if(nr>=0 && nr<4 && nc>=0 && nc<4) {
				dfs(idx+1, now*10 + map[nr][nc], nr, nc);
			}
		}
	}

}
