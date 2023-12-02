import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 오름차순 정렬 수행
		Arrays.sort(arr);

		// 결과 출력
		for (int i = 0; i < n; i++) {
			answer.append(arr[i]).append("\n");
		}
		System.out.println(answer);
	}
}