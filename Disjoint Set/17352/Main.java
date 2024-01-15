import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
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
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		makeSet();

		for (int i = 0; i < n - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		for (int i = 1; i <= n; i++) {
			if (find(i) != find(i + 1)) {
				System.out.println(i + " " + (i + 1));
				break;
			}
		}
	}
}