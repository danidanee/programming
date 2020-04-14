package bit;

import java.io.*;

public class Main_정올_1239_비밀편지_bit {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// A B C D E F G H
		int[] word = { 0, 15, 19, 28, 38, 38, 41, 53, 58 };

		int N = Integer.parseInt(br.readLine());
		String Input = br.readLine();
		String Result = "";

		for (int i = 0; i < N; i++) {

			// 2진수를 10진수로 변환
			int now = Integer.parseInt(Input.substring(i*6, i*6 + 6), 2);

			// 같은 지 비교
			for (int j = 0; j < 8; j++) {
				
				// xor으로 일치하는 비트의 수
				int xor = now ^ word[j];
				
				// 일치하는 값이 한개 이하
				if ((xor & (xor - 1)) == 0) {
					Result += Character.toString((char) (j + 65));
					break;
				}
			}

			// 만약 만족 못했으면
			if (Result.length() != i + 1) {
				Result = (i + 1) + "";
				break;
			}

		}

		System.out.println(Result);

		br.close();
	}

}
