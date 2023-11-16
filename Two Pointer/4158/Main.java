import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0) {
				break;
			}

			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(br.readLine());
			}

			int[] b = new int[m];
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(br.readLine());
			}

			int i = 0;
			int j = 0;
			int cnt = 0;
			while (i < n && j < m) {
				if (a[i] == b[j]) {
					i++;
					j++;
					cnt++;
				} else if (a[i] > b[j]) {
					j++;
				} else if (a[i] < b[j]) {
					i++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}