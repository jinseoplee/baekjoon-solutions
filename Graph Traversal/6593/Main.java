import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int H, R, C;
	static char[][][] map;
	static boolean[][][] visited;
	static Queue<Node> q = new ArrayDeque<>();

	// 동, 서, 남, 북, 상, 하
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { -1, 1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static class Node {
		int h, r, c, m;

		Node(int h, int r, int c, int m) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.m = m;
		}
	}

	// 범위 체크
	static boolean inRange(int h, int r, int c) {
		return 0 <= h && h < H && 0 <= r && r < R && 0 <= c && c < C;
	}

	static String bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();

			// 'E'에 도착한 경우
			if (map[curr.h][curr.r][curr.c] == 'E') {
				return "Escaped in " + curr.m + " minute(s).\n";
			}

			for (int dir = 0; dir < 6; dir++) {
				int nextH = curr.h + dh[dir];
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];

				// 범위 체크
				if (!inRange(nextH, nextR, nextC)) continue;

				// 방문 체크
				if (visited[nextH][nextR][nextC]) continue;

				// '#' 체크
				if (map[nextH][nextR][nextC] == '#') continue;

				q.offer(new Node(nextH, nextR, nextC, curr.m + 1));
				visited[nextH][nextR][nextC] = true;
			}
		}

		return "Trapped!\n";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		while (true) {
			String[] input = br.readLine().split(" ");
			H = Integer.parseInt(input[0]);
			R = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);

			if (H == 0) break;

			map = new char[H][R][C];
			visited = new boolean[H][R][C];

			for (int h = 0; h < H; h++) {
				for (int r = 0; r < R; r++) {
					char[] line = br.readLine().toCharArray();
					for (int c = 0; c < C; c++) {
						// 시작 지점을 큐에 넣음
						if (line[c] == 'S') {
							q.offer(new Node(h, r, c, 0));
							visited[h][r][c] = true;
						}
						map[h][r][c] = line[c];
					}
				}
				br.readLine();
			}

			answer.append(bfs());
			q.clear();
		}

		System.out.println(answer);
	}
}