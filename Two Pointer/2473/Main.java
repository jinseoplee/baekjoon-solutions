import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		long minDiff = Long.MAX_VALUE;
		long a = 0, b = 0, c = 0; // 세 용액
		for (int i = 0; i < n - 2; i++) { // 첫 번째 용액
			int l = i + 1; // 두 번째 용액
			int r = n - 1; // 세 번째 용액
			while (l < r) {
				long sum = arr[i] + arr[l] + arr[r]; // overflow 조심
				long diff = Math.abs(sum); // 0과 sum의 차이
				if (diff < minDiff) {
					minDiff = diff; // 최소 차이 갱신
					a = arr[i];
					b = arr[l];
					c = arr[r];
				}
				if (sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		
		System.out.println(a + " " + b + " " + c);
	}
}