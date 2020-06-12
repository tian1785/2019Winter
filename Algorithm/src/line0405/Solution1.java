package line0405;

import java.util.Scanner;
import java.util.Stack;

public class Solution1 {

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String inputString = s.nextLine();
		
		int answer = 0;
		
		int[] bn = new int[4];
		boolean isEnd = false;
		
		for(int i=0, len=inputString.length(); i<len; i++) {
			
			
			if(isEnd) break;
			
			switch (inputString.charAt(i)) {
			case '(':
				bn[0]++;
				break;
			case '{':
				bn[1]++;
				break;
			case '[':
				bn[2]++;
				break;
			case '<':
				bn[3]++;
				break;
			case ')':
				if(bn[0]>0) {
					bn[0]--;
					answer++;
				}else {
					answer = -1;
					isEnd = true;
				}
				break;
			case '}':
				if(bn[1]>0) {
					bn[1]--;
					answer++;
				}else {
					answer = -1;
					isEnd = true;
				}
				break;
			case ']':
				if(bn[2]>0) {
					bn[2]--;
					answer++;
				}else {
					answer = -1;
					isEnd = true;
				}
				break;
			case '>':
				if(bn[3]>0) {
					bn[3]--;
					answer++;
				}else {
					answer = -1;
					isEnd = true;
				}
				break;
			}
		}
		
		
		if(!isEnd) {
			for(int i=0; i<4; i++) {
				if(bn[i]>0) {
					answer = -1;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
