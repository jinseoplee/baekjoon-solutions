import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 1;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int w = Integer.parseInt(st.nextToken());
			int t = pq.poll();

			if (w > t) {
				answer = 0;
				break;
			}

			pq.offer(t - w);
		}

		System.out.println(answer);
	}
}