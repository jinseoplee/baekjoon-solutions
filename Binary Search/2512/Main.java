import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] request = new int[n];
		int left = 1, mid = 0, right = 0, sum = 0;

		for (int i = 0; i < n; i++) {
			request[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, request[i]);
		}

		while (left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			for (int i = 0; i < n; i++) {
				sum += Math.min(request[i], mid);
			}
			if (sum > m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(right);
	}
}