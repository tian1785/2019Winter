import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기 {
	private static int[][] m;
	private static HashSet<Integer> hs;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner => BufferedReader
//		쪼개기 String.split() => StringTokenizer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= TC; testCase++) {
			m = new int[4][4];
			
			for(int i=0; i<4; i++) {
				String str = br.readLine();
				for(int j=0, index =0 ; j<4; j++, index +=2) {
					m[i][j] = str.charAt(index) - '0';
				}
			}
			hs = new HashSet<>();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i,j,0);
				}
			}
			
			sb.append('#').append(testCase).append(" ").append(hs.size()).append("\n");			
			
		} // end of for testCase
		
		System.out.print(sb.toString());
	} // end of main


	private static void dfs(int i, int j, int k) {
		if (k==6) {
			
			return;
		}
		
		
	}

}
