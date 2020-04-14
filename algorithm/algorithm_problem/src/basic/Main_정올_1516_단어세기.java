package basic;

import java.io.*;
import java.util.*;

public class Main_정올_1516_단어세기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String[] array = br.readLine().split(" ");
			if(array[0].equals("END")) break;
			
			// 정렬하기
			Arrays.sort(array);
			
			int len = array.length;
			int cnt = 1;
			
			for(int i=1; i<len; i++) {
				// 만약 이전 값이랑 같으면
				if(array[i].equals(array[i-1])) {
					cnt++;
				}
				// 다르면 출력하고 초기화
				else {
					System.out.println(array[i-1] + " : " + cnt);
					cnt = 1;
				}
			}
			
			System.out.println(array[len-1] + " : " + cnt);
		}
	}

}