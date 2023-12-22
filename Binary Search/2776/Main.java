import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] note1, note2;

	static int findNumber(int target) {
		int startIdx = 0;
		int endIdx = n - 1;
		while (startIdx <= endIdx) {
			int middleIdx = (startIdx + endIdx) / 2;
			if (note1[middleIdx] == target) {
				// 성공 시 1을 반환
				return 1;
			} else if (note1[middleIdx] < target) {
				startIdx = middleIdx + 1;
			} else {
				endIdx = middleIdx - 1;
			}
		}
		// 실패 시 0을 반환
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			// 노트 1 입력 처리
			n = Integer.parseInt(br.readLine());
			note1 = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}

			// 이진 탐색을 위한 정렬 수행
			Arrays.sort(note1);

			// 노트 2 입력 처리
			m = Integer.parseInt(br.readLine());
			note2 = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				note2[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < m; i++) {
				answer.append(findNumber(note2[i])).append("\n");
			}
		}
		System.out.println(answer);
	}
}