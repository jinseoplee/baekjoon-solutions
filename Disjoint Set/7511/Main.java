import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] parent;

	static void makeSet() {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
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
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			sb.append("Scenario ").append(testCase).append(":\n");

			n = Integer.parseInt(br.readLine()); // 유저의 수
			k = Integer.parseInt(br.readLine()); // 친구 관계 수

			makeSet();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int m = Integer.parseInt(br.readLine()); // 미리 구할 쌍의 수
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if (find(u) == find(v)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}