package basic;

import java.util.*;
import java.io.*;

public class Main_정올_3106_진법변환 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {

			StringBuilder sb = new StringBuilder();

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 지금의 진수
			if (A == 0)
				break;
			String N = st.nextToken();
			int B = Integer.parseInt(st.nextToken());

			// 처음 들어온 수를 10진수로 바꿈
			long temp = 1;
			long sum = 0;
			int len = N.length() - 1;
			for (int i = len; i >= 0; i--) {
				long now = N.charAt(i) < 65 ? (N.charAt(i) - 48) : (N.charAt(i) - 55);
				sum += temp * (now);
				temp *= A;
			}

			// 더이상 안 나눠질때까지 진행
			while (true) {

				// 만약 10 이상이면 바꿔주기
				if (sum % B > 9)
					sb.append((char) (sum % B + 55));
				else
					sb.append(sum % B);

				sum /= B;
				if (sum < B) {
					if (sum != 0) {
						if (sum > 9)
							sb.append((char) (sum + 55));
						else
							sb.append(sum);
					}
					break;
				}
			}

			sb.reverse();
			System.out.println(sb);
		}

		br.close();
	}

}