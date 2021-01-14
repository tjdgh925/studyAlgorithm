package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_11286_절댓값힙 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) ->
			Math.abs(o1) == Math.abs(o2) ? 
	    		Integer.compare(o1, o2) : 
	    			Integer.compare(Math.abs(o1), Math.abs(o2))
	    );
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(que.size() == 0)
					System.out.println('0');
				else
					System.out.println(que.poll());
			}else
				que.add(num);
		}

	}
}