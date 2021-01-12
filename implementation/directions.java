package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이것이 코딩 테스트가. pg111
public class directions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MAX = st.countTokens();
		int resultX = 1;
		int resultY = 1;
		for (int i = 0; i < MAX; i++) {
			switch (st.nextToken().charAt(0)) {			
			case 'L':
				if (resultY == 1)
					break;
				else {
					resultY -= 1;
					break;
				}
			case 'R':
				if (resultY == MAX)
					break;
				else {
					resultY += 1;
				}
			case 'U':
				if (resultX == 1)
					break;
				else {
					resultX -= 1;
					break;
				}
			case 'D':
				if (resultX == MAX)
					break;
				else {
					resultX += 1;
					break;
				}
			}

		}
		System.out.println(resultX + " " + resultY);

		
	}
}
