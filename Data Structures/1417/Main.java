import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		int n = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine()); // 다솜이의 득표수
		int cnt = 0; // 매수해야 하는 사람의 수

		for (int i = 1; i < n; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}

		while (!q.isEmpty()) {
			if (dasom > q.peek()) break;
			q.offer(q.poll() - 1);
			dasom++;
			cnt++;
		}

		System.out.println(cnt);
	}
}