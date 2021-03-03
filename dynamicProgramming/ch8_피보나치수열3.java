package dynamicProgramming;

public class ch8_피보나치수열3 {
	public static long d[] = new long[100];
	public static long fibo(int x) {
		System.out.println("f(" + x + ") ");
		if(x==1|| x==2) {
			return 1;
		}
		if(d[x] != 0) {
			return d[x];
		}
		d[x] = fibo(x-1) + fibo(x-2);
		return d[x];
	}
	public static void main(String[] args) {
		fibo(99);
	}
}
