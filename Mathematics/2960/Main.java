import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		boolean[] visited = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= n; j += i) {
				if (visited[j]) continue;
				visited[j] = true;
				if (--k == 0) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}