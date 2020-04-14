package basic;

import java.util.*;
import java.io.*;

public class Main_정올_3106_진법변환2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 지금의 진수
			if (A == 0) break;
			String N = st.nextToken(); // 초기 값
			int B = Integer.parseInt(st.nextToken());

			// 문자열 N을 A진수기준으로 10진수 숫자로 바꾸기
			long change = Long.parseLong(N, A);
			
			// long change를 B진수 문자로 바꾸기
			System.out.println(Long.toString(change, B).toUpperCase());

		}

		br.close();
	}

}