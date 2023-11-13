import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		// 방문자 수 입력
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 초기 x일 동안의 방문자 수 계산
		int visitCnt = 0;
		for (int i = 0; i < x; i++) {
			visitCnt += arr[i];
		}

		// 최대 방문자 수와 기간의 수 초기화
		int maxVisitCnt = visitCnt;
		int periodCnt = 1;

		// 슬라이딩 윈도우를 사용하여 방문자 수 계산
		for (int i = x; i < n; i++) {
			visitCnt -= arr[i - x];
			visitCnt += arr[i];

			// 최대 방문자 수 갱신 및 기간 카운트
			if (visitCnt > maxVisitCnt) {
				maxVisitCnt = visitCnt;
				periodCnt = 1;
			} else if (visitCnt == maxVisitCnt) {
				periodCnt++;
			}
		}

		// 결과 출력
		if (maxVisitCnt == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxVisitCnt);
			System.out.println(periodCnt);
		}
	}
}