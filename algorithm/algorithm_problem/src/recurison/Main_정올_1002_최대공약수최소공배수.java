package recurison;

import java.io.*;
import java.util.*;

public class Main_정올_1002_최대공약수최소공배수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int now = Integer.parseInt(st.nextToken());
		int gcd = now;
		int lcm = now;
		
		for (int i=1; i < N; i++) {
			now = Integer.parseInt(st.nextToken());
		    gcd = gcd_get(gcd, now);
		    
		    // 두 수 a,b가 있다면
		    // a*b = gdc(a,b) * lcm(a,b)
		    lcm = lcm * now / gcd_get(lcm, now);
		}
		
		System.out.println(gcd+ " "+ lcm);

		br.close();

	}

	// 두 수의 최대 공약수 구하기
	// 유클리드 호제
	// gdc(a, b) = gdc(b, b%a)
	// 이 함수에서의 b는 나머지
	private static int gcd_get(int a, int b) {
		
		// 나머지가 0이면 a가 최대공약수이다
		if (b == 0) return a;
		return gcd_get(b, a%b);
	}

}