import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] cost;
	static int[] parent;

	static void makeSet() {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (cost[a] > cost[b]) parent[a] = b;
		else parent[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 학생 수
		m = Integer.parseInt(st.nextToken()); // 친구관계 수
		k = Integer.parseInt(st.nextToken()); // 가지고 있는 돈
		cost = new int[n + 1];

		makeSet();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}

		int total = 0;
		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				total += cost[i];
			}
		}
		System.out.println(total <= k ? total : "Oh no");
	}
}