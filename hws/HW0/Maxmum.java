public class Maxmum{
	public static int max(int[] m){
		int result = 0;
		for (int i = 0; i < m.length; i++){
			result = (m[i] > result) ? m[i] : result;
		}
		return result;
	}


	public static void main(String[] args){
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
}
