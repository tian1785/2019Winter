import java.util.Scanner;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num = 667;
		int cnt = 1;
		int Answer = 666;
		while(cnt<N) {
			int tmp = num;
			while(tmp>100) {
				if(tmp%1000 == 666) {
					Answer = num;
					cnt++;
					break;
				}
				tmp = tmp/10;
			}
			
			num++;
		}
		
		System.out.println(Answer);
	}

}
