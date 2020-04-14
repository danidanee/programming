package bit;

import java.io.*;

public class Main_정올_1274_2진수를10진수호 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		//음수인지 양수인지 체크해준다
		if(input.charAt(0) == '0') {
			System.out.println(Integer.parseInt(input, 2));
		}
		else {
			// 비트를 이용해 1보수로 변환
			int convert = Integer.parseInt(input,2)^255;
			// 2의 보수로 바꾸기 위해 +1 해주고 음수로 다시 바꿔준다
			System.out.println((convert+1)*-1);
		}
		
		br.close();
	}

}