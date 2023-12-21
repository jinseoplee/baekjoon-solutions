import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int h, w;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		map = new char[h][];
		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < h; i++) {
			int curr = -1;
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 'c') {
					curr = 0;
				} else if (curr != -1) {
					curr++;
				}
				answer.append(curr).append(" ");
			}
			answer.append("\n");
		}

		System.out.println(answer);
	}
}