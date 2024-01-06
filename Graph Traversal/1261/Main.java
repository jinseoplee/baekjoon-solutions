import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int m, n;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return cnt - o.cnt;
		}
	}

	static boolean outRange(int r, int c) {
		return r < 0 || r >= n || c < 0 || c >= m;
	}

	static int calcBreakCnt() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][m];

		pq.offer(new Node(0, 0, 0));
		visited[0][0] = true;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.r == n - 1 && curr.c == m - 1) {
				return curr.cnt;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				if (outRange(nextR, nextC)) continue;
				if (visited[nextR][nextC]) continue;

				if (map[nextR][nextC] == 0) {
					pq.offer(new Node(nextR, nextC, curr.cnt));
				}

				if (map[nextR][nextC] == 1) {
					pq.offer(new Node(nextR, nextC, curr.cnt + 1));
				}

				visited[nextR][nextC] = true;
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]); // 가로
		n = Integer.parseInt(input[1]); // 세로

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		System.out.println(calcBreakCnt());
	}
}