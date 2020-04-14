package basic;

import java.io.*;
import java.util.*;

public class Main_정올_1124_색종이고 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];

		// 입력
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			// 범위에 1을 채워주기
			for (int j = y; j < y + 10; j++) {
				for (int i = x; i < x + 10; i++) {
					paper[j][i] = 1;
				}
			}
		}

		// 연속되는 범위 체크 - column 기준으로
		for (int i = 0; i < 100; i++) {
			int cnt = 0;
			for (int j = 0; j < 100; j++) {
				// 만약 0 이오면 cnt = 0
				if (paper[j][i] == 0)
					cnt = 0;
				// 연속되는 점 체크
				else
					paper[j][i] = ++cnt;
			}
		}
		
		int sum = 100;
		// 가장 큰 범위 계산해주기
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 100; i++) {
				
				// 색칠 된 값일 때만
				if(paper[j][i] != 0) {
					int h = paper[j][i]; // 연속 가능한 최대 높이
					for(int k=i; k<100; k++) {
						 // 색칠 안되있으면 끝내기
						if(paper[j][k] == 0) break;
						// 최대 h 변경
						if(h > paper[j][k]) h = paper[j][k]; 
						 // 넓이 수정
						if(h*(k-i+1) > sum) sum = h*(k-i+1);
					}
				}
				
			}
		}
		
		System.out.println(sum);

		br.close();

	}

}