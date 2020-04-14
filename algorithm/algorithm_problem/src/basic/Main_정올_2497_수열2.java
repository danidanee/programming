package basic;

import java.io.*;
import java.util.*;

public class Main_정올_2497_수열2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int[] temp = new int[N+1];

		int sum = 0;
		int max = -100 * N;

		st = new StringTokenizer(br.readLine());

		// 시작값 구해주기
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(st.nextToken());
			temp[i] = now;
			sum += now;

			if (i >= day) {
				sum -= temp[i - day];
				if (sum > max)
					max = sum;
			}
		}

		System.out.println(max);

		br.close();

	}

}