import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] belt;
	static boolean[] robots;

	// step 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
	static void rotate() {
		// 벨트를 한 칸씩 이동시킨다.
		int temp = belt[2 * n - 1];
		for (int i = 2 * n - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = temp;

		// 로봇을 한 칸씩 이동시킨다.
		for (int i = n - 1; i > 0; i--) {
			robots[i] = robots[i - 1];
		}
		robots[0] = false;

		// 로봇이 내리는 위치에 로봇이 있으면 즉시 로봇을 내린다.
		if (robots[n - 1]) {
			robots[n - 1] = false;
		}
	}

	// step 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
	static void move() {
		for (int i = n - 2; i >= 0; i--) {
			// 다음 위치에 로봇이 없고 내구도가 1 이상 남아있는 경우
			if (robots[i] && !robots[i + 1] && belt[i + 1] >= 1) {
				// 로봇을 이동시키고 다음 칸의 내구도를 1만큼 감소시킨다.
				robots[i] = false;
				robots[i + 1] = true;
				if (--belt[i + 1] == 0) {
					k--;
				}
			}
		}
	}

	// step 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
	static void putRobot() {
		if (belt[0] != 0) {
			robots[0] = true;
			if (--belt[0] == 0) {
				k--;
			}
		}
	}

	static int simulate() {
		int step = 0;
		while (k > 0) {
			step++;
			rotate();
			move();
			putRobot();
		}
		return step;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		robots = new boolean[n];
		belt = new int[n * 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(simulate());
	}
}