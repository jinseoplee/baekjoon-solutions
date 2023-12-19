import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, Q;
	static int[][] prefixSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		// 입력 처리
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		// 평균을 구하기 위해서는 밝기의 합이 필요하다.
		// 누적 합을 미리 밝기의 합을 구한다.
		prefixSum = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1]
						+ Integer.parseInt(st.nextToken());
			}
		}

		// (r1, c1)과 (r2, c2)를 꼭짓점으로 하는 직사각형의 밝기 평균을 구한다.
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
			int sum = prefixSum[r2][c2] - prefixSum[r2][c1 - 1] - prefixSum[r1 - 1][c2] + prefixSum[r1 - 1][c1 - 1];
			answer.append(sum / cnt).append("\n");
		}

		// 결과 출력
		System.out.println(answer);
	}
}