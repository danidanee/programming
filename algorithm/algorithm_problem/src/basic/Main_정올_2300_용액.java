package basic;

import java.io.*;
import java.util.*;

public class Main_정올_2300_용액 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] liquid = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		// 처음과 마지막 수를 더해서
		// 양수 : -10 + 98 = 88 더 이상 작은 수가 없어 더 작은 경우의 수가 안 만들어지므로 제일 큰 수 빼기
		// 음수 : -99 + 98 = -1 더 이상 큰 수가 없어 더 작은 경우의 수가 안 만들어지므로 제일 작은 수 빼기
		int min_index = 0;
		int max_index = N - 1;

		long min = liquid[0];
		long max = liquid[N - 1];

		long calc = 2000000000;

		while (min_index < max_index) {

			long sum = liquid[min_index] + liquid[max_index];

			// 만약 두개의 합의 절댓값이 최솟값이면
			if (Math.abs(sum) < calc) {
				calc = Math.abs(sum);
				min = liquid[min_index];
				max = liquid[max_index];
			}

			// 더한 값이 양수이면
			if (sum > 0)
				max_index--;
			// 더한 값이 음수이면
			else if (sum < 0)
				min_index++;
			// 더한 값이 0이면
			else
				break;

		}

		System.out.println(min + " " + max);

		br.close();

	}

}