import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18232_텔레포트정거장{

	static ArrayList<Integer>[] tele;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		tele = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			tele[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tele[a].add(b);
			tele[b].add(a);
		}
		
		System.out.println(bfs(S,E));
		
	}
	
	private static int bfs(int s, int e) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {s, 0});
		visit[s] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int clocation = current[0];
			
			if(clocation ==e ) return current[1];
			
			
			if(clocation-1>0 && !visit[clocation-1] ) {
				visit[clocation-1] = true;
				queue.offer(new int[] {clocation-1, current[1]+1});
			}
			if(clocation+1<300000 && !visit[clocation+1]) {
				visit[clocation+1] = true;
				queue.offer(new int[] {clocation+1, current[1]+1});
			}
			
			
			for(int i=0, size=tele[clocation].size(); i<size; i++ ) {
				int tmp = tele[clocation].get(i);
				
				if(!visit[tmp] ) {
					visit[tmp] = true;
					queue.offer(new int[] {tmp, current[1]+1});
				}
			}
			
		}
		
		return -1;
	}

}
