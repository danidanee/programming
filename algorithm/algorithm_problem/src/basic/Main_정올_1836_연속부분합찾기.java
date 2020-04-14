package basic;

import java.io.*;
import java.util.*;

public class Main_정올_1836_연속부분합찾기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
	
		int sum = 0;
		int result = 0; // 최솟값 부분합이므오 아무것도 선택안하는 0 가능
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			int now = Integer.parseInt(st.nextToken()); // 입력값
			
			// 더했을 때 0 보다 커야 값이 점점 커진다
			// 따라서 0 보다 작으면 부분합이라 0이 가능하므로 0으로 바꿔준다
			if(sum + now > 0) sum += now;
			else sum = 0;
			
			// 더 클때 값으로 등록
			if(sum > result) result = sum;
		}
		
		System.out.println(result);
		
		br.close();
	
	}

}