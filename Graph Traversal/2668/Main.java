import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> selected = new ArrayList<>();

	static void dfs(int start, int next) {
		if (start == arr[next]) {
			selected.add(start);
			return;
		}

		if (!visited[next]) {
			visited[next] = true;
			dfs(start, arr[next]);
			visited[next] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			dfs(i, arr[i]);
			visited[i] = false;
		}

		System.out.println(selected.size());
		for (int num : selected) {
			System.out.println(num);
		}
	}
}