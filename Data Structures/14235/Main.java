import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			// 아이를 만났을 경우
			if (a == 0) {
				// 선물이 없다면 -1을 출력한다.
				if (pq.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(pq.poll());
				}
				sb.append("\n");
			}
			// 선물을 충전한다.
			else {
				while (st.hasMoreElements()) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}
}