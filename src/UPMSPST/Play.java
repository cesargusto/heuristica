package UPMSPST;

public class Play {

	public static int numMaquinas;
	public static int[] maquinas;
	
	Play(int numMaq){
		numMaquinas = numMaq;
		maquinas = new int[numMaquinas];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2, 4, 6, 8, 10};
		for(int x : array){System.out.println(x);}
		System.out.println("\n"+array.length);
	}

}
