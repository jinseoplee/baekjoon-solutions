import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (a[i] <= b[j]) {
				sb.append(a[i++]);
			} else {
				sb.append(b[j++]);
			}
			sb.append(" ");
		}

		while (i < n) {
			sb.append(a[i++]).append(" ");
		}

		while (j < m) {
			sb.append(b[j++]).append(" ");
		}

		System.out.println(sb);
	}
}