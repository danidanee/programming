package queue;

import java.io.*;
import java.util.*;

public class Main_정올_1697_큐 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<String> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			// 입력
			if(input.equals("i")) {
				queue.add(st.nextToken());
			}
			// 출력
			else if(input.equals("o")) {
				if(queue.isEmpty()) System.out.println("empty");
				else System.out.println(queue.poll());
			}
			// 데이터의 수
			else {
				System.out.println(queue.size());
			}
		}
		
		br.close();
		
	}

}
