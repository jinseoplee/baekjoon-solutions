import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int minDifference = Integer.MAX_VALUE;
	static boolean[] team; // true: 스타트 팀, false: 링크 팀
	static int[][] s;

	// 스타트 팀과 링크 팀의 능력치 차이를 계산한다.
	static int calcDifference() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (team[i] == team[j]) {
					if (team[i]) {
						start += s[i][j] + s[j][i];
					} else {
						link += s[i][j] + s[j][i];
					}
				}
			}
		}
		return Math.abs(start - link);
	}

	// 스타트 팀과 링크 팀으로 사람들을 나눈다.
	static void divide(int idx) {
		if (idx == n) {
			// 스타트 팀과 링크 팀의 능력치 차이의 최솟값을 구한다.
			minDifference = Math.min(minDifference, calcDifference());
			return;
		}

		team[idx] = true;
		divide(idx + 1);
		team[idx] = false;
		divide(idx + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		team = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0);

		System.out.println(minDifference);
	}
}