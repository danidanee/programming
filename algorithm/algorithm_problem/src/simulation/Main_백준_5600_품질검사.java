package simulation;

import java.io.*;
import java.util.*;

public class Main_백준_5600_품질검사 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); // 전원의 수
		int b = Integer.parseInt(st.nextToken()); // 모터의 수
		int c = Integer.parseInt(st.nextToken()); // 케이블 수

		int[] result = new int[a + b + c]; // 결과
		Arrays.fill(result, 2); // 2로 초기화

		int N = Integer.parseInt(br.readLine()); // 검사 횟수
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a_temp = Integer.parseInt(st.nextToken()) - 1; // 전원
			int b_temp = Integer.parseInt(st.nextToken()) - 1; // 모터
			int c_temp = Integer.parseInt(st.nextToken()) - 1; // 케이블
			int breakdown = Integer.parseInt(st.nextToken()); // 고장 여부

			// 고장난 게 아니면
			if (breakdown == 1) {
				result[a_temp] = 1;
				result[b_temp] = 1;
				result[c_temp] = 1;
			} else {
				list.add(new int[] { a_temp, b_temp, c_temp });
			}
		}

		// 값이 변하는게 있는 지 체크
		// 고장인 것들만 있음
		for (int i = 0; i < list.size(); i++) {
			int[] now = list.get(i);
			if (result[now[1]] == 1 && result[now[2]] == 1) {
				result[now[0]] = 0;
			} else if (result[now[0]] == 1 && result[now[2]] == 1) {
				result[now[1]] = 0;
			} else if (result[now[0]] == 1 && result[now[1]] == 1) {
				result[now[2]] = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<a+b+c; i++)
			sb.append(result[i] + "\n");
		
		System.out.println(sb);

		br.close();
	}

}