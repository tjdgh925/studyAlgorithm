package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1966_프린트큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int count = 0;
			
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			LinkedList<int[]> queue = new LinkedList<>();
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				queue.add(new int[]{j,temp});
				pq.add(temp);
			}
			while(true) {
				if(pq.peek() == queue.peek()[1]) {
					count++;
					if(queue.peek()[0] == target) break;
					pq.poll();
					queue.poll();
				}else {
					int[] temp = new int[2];
					temp = queue.poll();
					queue.add(temp);
				}
			}
			System.out.println(count);
		}
	}
}
