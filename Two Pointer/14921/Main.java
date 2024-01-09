import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 투 포인터 알고리즘
		int s = 0;
		int e = n - 1;
		int min = Integer.MAX_VALUE; // 0에 가장 가까운 특성 값
		while (s < e) {
			int sum = arr[s] + arr[e];
			if (Math.abs(sum) <= Math.abs(min)) {
				min = sum;
			}
			if (sum < 0) {
				s++;
			} else {
				e--;
			}
		}
		System.out.println(min);
	}
}