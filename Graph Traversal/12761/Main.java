import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_SIZE = 100_000;
	static int a, b, n, m;

	// bfs를 이용하여 최소한의 이동 횟수를 구한다.
	static void bfs() {
		// 이동할 수 있는 8가지 방법
		int[] dx = { -1, 1, -a, a, -b, b, a, b };

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);

		int[] moveCount = new int[MAX_SIZE + 1];
		moveCount[n] = 1;

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (curr == m) break;

			for (int i = 0; i < 8; i++) {
				int next = 0;
				if (i < 6) {
					next = curr + dx[i];
				} else {
					next = curr * dx[i];
				}
				if ((0 <= next && next <= MAX_SIZE) && moveCount[next] == 0) {
					q.offer(next);
					moveCount[next] = moveCount[curr] + 1;
				}
			}
		}

		System.out.println(moveCount[m] - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bfs();
	}
}