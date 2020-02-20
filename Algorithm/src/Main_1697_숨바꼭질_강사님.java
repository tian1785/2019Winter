import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질_강사님 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[100001]; // 방문배열, 미방문 0, 방문 양수
		q.offer(N);
		visit[N] = 1;
		int next;
		while(q.size()>0) {
			int v = q.poll();
			// 정점 방문
			if (v == K) {
				System.out.println(visit[v]-1);
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
			if (next > 0 && visit[next] == 0) {
				visit[next] = visit[v]+1;
				q.offer(next);
			}
			

			
		}
		
	} // end of main

} // end of class
