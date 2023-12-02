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

		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		// 인출하는데 걸리는 시간을 오름차순으로 정렬한다.
		Arrays.sort(time);

		// 각 사람이 돈을 인출하는 데 필요한 시간을 구한다.
		for (int i = 1; i < n; i++) {
			time[i] += time[i - 1];
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += time[i];
		}

		// 결과 출력
		System.out.println(sum);
	}
}