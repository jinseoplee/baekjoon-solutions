import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Kruskal 알고리즘을 이용하여 MST를 구한다. 
 * 기부할 수 있는 랜선의 최대 길이를 구하기 위해 총 랜선 길이에서 MST를 뺀다.
 *
 */
public class Main {
	static class LanCable implements Comparable<LanCable> {
		int i, j, length;

		LanCable(int i, int j, int length) {
			this.i = i;
			this.j = j;
			this.length = length;
		}

		@Override
		public int compareTo(LanCable o) {
			return length - o.length;
		}
	}

	static int n, totalLength;
	static int[] parent;
	static PriorityQueue<LanCable> pq = new PriorityQueue<>();

	static void makeSet() {
		parent = new int[n];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}
	}

	static int find(int i) {
		if (i == parent[i]) return i;
		return parent[i] = find(parent[i]);
	}

	static void union(int i, int j) {
		i = find(i);
		j = find(j);
		if (i > j) parent[i] = j;
		else parent[j] = i;
	}

	static int getMaxLength() {
		int minLength = 0;
		int lanCableCount = 0;
		while (!pq.isEmpty()) {
			if (lanCableCount == n - 1) break;
			LanCable curr = pq.poll();
			if (find(curr.i) != find(curr.j)) {
				union(curr.i, curr.j);
				minLength += curr.length;
				lanCableCount++;
			}
		}
		return (lanCableCount == n - 1) ? totalLength - minLength : -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (input[j] != '0') {
					int length = (input[j] >= 'a') ? input[j] - 'a' + 1 : input[j] - 'A' + 27;
					totalLength += length;
					pq.offer(new LanCable(i, j, length));
				}
			}
		}
		makeSet();
		System.out.println(getMaxLength());
	}
}