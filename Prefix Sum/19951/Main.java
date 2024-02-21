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

		int[] arr = new int[n + 1]; // 연병장 각 칸의 높이를 저장하는 배열
		int[] sum = new int[n + 2]; // 누적 합

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 조교의 지시를 입력받는다.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			sum[a] += k;
			sum[b + 1] += -k;
		}

		// 모든 지시를 수행한 뒤 연병장 각 칸의 높이를 구한다.
		for (int i = 1; i <= n; i++) {
			sum[i] += sum[i - 1];
			sb.append(sum[i] + arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}