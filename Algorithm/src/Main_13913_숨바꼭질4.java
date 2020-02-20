import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {

	private static int N;
	private static int K;
	private static int visit[];
	private static int Time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new int[100001];
		Arrays.fill(visit, -1);
		
		bfs();
		
		System.out.println(Time);
//		sb.append(Time).append("\n");
		int cur = K;
//		ArrayList<Integer> tmp = new ArrayList<>();
		while(cur>0) {
//			System.out.print(cur + " ");
//			tmp.add(cur);
			sb.insert(0, " ").insert(0, cur);
			cur = visit[cur];
		}
//		System.out.println();
//		for(int i=tmp.size()-1; i>=0; i--) {
//			System.out.print(tmp.get(i)+" ");
//			sb.append(tmp.get(i)).append(" ");
//		}
		
		System.out.println(sb.toString());
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		int time = 0;
		visit[N] = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int cur = queue.poll();
				
				if(cur== K-1 || cur==K+1 || cur==2*K) {
					visit[K] = cur;
					Time = time+1;
					return;
				}
 				
				for(int i=0; i<3; i++) {
					int nx = 0;
					switch (i) {
					case 0:
						nx = cur+1;
						break;
					case 1:
						nx = cur-1;
						break;
					case 2:
						nx = cur*2;
						break;

					}
					
					if(nx<0 || nx>100000 || visit[nx]>=0) continue;
					
					visit[nx] = cur;
					queue.offer(nx);
				}
				
			}
			time++;
		}
		
	}

}
