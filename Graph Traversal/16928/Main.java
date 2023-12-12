import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] board = new int[101];
	static int[] move = new int[101];

	static int calcMinDiceRolls() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);

		while (!q.isEmpty()) {
			int curr = q.poll();

			// 100번 칸에 도착한 경우 반복문 탈출
			if (curr == 100) break;

			// 현재 위치에서 주사위를 굴린다.
			for (int i = 1; i <= 6; i++) {
				int next = curr + i;

				// 100번 칸을 벗어나거나 이미 방문한 경우
				if (next > 100 || move[next] != 0) continue;

				// 다음 위치가 뱀 또는 사다리일 경우
				if (board[next] != 0) {
					// 뱀 또는 사다리가 가리키는 위치를 방문하지 않은 경우
					if (move[board[next]] == 0) {
						q.offer(board[next]);
						move[board[next]] = move[curr] + 1;
					}
				} else {
					q.offer(next);
					move[next] = move[curr] + 1;
				}
			}
		}

		// 100번 칸에 도착하기 위해 주사위를 굴린 횟수를 반환
		return move[100];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 사다리의 수
		m = Integer.parseInt(st.nextToken()); // 뱀의 수

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		System.out.println(calcMinDiceRolls());
	}
}