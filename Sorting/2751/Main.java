import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		// -1000000 ~ 1000000
		boolean[] flag = new boolean[2000001];

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			flag[Integer.parseInt(br.readLine()) + 1000000] = true;
		}

		// Counting Sort
		for (int i = 0; i < 2000001; i++) {
			if (flag[i]) {
				answer.append(i - 1000000).append("\n");
			}
		}

		// 결과 출력
		System.out.println(answer);
	}
}