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
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new boolean[1<<6][N][M];
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
		private int r, c, key;
		
		
		public State(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
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
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		@Override
		public String toString() {
			return "State [r=" + r + ", c=" + c + ", key=" + key +  "]";
		}
		
	}
	
	private static void bfs(int sr, int sc) {
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(sr, sc, 0));
		visit[0][sr][sc] = true;
		int time = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				State current = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nr = current.r + dx[i];
					int nc = current.c + dy[i];
					int key = current.key;
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#') continue;
					
					if(map[nr][nc]=='1') {
						Answer = time;
						return;
					}
					
					if('A'<=map[nr][nc] && map[nr][nc]<='F') { //키가 없으면  pass 한다
						if((key & (1<<map[nr][nc]-'A')) == 0)
							continue;
					}
					
					if('a'<=map[nr][nc] && map[nr][nc]<='f') {
						key = key | (1<<map[nr][nc]-'a');
					}
					
					if(visit[key][nr][nc])
						continue;
					
					visit[key][nr][nc] = true;
					queue.offer(new State(nr, nc, key));
				}
				
			}
			time++;
		}
	}
	
}