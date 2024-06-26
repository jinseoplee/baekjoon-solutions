import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Seat {
	int r, c, friendCnt, emptyCnt;

	Seat(int r, int c, int friendCnt, int emptyCnt) {
		this.r = r;
		this.c = c;
		this.friendCnt = friendCnt;
		this.emptyCnt = emptyCnt;
	}

	boolean isHigher(Seat other) {
		// 좋아하는 학생이 많을수록 좋다.
		if (this.friendCnt != other.friendCnt) {
			return this.friendCnt > other.friendCnt;
		}
		// 비어있는 칸이 많을수록 좋다.
		if (this.emptyCnt != other.emptyCnt) {
			return this.emptyCnt > other.emptyCnt;
		}
		// 행이 작을수록 좋다.
		if (this.r != other.r) {
			return this.r < other.r;
		}
		// 열이 작을수록 좋다.
		return this.c < other.c;
	}
}

public class Main {
	static final int MAX_N = 20;
	static final int MAX_NUM = 400;
	static final int DIR_NUM = 4;
	static final int EMPTY = 0;

	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	static int n;
	static int[][] classroom = new int[MAX_N][MAX_N];
	static int[] targetNum = new int[MAX_NUM + 1];
	static boolean[][] friends = new boolean[MAX_NUM + 1][MAX_NUM + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n * n; i++) {
			st = new StringTokenizer(br.readLine());

			targetNum[i] = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= 4; j++) {
				int friendNum = Integer.parseInt(st.nextToken());
				friends[targetNum[i]][friendNum] = true;
			}
		}

		// 순서대로 학생의 자리를 정한다.
		for (int i = 1; i <= n * n; i++) {
			findSeat(targetNum[i]);
		}

		// 학생의 만족도를 구한다.
		int ans = getTotalScore();
		System.out.println(ans);
	}

	static void findSeat(int num) {
		Seat best = new Seat(MAX_N, MAX_N, 0, 0);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (classroom[r][c] == EMPTY) {
					Seat curr = getSeat(num, r, c);
					if (curr.isHigher(best)) best = curr;
				}
			}
		}
		classroom[best.r][best.c] = num;
	}

	static Seat getSeat(int num, int r, int c) {
		int friendCnt = 0;
		int emptyCnt = 0;
		for (int dir = 0; dir < DIR_NUM; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (isOutRange(nextR, nextC)) continue;
			if (classroom[nextR][nextC] == 0) emptyCnt++;
			else if (isFriend(num, classroom[nextR][nextC])) friendCnt++;
		}
		return new Seat(r, c, friendCnt, emptyCnt);
	}

	static int getTotalScore() {
		int totalScore = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				totalScore += getScore(r, c);
			}
		}
		return totalScore;
	}

	static int getScore(int r, int c) {
		int cnt = 0;
		for (int dir = 0; dir < DIR_NUM; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (isOutRange(nextR, nextC)) continue;
			if (isFriend(classroom[r][c], classroom[nextR][nextC])) cnt++;
		}
		return (int) Math.pow(10, cnt - 1);
	}

	static boolean isOutRange(int r, int c) {
		return r < 0 || r == n || c < 0 || c == n;
	}

	static boolean isFriend(int num1, int num2) {
		return friends[num1][num2];
	}
}