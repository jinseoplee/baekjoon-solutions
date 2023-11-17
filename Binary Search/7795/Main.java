import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int[] b = new int[m];
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			// 이진 탐색을 위한 정렬 수행
			Arrays.sort(b);

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				// 이진 탐색 수행
				int s = 0;
				int e = m - 1;
				while (s <= e) {
					int mid = (s + e) / 2;
					if (b[mid] < a[i]) {
						s = mid + 1;
					} else {
						e = mid - 1;
					}
				}
				cnt += s;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}