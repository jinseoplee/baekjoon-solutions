import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r, c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> q = new ArrayDeque<>();

	// 동, 서, 남, 북
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];
				if ((nr < 0 || nr >= n || nc < 0 || nc >= m) || visited[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
					map[nr][nc] = map[curr.r][curr.c] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 세로, 가로 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 맵, 방문 배열 초기화
		map = new int[n][m];
		visited = new boolean[n][m];

		// 맵 입력 처리
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					q.offer(new Node(r, c));
					map[r][c] = 0;
					visited[r][c] = true;
				}
			}
		}

		bfs();

		// 결과 출력
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				sb.append((!visited[r][c] && map[r][c] == 1) ? -1 : map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}