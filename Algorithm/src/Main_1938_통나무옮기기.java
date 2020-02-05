import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
				if(s.charAt(j) =='B') {
					if(!B) {
						
					}
				}
			}
		}
	}
	
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
