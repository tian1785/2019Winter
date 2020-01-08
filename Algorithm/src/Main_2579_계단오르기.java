import java.util.Scanner;

public class Main_2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stairs = new int[N+1];
		int[] D = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			stairs[i] = sc.nextInt();
		}
		
		D[1] = stairs[1];
		if(N>=2) D[2] = D[1] + stairs[2];
		
		for(int i=3; i<=N; i++) {
			D[i] = Math.max(D[i-2] + stairs[i], D[i-3]+stairs[i]+stairs[i-1]);
		}
		
		System.out.println(D[N]);
	}
}
