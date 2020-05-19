package stack;

import java.io.*;
import java.util.*;

public class Main_정올_1141_불쾌한날 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			while (!stack.isEmpty()) {
				// 만약 앞에거가 값이 더 작으면
				if (stack.peek() <= input) {
					stack.pop();
				} else break;
			}
			// 아니면
			cnt += stack.size();
			stack.push(input);
		}

		System.out.println(cnt);
		br.close();
	}
}
