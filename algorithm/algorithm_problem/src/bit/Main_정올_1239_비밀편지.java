package bit;

import java.io.*;

// 비트를 사용하지 않은 풀이 방식
public class Main_정올_1239_비밀편지 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// A B C D E F G H
		String[] word = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
		
		int N = Integer.parseInt(br.readLine());
		String Input = br.readLine();
		String Result = "";

		for (int i = 0; i < N; i++) {
			
			// 알파벳 순자만큼 하기
			for (int j = 0; j < 8; j++) {
				int cnt = 0;
				// 하나하나 순서 비교
				for (int k = 0; k < 6; k++) {
					if (word[j].charAt(k) == Input.charAt(i * 6 + k)) {
						cnt++;
					}
				}
				if(cnt >= 5) {
					// 아스키 코드 변환
					Result += Character.toString((char)(j+65));
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