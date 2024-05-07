import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		// m번의 카드 합체 놀이
		while (m-- > 0) {
			// 두 장의 카드를 뽑는다.
			long x = pq.poll();
			long y = pq.poll();

			// 두 장에 쓰여진 수의 합을 덮어쓴다.
			pq.offer(x + y);
			pq.offer(x + y);
		}

		// 결과 출력
		long sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}
}