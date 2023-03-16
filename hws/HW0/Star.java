public class Star{
	public static void DrawTriangle(int N){
		int i = 1; 
		while (i <= N){
			int j = 1;
			while (j <= i){
				System.out.print("*");
				j++;
			}
			System.out.println("");
			i++;
		}
	}
	
	
	public static void main(String[] args){
		DrawTriangle(10);
	}
}
