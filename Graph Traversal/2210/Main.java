import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[5][5];

	// 중복된 수를 제거하기 위해 집합을 이용한다.
	static Set<Integer> numbers = new HashSet<>();

	// 상, 하, 좌, 우
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < 5 && 0 <= c && c < 5;
	}

	static void dfs(int r, int c, int cnt, int number) {
		// 여섯 자리의 수를 만든 경우
		if (cnt == 6) {
			// numbers 집합에 number를 추가한다.
			numbers.add(number);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (inRange(nextR, nextC)) {
				dfs(nextR, nextC, cnt + 1, number * 10 + board[nextR][nextC]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 숫자판 초기화
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// dfs를 이용하여 만들 수 있는 수들을 구한다.
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				dfs(r, c, 1, board[r][c]);
			}
		}

		// 만들 수 있는 수들의 개수를 출력한다.
		System.out.println(numbers.size());
	}
}