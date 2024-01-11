import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 방의 개수
			int m = Integer.parseInt(st.nextToken()); // 비밀통로의 개수

			// 최단 거리 테이블 초기화
			int[][] dist = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = (i == j) ? 0 : 100000;
				}
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dist[a][b] = dist[b][a] = c; // 양방향
			}

			// 플로이드 워셜 알고리즘
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}

			int k = Integer.parseInt(br.readLine()); // 친구의 수
			int[] friend = new int[k];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				friend[i] = Integer.parseInt(st.nextToken());
			}

			int min = 100000, no = 0;
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int j = 0; j < k; j++) {
					sum += dist[friend[j]][i];
				}
				if (sum < min) {
					min = sum;
					no = i;
				}
			}
			answer.append(no).append("\n");
		}
		System.out.println(answer);
	}
}