package samsung;

import java.io.*;
import java.util.*;

// 최단 경로 : 간선이 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에 간선의 가중치의 합이 최소인 경로
// 하나의 시작 정점에서 끝 정점까지의 최단 경로
// 	- 다익스트라 알고리즘 : 음의 가중치를 허용하지 않음
//		- 시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
// 		- 탐욕기법(최적해)을 사용한 MST의 프림 알고리즘과 유사
//		- 정점 : 인접행렬(간선의 수 많을 때), 인접리스트(빈곳이 많을 때)
//	- 벨만-포드 알고리즘 : 음의 가중치 허용
// 모든 정점들에 대한 최단 경로 : 플로이드-워샬 알고리즘
public class Main_백준_1238_파티 {

	static int N, M, X;
	static Node[] adjList; // 간선 정보가 생길때마다 앞으로 집어넣기

	static class Node {

		int no, weight; // 노드 번호, 가중치
		Node next;

		public Node(int no, int weight, Node next) {
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
	}
	
	// PriorityQueue에 들어가는 값
	static class Point implements Comparable<Point>{

		// 정점, 시간
		int v, time;
		
		public Point(int v, int time) {
			this.v = v;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			// 작은 수부터 순서대로
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생의 수
		M = Integer.parseInt(st.nextToken()); // 도로의 수
		X = Integer.parseInt(st.nextToken())-1; // 도착점

		adjList = new Node[N];
		
		// 도로의 수 입력
		int x, y, t;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1; // 시작
			y = Integer.parseInt(st.nextToken()) - 1; // 끝
			t = Integer.parseInt(st.nextToken()); // 소요 시간
			// 앞으로 넣기
			adjList[x] = new Node(y,t,adjList[x]);
		}

		// 다익스트라 (인접이스트 + PQ) 시간복잡도 O((V+E)logV)
		int max = 0, temp = 0;
		for(int i=0; i<N; i++) {
			if(i == X) continue;
			// i 가는 마을
			// 파티하러 갈 때
			temp = go(i, X);
			// 파티하고 올 때
			temp += go(X,i);
			if(max<temp) max = temp;
		}
		
		System.out.println(max);

		br.close();
	}

	// 다익스트라 코드
	private static int go(int start, int end) {
		
		// 출발지에서 모든 정점지 거리 배열
		int[] D = new int[N];
		
		// 다 못온다고 생각하고 최댓값으로 채우기
		Arrays.fill(D, Integer.MAX_VALUE);
		
		// 처리된 정점 처리
		boolean[] visited = new boolean[N];
		
		// 시작점 처리
		D[start] = 0;
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(start, 0));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll(); // 최소 거리 정점 선택
			// 이미 간 점은 안가기
			if(visited[cur.v]) continue;
			visited[cur.v] = true;
			if(cur.v == end) return cur.time;
			
			// 현 정점을 경유지로 해서 다른 정점들 비용 갱신
			for(Node temp = adjList[cur.v]; temp != null; temp=temp.next) {
				// 여기까지 올때 걸린 시간이랑 가는 시간을 합친게 더 작을 때
				if(!visited[temp.no] && D[temp.no] > cur.time + temp.weight) {
					D[temp.no] = cur.time + temp.weight;
					queue.offer(new Point(temp.no, D[temp.no]));
				}
			}
		}
		return 0;
	}

}
