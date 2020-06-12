package line0405;

import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args)  {
		solution("111011110011111011111100011111",3);
	}
	
	public static int solution(String road, int n) {
        int answer = -1;
        char current = road.charAt(0);
        int zeronum = 0;
        if(current =='0') zeronum = 1;
        int idx = 1;
        int cnt = 0;
        
        for(int i=1, l=road.length(); i<l; i++) {
        	char now = road.charAt(i);
        	if(now == current) {
        		cnt++;
        	}else {
        		cnt = 0;
        		current = now;
        		idx++;
        	}
        	if(now == '0') zeronum++;
        }
        int[] numbers = new int[idx];
        int[] check = new int[idx];
        
        cnt = 1;
        idx =0;
        for(int i=1, l=road.length(); i<l; i++) {
        	char now = road.charAt(i);
        	if(now == current) {
        		cnt++;
        	}else {
        		numbers[idx] = cnt;
        		cnt = 1;
        		check[idx] = current - '0';
        		current = now;
        		idx++;
        	}
        }
        numbers[idx] = cnt;
        check[idx] = current - '0';
        
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(Arrays.toString(check));
        
        int start = 0;
        int zero;
        if (check[0]==0)  {
        	start = 1;
        	
        }
        
        int[] zerocnt = new int[zeronum];
        //greedy
        for(int i=start; i<numbers.length; i++) {
        	
        }
        
        return answer;
    }
	
//	private static boolean nextPermutation() {
//		int i = N - 1;
//		while (i > 0 && tmp[i - 1] >= tmp[i])
//			--i;
//		if (i == 0)
//			return false;
//		int j = N - 1;
//		while (tmp[i - 1] >= tmp[j])
//			--j;
//		swap(i - 1, j);
//		j = N - 1;
//		while (i < j) {
//			swap(i++, j--);
//		}
//		cnt++;
//		return true;
//	}
//
//	public static void swap(int i, int j) {
//		int t;
//		t = tmp[i];
//		tmp[i] = tmp[j];
//		tmp[j] = t;
//	}
}
