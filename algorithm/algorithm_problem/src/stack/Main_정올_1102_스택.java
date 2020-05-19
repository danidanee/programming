package stack;

import java.io.*;
import java.util.*;

public class Main_정올_1102_스택 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<String> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			// 입력
			if(input.equals("i")) {
				stack.push(st.nextToken());
			}
			// 출력
			else if(input.equals("o")) {
				if(stack.isEmpty()) System.out.println("empty");
				else System.out.println(stack.pop());
			}
			// 데이터의 수
			else {
				System.out.println(stack.size());
			}
		}
		
		br.close();
	}

}
