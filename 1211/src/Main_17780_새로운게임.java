import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17780_새로운게임 {

	static class Piece {
		int idx, r, c, d;

		public Piece(int idx, int r, int c, int d) {
			super();
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
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

		public int getD() {
			return d;
		}

		public void setD(int d) {
			this.d = d;
		}

		@Override
		public String toString() {
			return "Piece [idx=" + idx + ", r=" + r + ", c=" + c + ", d=" + d + "]";
		}
		
	}
	
	
	static int N, K;
	static int[][] color;
	static Piece[] ps;
	static ArrayList<Piece>[][] map;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static boolean isEnd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		color = new int[N][N];
		ps = new Piece[K];
		map = new ArrayList[N][N];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1, c=Integer.parseInt(st.nextToken())-1, d=Integer.parseInt(st.nextToken());
			ps[i] = new Piece(i+1, r, c, d);
			
			map[r][c].add(ps[i]);
		}
		
		int Answer = -1;
		isEnd = false;
		int turn = 1;
		
		isEnd= check();
		
		while(!isEnd && turn<=1000) {
			
			for(int i=0; i<K; i++) {
				Piece tmpP = ps[i];
				if(map[tmpP.getR()][tmpP.getC()].get(0) == tmpP) { //맨 아래 있는지 확인
					play(tmpP, false);
				}
			}
			
			if(isEnd) {
				Answer = turn;
			}
			
			turn++;
		}
		
		System.out.println(Answer);
		
	}
	private static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size()>3) {
					return true;
				}
			}
		}
		return false;
	}
	private static void play(Piece tmpP, boolean isb) {
		int r = tmpP.getR();
		int c = tmpP.getC();
		int d = tmpP.getD();
		
		int nr = r + dx[d];
		int nc = c + dy[d];
		
		if(nr<N && nr>=0 && nc<N && nc>=0) { //범위 내에 있으면
			if(color[nr][nc] ==0) {
				go(r, c, nr, nc);
			}else if(color[nr][nc] == 1 ) {//빨간색이면 List 거꾸로
				int lsize = map[r][c].size();
				ArrayList<Piece> tmplist = new ArrayList<>();
				
				for(int i=lsize-1; i>=0; i--) {
					tmplist.add(map[r][c].get(i));
				}
				
				map[r][c] = tmplist;
				
				go(r, c, nr, nc);
				
			}else if(color[nr][nc]==2) { // 파란 색이면 한칸 이동
				if(!isb) {
					tmpP.setD(changedir(d));
					play(tmpP, true);
				}
				
			}
		}else {
			if(!isb) {
				tmpP.setD(changedir(d));
				play(tmpP, true);
			}
		}
		
	}

	
	private static void go(int r, int c, int nr, int nc) {
		ArrayList<Piece> prior = map[r][c];
		ArrayList<Piece> next = map[nr][nc];
		
		while(prior.size()>0) {
			Piece tmpP = prior.get(0);
			tmpP.setR(nr);
			tmpP.setC(nc);
			next.add(tmpP);
			prior.remove(0);
		}
		
		if(next.size()>3) {
			isEnd = true;
		}
		
	}
	private static int changedir(int i) {
		if( i == 1) {
			return 2;
		}else if(i==2) {
			return 1;
		}else if(i==3) {
			return 4;
		}else if(i==4) {
			return 3;
		}
		
		return -1;
	}
}
