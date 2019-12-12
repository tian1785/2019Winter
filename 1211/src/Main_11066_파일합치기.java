import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11066_파일합치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int test=1; test<=T; test++) {
			int K = Integer.parseInt(br.readLine());
			int[] csize = new int[K];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<K; i++) {
				csize[i] = Integer.parseInt(st.nextToken());
			}
			
			int tempK = K;
			int[] tmparr = csize;
			
			int result = 0;
			
			while(tempK>1) {
				Arrays.sort(tmparr);
				
				int rk = tempK%2==0?tempK/2:tempK/2+1;
				int[] tmparr2 = new int[rk];
				
				int idx = 0;
				for(int i=0; i<tempK-1; i=i+2) {
					
					tmparr2[idx] = tmparr[i] + tmparr[i+1];
					result+= tmparr2[idx++];
				}
				
				if(idx!=rk) {
					tmparr2[idx] = tmparr[tempK-1];
				}
				
				tempK = rk;
				tmparr = tmparr2;
			}
			
			System.out.println(result);
			
		}
	}

}
