import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder result = new StringBuilder();
	static Node[] tree = new Node[26]; // 'A' ~ 'Z'

	static class Node {
		char ch;
		int left, right;

		Node(char ch, int left, int right) {
			this.ch = ch;
			this.left = left;
			this.right = right;
		}
	}

	// 전위 순회
	static void preorder(int idx) {
		result.append(tree[idx].ch); // 루트
		if (tree[idx].left != -19) preorder(tree[idx].left); // 왼쪽
		if (tree[idx].right != -19) preorder(tree[idx].right); // 오른쪽
	}

	// 중위 순회
	static void inorder(int idx) {
		if (tree[idx].left != -19) inorder(tree[idx].left); // 왼쪽
		result.append(tree[idx].ch); // 루트
		if (tree[idx].right != -19) inorder(tree[idx].right); // 오른쪽
	}

	// 후위 순회
	static void postorder(int idx) {
		if (tree[idx].left != -19) postorder(tree[idx].left); // 왼쪽
		if (tree[idx].right != -19) postorder(tree[idx].right); // 오른쪽
		result.append(tree[idx].ch); // 루트
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 노드의 개수
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			tree[input[0] - 'A'] = new Node(input[0], input[2] - 'A', input[4] - 'A');
		}

		preorder(0);
		result.append("\n");
		inorder(0);
		result.append("\n");
		postorder(0);

		System.out.println(result);
	}
}