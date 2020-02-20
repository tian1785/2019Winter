import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13913_숨바꼭질4_강사님 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[100001]; // 방문배열, 미방문 0, 방문 양수
		int[] path = new int[100001]; // 내 숫자로 오게 된 부모 정점을 저장
		q.offer(N);
		visit[N] = 1;
		path[N] = N;
		int next;
		while(q.size()>0) {
			int v = q.poll();
			// 정점 방문
			if (v == K) {
				System.out.println(visit[v]-1);
				// 경로 출력
				StringBuilder sb = new StringBuilder(v + "");
				while(v != path[v]) { // 루트 일때까지
					sb.insert(0, " ").insert(0, path[v]);
					v = path[v];
				}
				
				System.out.println(sb);
				
//				String result = v + "";
//				while(v != path[v]) { // 루트 일때까지 반복
//					result = path[v] + " " + result;
//					v = path[v];
//				}
//				System.out.println(result);
				break;
			}
//			방문하지 않은 인접정접을 큐에 넣기
			next = v*2;
			if (next < visit.length && visit[next] == 0) {
				visit[next] = visit[v]+1;
				q.offer(next);
			}
			
			next = v+1;
			if (next < visit.length && visit[next] == 0) {
				visit[next] = visit[v]+1;
				q.offer(next);
			}
			next = v-1;
			if (next < visit.length && visit[next] == 0) {
				visit[next] = visit[v]+1;
				q.offer(next);
			}
			

			
		}
		
	} // end of main

} // end of class
