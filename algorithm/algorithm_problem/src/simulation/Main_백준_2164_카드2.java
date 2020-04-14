package simulation;

import java.io.*;
import java.util.*;

public class Main_백준_2164_카드2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(true) {
			
			// 하나만 남았을 때 끝내기
			// 처음 들어온게 1개 일 수 있기에 위에 두기
			if(q.size() == 1) break;
			
			// 2개 이상 있으면 처음 값 빼기
			q.poll();
			
			// 하나를 빼서 1개면 종료
			if(q.size() == 1) break;
			
			// 처음값을 제일 마지막에 넣기
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
		
		br.close();

	}
}