package arraylist;

import java.io.*;
import java.util.*;

// preorder (전위순회) : 루트 -> 왼 -> 오
// inorder (중위순회) : 왼 -> 루트 -> 오
// postorder (후위순회) : 왼 -> 오 -> 루트

// 5 3 11 7 2 8 13 4 1
// 7 2 11 3 13 1 4 8 5

public class Main_정올_1716_이진트리탐색 {

	static int cnt;
	static ArrayList<Integer> tree = new ArrayList<Integer>();

	static class Node {
		int data;
		Node left;
		Node right;

		Node(){
			this(0, null, null);
		}

		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	// 트리 형태로 만들어주기
	public static void add(Node node) {
		if (cnt >= tree.size())
			return;
		if (tree.get(cnt) != -1) {
			node.data = tree.get(cnt++); // -1이 아니면 노드 생성 후 데이터 삽입
			node.left = new Node();
			add(node.left); // 생성된 노드의 좌측도 동일
			node.right = new Node();
			add(node.right); // 생성된 노드의 좌측도 동일
		} else {
			cnt++;
		}
	}

	// 값을 받아오기
	private static void postorder(Node node) {
		if (node == null || node.data == 0)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		// 노드 생성 하기
		// 전위 순회로 값을 받음
		for (int i = 0; i < input.length; i++)
			if(!input[i].equals(""))tree.add(Integer.parseInt(input[i]));

		Node node = new Node();
		
		// 값 넣어주기
		add(node);

		// 하나하나 값 받아오기
		postorder(node);

		br.close();

	}

}
