import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int i = 0, j = 0, sum = arr[0], cnt = 0;
		while (i < n && j < n) {
			if (sum == m) {
				cnt++;
				sum += arr[++j];
			} else if (sum < m) {
				sum += arr[++j];
			} else {
				sum -= arr[i++];
			}
		}
		System.out.println(cnt);
	}
}