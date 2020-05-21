package samsung;

import java.io.*;
import java.util.*;

// ArrayList의 2차원 배열로 문제 풀이 - 나이의 기준에 맞게 관리하기
// 매번 정렬하지 말고 규칙성있게 관리 - 나이가 적은 걸 뒤로 오게 관리한다 -> 들어올때마다 미뤄줘야하므로
// Tree라는 클래스를 넣어준다
public class Main_백준_16235_나무재테크2 {

	static int N, M, K;
	static int[][] A, map;
	static ArrayList<Integer>[][] mapTree;
	static int[] dj = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] di = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 크기
		M = Integer.parseInt(st.nextToken()); // 초기에 심은 나무의 수
		K = Integer.parseInt(st.nextToken()); // 연도

		map = new int[N][N];
		mapTree = new ArrayList[N][N]; // 나무 정보를 넣어두는 리스트

		// 초기 양분 정보
		A = new int[N][N];
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[j][i] = Integer.parseInt(st.nextToken());
				map[j][i] = 5; // 초기 양분
				mapTree[j][i] = new ArrayList<Integer>();
			}
		}

		// 초기에 구입한 나무 정보
		int y, x, age;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			age = Integer.parseInt(st.nextToken());
			mapTree[y][x].add(age);
		}

		// 연도
		for (int k = 0; k < K; k++) {

			// 봄, 여름
			springAndsummer();

			// 가을
			fallAndwinter();

		}

		// 결과 처리
		System.out.println(getCount());

		br.close();

	}



	// 자신의 나이만큼 양분을 먹고 나이가 1씩 증가
	// 어린 나무 부터 양분을 먹고, 자신의 나이만큼 양분이 부족해 먹을 수 없는 나무는 즉시 죽는다.
	// 봄에 죽은 나무가 양분으로 바뀐다
	// 각각의 죽은 나무마다 나이를 2로 나눈 값이 양분으로 추가, 소수점 아래는 버린다.
	private static void springAndsummer() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {

				// 할 때마다 값을 가져오지 않기 위해서
				ArrayList<Integer> list = mapTree[y][x];
				int amount = map[y][x]; // 현재 양분
				int dead = 0; // 죽는 나무의 양분

				// 이 칸에 들어있는 나무의 수 만큼 해주기
				for (int i = list.size() - 1; i >= 0; i--) {
					int age = list.get(i);
					// 살 수 있으면
					if (amount >= age) {
						amount -= age;
						// 원하는 위치의 값 변경
						list.set(i, age+1);
					} else {
						// 죽은 나무의 식별
						dead += age/2;
						list.remove(i);
					}
				}
				map[y][x] = amount + dead;
			}
		}
	}

	// 나무가 번식하는 번식하는 나무는 5의 배수이어야하며 인접한 8개 칸에 나이가 1인 나무가 생긴다.
	// 땅을 벗어나면 나무가 안생긴다
	// 땅에 양분을 추가한다
	private static void fallAndwinter() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				ArrayList<Integer> list = mapTree[y][x];
				for(int i=0; i<list.size(); i++) {
					int age = list.get(i);
					// 트리의 나이가 5의 배수
					if(age%5 == 0) {
						int dy, dx;
						for(int d=0; d<8; d++) {
							dy = y + dj[d];
							dx = x + di[d];
							if(dy>=0 && dx>=0 && dy<N && dx<N) {
								mapTree[dy][dx].add(1);
							}
						}
					}
				}
				// 겨울의 양분 추가하기
				map[y][x] += A[y][x];
			}
		}
	}

	
	// 살아있는 나무의 수
	private static int getCount() {
		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				count += mapTree[y][x].size();
			}
		}		
		return count;
	}

}
