import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 과목의 개수
		int m = 0; // 최고점
		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int score = Integer.parseInt(st.nextToken());
			sum += score;
			m = Math.max(m, score); // 최고점을 갱신한다.
		}

		System.out.println((sum * 100.0) / m / n);
	}
}