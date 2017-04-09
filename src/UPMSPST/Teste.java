package UPMSPST;

public class Teste {
	
	public static void imprimeMatriz(int[][]m){
		for(int i = 0;i < m.length; i++){
			for(int j = 0 ; j < m.length; j++){
				System.out.printf("%d  ",m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void imprimeVetor(int[]v){
		for(int i = 0; i< v.length;i++){
			System.out.printf("%d  ",v[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int maq1[] = {20, 25, 28, 17, 43, 9, 58};
		int maq2[] = {4, 21, 14, 32, 38, 23, 52};
		
		int[][] temMaq1 = {
				{2, 1, 8, 1, 3, 9, 6},
				{4, 7, 6, 3, 7, 8, 4},
				{7, 3, 4, 2, 3, 5, 3},
				{3, 8, 3, 5, 5, 2, 2},
				{8, 3, 7, 9, 6, 5, 7},
				{8, 8, 1, 2, 2, 1, 9},
				{1, 4, 5, 2, 3, 5, 1}};
		
		int[][] temMaq2 = {
				{3, 4, 6, 5, 9, 3, 2},
				{1, 2, 6, 2, 7, 7, 5},
				{2, 6, 4, 6, 8, 1, 4},
				{5, 7, 8, 3, 2, 5, 6},
				{7, 9, 5, 7, 6, 4, 8},
				{9, 3, 5, 4, 9, 8, 3},
				{3, 2, 6, 1, 5, 6, 7}};
		
		imprimeMatriz(temMaq1);
		imprimeMatriz(temMaq2);
		imprimeVetor(maq1);
		imprimeVetor(maq2);
	}
}
