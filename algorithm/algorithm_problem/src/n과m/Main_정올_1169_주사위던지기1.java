package n과m;

import java.io.*;
import java.util.*;

public class Main_정올_1169_주사위던지기1 {

	// 주사위의 수
	static int N; 
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 출력 형식
		
		int[] arr = new int[N];
		boolean[] visit = new boolean[7];
		
		// 모든 경우의 수
		if(M == 1) {
			permutation1(arr, 0);
		}
		// 중복을 제외한 모든 경우의 수
		else if(M == 2) {
			permutation2(arr, 1, 0);
		}
		// 모두 다른 수
		else {
			permutation3(arr, visit, 0);
		}
	
		br.close();
	}


	// 모든 경우의 수
	private static void permutation1(int[] arr, int cnt) {
		
		if(cnt == N) {
			for(int i=0; i<N; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=6; i++) {
			arr[cnt] = i;
			permutation1(arr, cnt+1);
		}
		
	}
	
	// 중복을 제외한 모든 경우의 수
	private static void permutation2(int[] arr, int last, int cnt) {

		if(cnt == N) {
			for(int i=0; i<N; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=last; i<=6; i++) {
			arr[cnt] = i;
			permutation2(arr, i, cnt+1);
		}
		
	}
	
	// 모두 다른 수
	private static void permutation3(int[] arr, boolean[] visit, int cnt) {
		
		if(cnt == N) {
			for(int i=0; i<N; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=6; i++) {
			if(!visit[i]) {
				arr[cnt] = i;
				visit[i] = true;
				permutation3(arr, visit, cnt+1);
				visit[i] = false;
			}
		}
		
	}

}
