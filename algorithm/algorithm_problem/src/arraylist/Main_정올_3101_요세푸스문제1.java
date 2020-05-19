package arraylist;

import java.io.*;
import java.util.*;

public class Main_정올_3101_요세푸스문제1 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) list.add(i);
		
		// 1 2 3 4 5 -> 3, now=2
		// 1 2 4 5 -> 1, now=0
		// 2 4 5 -> 5, now=3 
		// 2 4 -> 2, now=0
		// 4 -> 4, now=1
		
		int now = k;
		while(!list.isEmpty()) {
			// 현재 값은 나누기로 구해주기 - 값을 넘어갈 수 있으므로
			// 값이 하나씩 삭제되므로 -1 해서 구해주기
			now = (now-1)%list.size();
			// 현재 값 구하고 제거하기
			sb.append(list.get(now) + " ");
			list.remove(now);
			// 현재 값에서 다음 노드만큼 더하기
			now += k;
		}
		
		System.out.println(sb);
		
		br.close();
		
	}

}
