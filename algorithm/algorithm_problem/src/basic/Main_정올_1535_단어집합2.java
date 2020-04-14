package basic;

import java.util.*;
import java.io.*;

public class Main_정올_1535_단어집합2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받는 것을 넣을 list
		ArrayList<String> list = new ArrayList<>();

		while(true) {
			// " " 기준으로 분리하기
			String[] temp = br.readLine().split(" ");
			
			// 입력받은 값이 END 이면 종료
			if(temp[0].equals("END")) break;
			
			// 이미 있는 값 출력
			for(int i=0; i<list.size(); i++) System.out.print(list.get(i) + " ");
			
			for(int i=0; i<temp.length; i++) {
				if(!list.contains(temp[i])) {
					list.add(temp[i]);
					System.out.print(temp[i] + " ");
				}
			}
			
			System.out.println();
		}
		
		br.close();
		
	}

}