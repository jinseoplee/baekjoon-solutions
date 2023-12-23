import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] tree = new int[n];
		int left = 1, right = 0, mid = 0;
		long sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, tree[i]);
		}

		while (left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			for (int i = 0; i < n; i++) {
				if (tree[i] > mid) {
					sum += tree[i] - mid;
				}
			}
			if (sum >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}