package recurison;

import java.io.*;
import java.util.*;

public class Main_정올_2498_공약수 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long gcd = Integer.parseInt(st.nextToken());
		long lcm = Integer.parseInt(st.nextToken());
		
		long[] min = new long[3];
		min[0] = 200000000;
		
		double max = Math.sqrt(lcm);
		
		// i는 gcd의 배수이다
		for(long i=gcd; i<max; i+= gcd) {
			
			// lcm * gcd = i * j
			long j = lcm * gcd / i;
			
			// 최대공약수, 최대공배수 확인
			if(lcm % i == 0 && get_gcd(j, i) == gcd) {
				// 두 값의 차가 최소인 경우 구하기
				if(min[0] > Math.abs(j - i)) {
					min[0] = Math.abs(j - i);
					min[1] = i;
					min[2] = j;
				}
			}
		}
		
		System.out.println(min[1] + " " + min[2]);
		
		br.close();
	}

	// 최소 공배수 구하기
	private static long get_gcd(long a, long b) {
		if(b == 0) return a;
		return get_gcd(b, a%b);
	}

}