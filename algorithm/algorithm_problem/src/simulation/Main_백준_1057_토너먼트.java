package simulation;

import java.util.*;
import java.io.*;

public class Main_백준_1057_토너먼트 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 토너먼트의 전체 수
		int Kim = Integer.parseInt(st.nextToken()); // 김지민
		int Im = Integer.parseInt(st.nextToken()); // 임한수
		
		/* 
		  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16      8, 9
		   1   2   3   4   5     6     7     8        4, 5
			 1       2        3           4           2, 3
			     1                   2                1, 2
			               1                          1  
		  
		*/
		int cnt = 0;
		while(true) {
			
			cnt++;
			
			// (+1) 해준다음에 /2 해줬을 때 값이 같으면 그 다음 경기에서 만나는 것이다
			Kim = (Kim+1)/2;
			Im = (Im+1)/2;
			
			// 만약 같으면 끝
			if(Kim == Im) break;
		}
		
		System.out.println(cnt);
		
		br.close();
		
	}

}