package line0405;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class Solution4 {

	public static void main(String[] args) {
		
		
		String[][] returns = solution(
				new String[][] {{"ACCOUNT2", "150"},{"ACCOUNT1", "100"}}
				, new String[][] {
					{"1", "SAVE", "ACCOUNT2", "100"},
					{"2", "WITHDRAW", "ACCOUNT1", "50"},
					{"1", "SAVE", "ACCOUNT2", "100"},
					{"4", "SAVE", "ACCOUNT3", "500"},
					{"3", "WITHDRAW", "ACCOUNT2", "30"}
				});
		
		
		for(int i=0; i<returns.length; i++) {
			System.out.println(returns[i][0]+" "+returns[i][1]);
		}
	}
	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		HashMap<String, Integer> account = new HashMap<>();
		for(int i=0, l=snapshots.length; i<l; i++) {
			account.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		boolean[] check = new boolean[100000];
		
		for(int i=0,l=transactions.length; i<l; i++) {
			String[] t = transactions[i];
			int tid = Integer.parseInt(t[0]);
			if(check[tid]) continue;
			
			if(t[1].equals("SAVE")) {
				if(account.containsKey(t[2])) {
					account.put(t[2],account.get(t[2])+Integer.parseInt(t[3]));
				}else {
					account.put(t[2], Integer.parseInt(t[3]));
				}
			}else {
				account.put(t[2],account.get(t[2])-Integer.parseInt(t[3]));
			}
			
			check[tid] = true;
		}
		

		String[][] answer = new String[account.size()][];
    	
        int index = 0;
        for(String key : account.keySet()) {
        	answer[index] = new String[2];
        	answer[index][0] = key;
        	answer[index][1] = account.get(key).toString();
        	index++;
        }
        
        Arrays.sort(answer, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return o1[0].compareTo(o2[0]);
			}
		});
        
        return answer;
    }
}
