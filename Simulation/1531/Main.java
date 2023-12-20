import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int PICTURE_SIZE = 100;
	static int n, m;
	static int invisibleCnt;
	static int[][] painting = new int[PICTURE_SIZE + 1][PICTURE_SIZE + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					if (painting[i][j]++ == m) invisibleCnt++;
				}
			}
		}

		System.out.println(invisibleCnt);
	}
}