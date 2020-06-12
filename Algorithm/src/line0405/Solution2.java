package line0405;


public class Solution2 {

	public static void main(String[] args) {

		System.out.println(solution("4132315142", new String[]{"3241523133","4121314445","3243523133","4433325251","2412313253"}));
		System.out.println(solution("53241", new String[]{"53241", "42133", "53241", "14354"}));
		System.out.println(solution("24551", new String[]{"24553", "24553", "24553", "24553"}));

	}

	public static int solution(String answer_sheet, String[] sheets) {
		int answer = 0;
		int snum = sheets.length;
		
		// char 배열로 변환
		char[] as = answer_sheet.toCharArray();
		char[][] ss = new char[snum][];
		
		for(int i=0; i<snum; i++) {
			ss[i] = sheets[i].toCharArray();
		}
		
		// 비교하기		
		for(int i=0; i<snum-1; i++) {
			for(int j=i+1; j<snum; j++) {
				int pn = 0;
				int lpn = 0;
				int tmplpn = 0;
				boolean prior = false;
				
				// 정답시트와 두 시트 비교하기
				for(int k=0, kn=as.length; k<kn; k++) {
					if(ss[i][k] == ss[j][k] && ss[i][k]!=as[k]) {
						// 의심 문항이면
						pn++;
						
						if(prior) {
							tmplpn++;
						}else {
							tmplpn = 1;
						}
						prior = true;
					}else {
						//의심 문항이 아니면
						if(lpn<tmplpn) lpn = tmplpn;
						prior = false;
					}
				}
				if(lpn<tmplpn) lpn = tmplpn;
				
				int tmpanswer = pn + lpn*lpn;
				
				if(answer<tmpanswer) {
					answer = tmpanswer;
				}
				
			}
		}
		
		return answer;
	}

}
