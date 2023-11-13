import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 매일 측정한 온도 입력
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 초기 k일 동안 측정한 온도의 합 계산
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		// k일 동안 온도의 합이 최대가 되는 값을 찾는다.
		int maxSum = sum;
		for (int i = k; i < n; i++) {
			sum -= arr[i - k];
			sum += arr[i];
			if (sum > maxSum) {
				maxSum = sum;
			}
		}

		// 결과 출력
		System.out.println(maxSum);
	}
}