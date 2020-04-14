package recurison;

import java.io.*;

public class Main_정올_1161_하노이탑 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		hanoi(N, 1, 3);

		br.close();

	}

	// n개의 원반을 s기둥에서 e 기둥으로 이동하는 함수
	private static void hanoi(int n, int s, int e) {

		// 원반이 없으면 종료
		if (n <= 0) return;
		
		// n-1개를 빈기둥으로 이동
		// 6은 원기둥 1,2,3의 합
		// 빈 기둥은 출발지와 도착지를 빼서 구하기
		hanoi(n - 1, s, 6 - s - e);
		
		// n번 원반 이동
		System.out.println(n + " : " + s + " -> " + e);
		
		// n-1개를 빈기둥에서 이동
		hanoi(n - 1, 6 - s - e, e);
	}

}
