import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {

	static int M, N, Answer;
	static char[][] map;
	static boolean[][][] visit;
//	static boolean[] keys;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
//		keys = new boolean[103];
		visit = new boolean[7][N][M];
		int sr = 0, sc =0;
		Answer = -1;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0') {
					sr = i;
					sc = j;
				}
			}
		}
		if(map[sr][sc]!='1')
			bfs(sr, sc);
		else
			Answer = 0;
		
		System.out.println(Answer);
		
	}
	
	static class State{
		private int r, c, time;
		private boolean[] keys = new boolean[103];
		public State(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public boolean[] getKeys() {
			return keys;
		}
		public void setKeys(boolean[] keys) {
			this.keys = keys;
		}
		@Override
		public String toString() {
			return "State [r=" + r + ", c=" + c + ", time=" + time + ", keys=" + Arrays.toString(keys) + "]";
		}
		
	}
	
	private static void bfs(int sr, int sc) {
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(sr, sc, 1));
		visit[0][sr][sc] = true;
		
		while(!queue.isEmpty()) {
			State current = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = current.r + dx[i];
				int nc = current.c + dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#') break;
				
				if(map[nr][nc]=='1') {
					Answer = current.time;
					return;
				}
				boolean[] keys = current.getKeys().clone();
				
				if(!visit[nr][nc]) {
					if(65<=map[nr][nc] && map[nr][nc]<=70 && !keys[map[nr][nc]+32]) {
						break;
					}
					
					if(97<=map[nr][nc] && map[nr][nc]<=102) {
						keys[map[nr][nc]] = true;
					}
					
					State ncurrent = new State(nr,nc, current.getTime()+1);
					ncurrent.setKeys(keys);
					
					
					queue.offer(ncurrent);
					visit[nr][nc] = true;
				}
			}
		}
	}
	
//	private static void bfs(int sr, int sc) {
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[] {sr,sc, 1});
//		visit[sr][sc] = true;
//		
//		while(!queue.isEmpty()) {
//			int[] current = queue.poll();
//			
//			for(int i=0; i<4; i++) {
//				int nr = current[0] + dx[i];
//				int nc = current[1] + dy[i];
//				
//				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#') break;
//				
//				if(map[nr][nc]=='1') {
//					Answer = current[2];
//					return;
//				}
//				
////				if(!visit[nr][nc]) {
//					if(65<=map[nr][nc] && map[nr][nc]<=70 && !keys[map[nr][nc]+32]) {
//						break;
//					}
//					
//					if(97<=map[nr][nc] && map[nr][nc]<=102) {
//						keys[map[nr][nc]] = true;
//					}
//					
//					queue.offer(new int[] {nr, nc, current[2]+1});
//					visit[nr][nc] = true;
////				}
//			}
//		}
//	}
}