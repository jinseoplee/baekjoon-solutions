import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int currX = 0, currY = 0, currDir = 1;

	// 북, 동, 남, 서
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };

	static void turn(int dir) {
		if (dir == 1) {
			currDir = (currDir + 1) % 4; // 시계 방향
		} else {
			currDir = (4 + (currDir - 1)) % 4; // 반시계 방향
		}
	}

	static void move(int d) {
		currX += dx[currDir] * d;
		currY += dy[currDir] * d;
	}

	static boolean inRange() {
		return 0 <= currX && currX < m && 0 <= currY && currY < m;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		boolean isValid = true;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int d = Integer.parseInt(st.nextToken());

			switch (op) {
			case "TURN":
				turn(d);
				break;
			case "MOVE":
				move(d);
				break;
			}

			if (!inRange()) {
				isValid = false;
				break;
			}
		}

		if (isValid) {
			System.out.println(currX + " " + currY);
		} else {
			System.out.println(-1);
		}
	}
}