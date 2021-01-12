package greedyAlgorithm;

import java.util.*;

class Jewelry {
	int mass;
	int value;
	
	public Jewelry(int mass, int value) {
		this.mass= mass;
		this.value = value;
	}
}		

public class boj1202_보석도둑{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Jewelry[] jewelries = new Jewelry[N];
		for (int i = 0; i < N; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			jewelries[i] = new Jewelry(m,v);
		}
		Arrays.sort(jewelries, new Comparator<Jewelry>() {
			@Override
	    	public int compare(Jewelry o1, Jewelry o2) {
				if(o1.mass == o2.mass) {
	    			return o2.value - o1.value;
	    		}
	    		return o1.mass- o2.mass;
			}
		});
		//보석 저장 후 내림차순 정렬 
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = sc.nextInt();
		}
		Arrays.sort(bags);
		//가방 무게 저장 후 오름차순 정렬  
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long price = 0;
		for (int i = 0, j = 0; i < K; i++) {
			while(j < N && jewelries[j].mass <= bags[i]) {
				pq.offer(jewelries[j++].value);
			}
			if(!pq.isEmpty()) {
				price += pq.poll();
			}
		}
		
		System.out.println(price);
		
	}
}
