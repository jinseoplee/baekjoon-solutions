import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, length;
	static int[] exp;

	static void dfs(int idx, int sum) {
		if (sum == n) {
			k--;
			length = idx - 1;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (sum + i <= n && k > 0) {
				exp[idx] = i;
				dfs(idx + 1, sum + i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		exp = new int[n];
		dfs(0, 0);
		if (k != 0) {
			System.out.println(-1);
		} else {
			System.out.print(exp[0]);
			for (int i = 1; i <= length; i++) {
				System.out.print("+" + exp[i]);
			}
		}
	}
}