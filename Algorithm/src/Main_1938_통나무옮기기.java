import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {

	static int N;
	static int[][] map;
	static Namu start, end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; 
		
		boolean B= false, E = false;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = (int)(s.charAt(j)-'0');
			}
		}
		
		first:
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='B') {
					B = true;
					if(i+1 < N && map[i+1][j]=='B') {
						start = new Namu(i, j, 0);
						for(int k=i; k<i+3; k++) {
							map[k][j] = 0;
							
						} //세로로 길때
					}else {
						start = new Namu(i,j,1);
						for(int k=j; k<j+3; k++) {
							map[i][k] = 0;
							
						}
					}
				}
				
				if(map[i][j]=='E') {
					E = true;
					if(i+1 < N && map[i+1][j]=='E') {
						end = new Namu(i, j, 0);
						for(int k=i; k<i+3; k++) {
							map[k][j] = 0;
							
						}
					}else {
						end = new Namu(i,j,1);
						for(int k=j; k<j+3; k++) {
							map[i][k] = 0;
							
						}
					}
				}
				
				if(B && E) break first;
			}
		}
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Namu> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size -- >0) {
				Namu current = queue.poll();
				int r = current.getSr();
				int c = current.getSc();
				int d = current.getDirection();
				
				for(int i=0; i<5; i++) {
//					int[] check = check(r,c,d,i);
				}
				
			}
			size++;
		}
		
	}

//	private static int[] check(int r, int c, int d, int i) {
//		int[] result = {0,0,0,0};
//		//첫번째는 가능하면 1 불가능하면 0
//		
//		if(d==0) { //세로로 길 때
//			
//			
//			
//		}else { //가로로 길때
//			
//		}
//	}

	static class Namu {
		int sr, sc, direction;

		public Namu(int sr, int sc, int direction) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.direction = direction;
		}			

		public int getSr() {
			return sr;
		}

		public void setSr(int sr) {
			this.sr = sr;
		}

		public int getSc() {
			return sc;
		}

		public void setSc(int sc) {
			this.sc = sc;
		}

		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}


		public boolean isEqual(Namu other) {
			if(other.sr == this.sr && other.sc==this.sc && other.direction==this.direction) return true;
			
			return false;
		}
		
	}

}
