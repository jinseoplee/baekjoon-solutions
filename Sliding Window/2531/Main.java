import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] belt = new int[n];
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int[] types = new int[d + 1];
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (types[belt[i]]++ == 0) cnt++;
		}

		int ans = types[c] == 0 ? cnt + 1 : cnt;
		for (int i = k; i < n + k - 1; i++) {
			if (types[belt[i % n]]++ == 0) cnt++;
			if (--types[belt[i - k]] == 0) cnt--;
			ans = Math.max(ans, types[c] == 0 ? cnt + 1 : cnt);
		}
		System.out.println(ans);
	}
}