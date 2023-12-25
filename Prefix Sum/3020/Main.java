import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] bottom = new int[h + 1]; // 석순
		int[] top = new int[h + 1]; // 종유석

		for (int i = 0; i < n / 2; i++) {
			int bottomH = Integer.parseInt(br.readLine());
			int topH = Integer.parseInt(br.readLine());
			bottom[bottomH]++;
			top[topH]++;
		}

		// 석순과 종유석의 누적합을 구한다.
		for (int i = h - 1; i >= 1; i--) {
			bottom[i] += bottom[i + 1];
			top[i] += top[i + 1];
		}

		int min = Integer.MAX_VALUE;
		int cnt = 0;

		// 개똥벌레가 파괴해야 하는 장애물의 최솟값과 그 구간이 총 몇 개 있는지 구한다.
		for (int i = 1; i <= h; i++) {
			int sum = bottom[i] + top[h + 1 - i];
			if (sum < min) {
				min = sum;
				cnt = 1;
			} else if (sum == min) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);
	}
}