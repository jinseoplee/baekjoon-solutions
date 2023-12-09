import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int h, r, c;

	Tomato(int h, int r, int c) {
		this.h = h;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int N, M, H;
	static int unripeCnt = 0;
	static int[][][] box;
	static Queue<Tomato> q = new ArrayDeque<>();

	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dh = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };

	// 범위를 체크하는 메서드
	static boolean inRange(int h, int r, int c) {
		return 0 <= h && h < H && 0 <= r && r < N && 0 <= c && c < M;
	}

	// 토마토가 모두 익을 때까지 최소 며칠이 걸리는지 계산하는 메서드
	static int calcMinDays() {
		int days = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Tomato curr = q.poll();
				for (int dir = 0; dir < 6; dir++) {
					int nextH = curr.h + dh[dir];
					int nextR = curr.r + dr[dir];
					int nextC = curr.c + dc[dir];
					if (!inRange(nextH, nextR, nextC)) continue; // 범위 체크
					if (box[nextH][nextR][nextC] != 0) continue; // 익지 않은 토마토인지 체크
					q.offer(new Tomato(nextH, nextR, nextC));
					box[nextH][nextR][nextC] = 1;
					unripeCnt--;
				}
			}
			days++;
		}

		// 토마토가 모두 익은 경우 최소 며칠이 걸리는지 반환하고, 모두 익지 못하는 상황이면 -1을 반환한다.
		return unripeCnt == 0 ? days - 1 : -1;
	}

	// 토마토 박스 초기화
	static void initializeBox(BufferedReader br) throws Exception {
		box = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					int input = Integer.parseInt(st.nextToken());

					// 익은 토마토인 경우 큐에 삽입
					if (input == 1) {
						q.offer(new Tomato(h, r, c));
					}

					// 익지 않은 토마토인 경우
					else if (input == 0) {
						unripeCnt++;
					}

					box[h][r][c] = input;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		initializeBox(br);

		System.out.println(calcMinDays());
	}
}