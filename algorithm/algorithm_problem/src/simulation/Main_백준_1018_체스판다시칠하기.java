package simulation;

import java.io.*;
import java.util.*;

public class Main_백준_1018_체스판다시칠하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int ny = Integer.parseInt(st.nextToken());
		int nx = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[ny][nx];
		
		//입력 받기
		for(int j=0; j<ny; j++) {
			String now = br.readLine();
			for(int i=0; i<nx; i++) {
				board[j][i] = now.charAt(i);
			}
		}
		
		int result = (ny*nx)/2; // 최댓값
		
		for(int j=0; j+8<=ny; j++) {
			for(int i=0; i+8<=nx; i++) {
				
				// 처음 기준을 W로 하기
				int cnt = 0;
				for(int a=j; a<j+8; a++) {
					for(int b=i; b<i+8; b++) {
						// 위치 기준으로 홀짝계산
						// 원하는 위치의 값이 아닐때 +1
						if((a+b)%2 == 0) {
							if(board[a][b] != 'W') cnt++;
						}
						else {
							if(board[a][b] != 'B') cnt++;
						}
					}
				}
				
				// 기준을 반대로 했을 때랑 비교
				cnt = cnt<64-cnt?cnt:64-cnt;
				if(cnt<result) result=cnt;
			}
		}
		
		System.out.println(result);
	}
}