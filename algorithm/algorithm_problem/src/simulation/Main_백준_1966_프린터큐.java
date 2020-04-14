package simulation;

import java.util.*;
import java.io.*;

public class Main_백준_1966_프린터큐 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine());
			int DocN = Integer.parseInt(st.nextToken()); // 문서의 수
			int wantN = Integer.parseInt(st.nextToken()); // 순서를 알기 원하는 위치

			Queue<int[]> q = new LinkedList<>();
			int[] output = new int[DocN];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < DocN; i++) {
				int input = Integer.parseInt(st.nextToken());
				q.add(new int[] { i, input }); // 들어온 순서, 중요도
				output[i] = input;
			}

			// 나오는 순서 정렬
			// 오름차순으로 정렬됨
			Arrays.sort(output);

			// 빠져 나온 만큼 카운드 하기
			int cnt = 1;
			while (true) {
				int[] now = q.poll();
				// 가장 큰 값이랑 지금 값이 같으면 나오기
				if (now[1] == output[DocN - cnt]) {
					
					// 만약 나오는 값이 내가 원하는 순서의 값이면 종료
					if (now[0] == wantN) break;
					cnt++;
					
				}
				// 아직 뺄때가 아니면 다시 넣어주기
				else q.add(now);
			}
			System.out.println(cnt);
		}

		br.close();
	}
}