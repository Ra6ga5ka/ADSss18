
public class aufg2 {
	public static void main(String[] args) {
		long n = 4;
		long k = 2;
		System.out.println(binoef1(n, k));
		
	}
	
	public static long binoef1(long n, long k){
		if(k>n) return 0;
		if(k == 0 | k == n) return 1;
		return binoef1(n-1,k-1)+binoef1(n-1, k);
	}
	
	public static long binoef2(long n, long k){
		if(k>n) return 0;
		if(k == 0 | k == n) return 1;
		return binoef2(n-1, k-1)*n/k;
	}
}
