import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_DIFFICULTY = 1_000_000;
	static int n, l, r, x, answer;
	static int[] arr;

	static void select(int cnt, int idx, int min, int max, int sum) {
		if (idx == n) {
			if (cnt >= 2 && l <= sum && sum <= r && max - min >= x) {
				answer++;
			}
			return;
		}

		select(cnt, idx + 1, min, max, sum);
		select(cnt + 1, idx + 1, Math.min(min, arr[idx]), Math.max(max, arr[idx]), sum + arr[idx]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		select(0, 0, MAX_DIFFICULTY, 0, 0);

		System.out.println(answer);
	}
}