import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static String result = "NO";
	static char[][] map;
	static ArrayList<Teacher> teachers = new ArrayList<>();

	static class Teacher {
		int r, c;

		Teacher(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	// 모든 학생들이 선생님들의 감시를 피할 수 있는지 확인한다.
	static boolean isPossible() {
		for (Teacher t : teachers) {
			int nextR = t.r;
			int nextC = t.c;
			for (int dir = 0; dir < 4; dir++) {
				while (true) {
					nextR += dr[dir];
					nextC += dc[dir];
					if (!inRange(nextR, nextC) || map[nextR][nextC] == 'O') break;
					if (map[nextR][nextC] == 'S') return false;
				}
				nextR = t.r;
				nextC = t.c;
			}
		}
		return true;
	}

	// 3개의 장애물을 설치한다.
	static void setObstacle(int start, int cnt) {
		if (cnt == 3) {
			if (isPossible()) {
				result = "YES";
			}
			return;
		}

		for (int i = start; i < n * n; i++) {
			int r = i / n;
			int c = i % n;
			if (map[r][c] == 'X') {
				map[r][c] = 'O';
				setObstacle(i + 1, cnt + 1);
				map[r][c] = 'X';
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					teachers.add(new Teacher(i, j));
				}
			}
		}

		setObstacle(0, 0);

		System.out.println(result);
	}
}