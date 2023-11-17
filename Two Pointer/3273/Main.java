import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int i = 0, j = n - 1, cnt = 0;
		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum == x) {
				i++;
				j--;
				cnt++;
			} else if (sum > x) {
				j--;
			} else {
				i++;
			}
		}

		// 결과 출력
		System.out.println(cnt);
	}
}