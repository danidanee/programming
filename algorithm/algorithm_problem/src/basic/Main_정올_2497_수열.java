package basic;

import java.io.*;
import java.util.*;

public class Main_정올_2497_수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];

		int sum = 0;

		st = new StringTokenizer(br.readLine());

		// 시작값 구해주기
		for (int i = 0; i < day; i++) {
			int now = Integer.parseInt(st.nextToken());
			temp[i] = now;
			sum += now;
		}

		// 연속값의 최댓값를 구하기
		int max = sum;
		for (int i = day; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			temp[i] = now;
			sum = sum + now - temp[i - day];  // 앞의 값은 빼주기
			if (sum > max)
				max = sum;
		}

		System.out.println(max);

		br.close();

	}

}