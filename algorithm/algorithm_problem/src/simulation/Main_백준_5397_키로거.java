package simulation;

import java.io.*;
import java.util.*;

public class Main_백준_5397_키로거 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			Stack<Character> pre_stack = new Stack<>();
			Stack<Character> post_stack = new Stack<>();
			
			String Input = br.readLine();
			int len = Input.length();
			for(int i=0; i<len; i++) {
				
				switch (Input.charAt(i)) {
				case '<':
					if(!pre_stack.isEmpty())
						post_stack.add(pre_stack.pop());
					break;
				case '>':
					if (!post_stack.isEmpty())
						pre_stack.add(post_stack.pop());
					break;
				case '-':
					if(!pre_stack.isEmpty())
						pre_stack.pop();
					break;
				default:
					pre_stack.add(Input.charAt(i));
					break;
				}
			}
			
			for(int i=0; i<pre_stack.size(); i++) sb.append(pre_stack.get(i));
			while(!post_stack.isEmpty()) sb.append(post_stack.pop());
			
			sb.append("\n");
		}
		
		System.out.println(sb);

		br.close();
	}

}