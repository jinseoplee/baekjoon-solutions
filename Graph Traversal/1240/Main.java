import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static class Node {
		int n;
		int distance;

		Node(int n, int distance) {
			this.n = n;
			this.distance = distance;
		}
	}

	static void dfs(int curr, int goal, int distance) {
		// 현재 노드가 목표 지점에 도착한 경우 거리를 출력한다.
		if (curr == goal) {
			System.out.println(distance);
			return;
		}

		for (Node next : graph.get(curr)) {
			if (!visited[next.n]) {
				visited[next.n] = true;
				dfs(next.n, goal, distance + next.distance);
				visited[next.n] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 정점 연결
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			graph.get(n1).add(new Node(n2, distance));
			graph.get(n2).add(new Node(n1, distance));
		}

		visited = new boolean[N + 1];

		// 두 노드 사이의 거리를 계산한다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			visited[start] = true;
			dfs(start, goal, 0);
			visited[start] = false;
		}
	}
}