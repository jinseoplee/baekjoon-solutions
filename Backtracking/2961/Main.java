import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int minDifference = Integer.MAX_VALUE;
	static int[] s, b;

	static void cook(int idx, int sTaste, int bTaste) {
		if (idx == n) {
			// 재료를 하나 이상 선택한 경우에만 처리
			if (sTaste != 1 && bTaste != 0) {
				minDifference = Math.min(minDifference, (int) Math.abs(sTaste - bTaste));
			}
			return;
		}

		// 현재 재료를 선택하지 않는 경우
		cook(idx + 1, sTaste, bTaste);

		// 현재 재료를 선택하는 경우
		cook(idx + 1, sTaste * s[idx], bTaste + b[idx]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		s = new int[n]; // 신맛
		b = new int[n]; // 쓴맛

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		cook(0, 1, 0);

		System.out.println(minDifference);
	}
}