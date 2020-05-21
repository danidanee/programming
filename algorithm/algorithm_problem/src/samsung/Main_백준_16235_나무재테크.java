package samsung;

import java.io.*;
import java.util.*;

// ArrayList의 2차원 배열로 문제 풀이 - 나이의 기준에 맞게 관리하기
// 매번 정렬하지 말고 규칙성있게 관리 - 나이가 적은 걸 뒤로 오게 관리한다 -> 들어올때마다 미뤄줘야하므로
// Tree라는 클래스를 넣어준다
public class Main_백준_16235_나무재테크 {

	static int N, M, K;
	static int[][] A, map;
	static ArrayList[][] mapTree;
	static int[] dj = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] di = {-1, 0, 1, -1, 1, -1, 0, 1};
 
	static class Tree {

		int age;
		boolean isAlive;

		public Tree(int age) {
			this.age = age;
			this.isAlive = true;
		}

		public Tree(int age, boolean isAlive) {
			this.age = age;
			this.isAlive = isAlive;
		}

		@Override
		public String toString() {
			return "Tree [age=" + age + ", isAlive=" + isAlive + "]";
		}
	}

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
				mapTree[j][i] = new ArrayList<Tree>();
			}
		}

		// 초기에 구입한 나무 정보
		int y, x, age;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			age = Integer.parseInt(st.nextToken());
			mapTree[y][x].add(new Tree(age));
		}

		// 연도
		for (int k = 0; k < K; k++) {

			// 봄
			spring();

			// 여름
			summer();

			// 가을
			fall();

			// 겨울
			winter();

		}

		// 결과 처리
		System.out.println(getCount());

		br.close();

	}



	// 자신의 나이만큼 양분을 먹고 나이가 1씩 증가
	// 어린 나무 부터 양분을 먹고, 자신의 나이만큼 양분이 부족해 먹을 수 없는 나무는 즉시 죽는다.
	private static void spring() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {

				// 할 때마다 값을 가져오지 않기 위해서
				ArrayList<Tree> list = mapTree[j][i];
				int amount = map[j][i]; // 현재 양분

				// 이 칸에 들어있는 나무의 수 만큼 해주기
				for (int s = list.size() - 1; s >= 0; s--) {
					Tree tree = list.get(s);
					// 살 수 있으면
					if (amount >= tree.age) {
						amount -= tree.age;
						tree.age++;
					} else {
						tree.isAlive = false;
					}
				}
				map[j][i] = amount;
			}
		}
	}

	// 봄에 죽은 나무가 양분으로 바뀐다
	// 각각의 죽은 나무마다 나이를 2로 나눈 값이 양분으로 추가, 소수점 아래는 버린다.
	private static void summer() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {

				ArrayList<Tree> list = mapTree[j][i];
				int amount = 0; // 더해질 양분

				// 이번에는 나이가 많은 나무부터 하기
				for (int s = 0; s < list.size(); s++) {
					Tree tree = list.get(s);
					// 살아있는 나무가 있다면 뒤에 있는 나무는 다 살아있다.
					if (tree.isAlive)
						break;
					amount += tree.age / 2;
					// 죽이면 사이즈가 하나 줄어드므로
					list.remove(s--);
				}
				map[j][i] += amount;
			}
		}
	}

	// 나무가 번식하는 번식하는 나무는 5의 배수이어야하며 인접한 8개 칸에 나이가 1인 나무가 생긴다.
	// 땅을 벗어나면 나무가 안생긴다
	private static void fall() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				ArrayList<Tree> list = mapTree[j][i];
				for(int s=0; s<list.size(); s++) {
					Tree tree = list.get(s);
					// 트리의 나이가 5의 배수
					if(tree.age%5 == 0) {
						int dy, dx;
						for(int d=0; d<8; d++) {
							dy = j + dj[d];
							dx = i + di[d];
							if(dy>=0 && dx>=0 && dy<N && dx<N) {
								mapTree[dy][dx].add(new Tree(1));
							}
						}
					}
				}
			}
		}
	}

	// 땅에 양분을 추가한다
	private static void winter() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				map[j][i] += A[j][i];
			}
		}
	}
	
	// 살아있는 나무의 수
	private static int getCount() {
		int count = 0;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				count += mapTree[j][i].size();
			}
		}		
		return count;
	}

}
