package n과m;

import java.io.*;
import java.util.*;

public class Main_정올_1175_주사위던지기2 {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 주사위 수
		M = Integer.parseInt(st.nextToken()); // 합
		
		int[] arr = new int[N];
		permutation(arr, 0, 0);
		
		br.close();
		
	}

	// 값을 넣어두는 배열, 합, 몇번째인지
	private static void permutation(int[] arr, int sum, int cnt) {
		
		// 만약 10보다 크면 계산 안하기
		if(sum > M) return;
		
		// 다 돌리고
		if(cnt == N) {
			// 합이 M일 때
			if(sum == M) {
				for(int i=0; i<N; i++)
					System.out.print(arr[i] + " ");
				System.out.println();
			}
			return;
		}
		
		for(int i=1; i<=6; i++) {
			arr[cnt] = i;
			permutation(arr, sum+i, cnt+1);
		}
		
	}
}
