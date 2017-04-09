package PNAG;

import java.util.ArrayList;
import java.util.Random;

public class pLAY {
	public static ArrayList<Integer> CriaArrayAle(int num){
		ArrayList<Integer> lista = new ArrayList<>();
		Random gerador = new Random();
		
		for(int i = 0;i < num;i++){
			lista.add(gerador.nextInt(11));//gera entre 0 e 50
		}
		return lista;
	}
	

	public static void calculaFo(ArrayList<Integer> solucao, ArrayList<Integer> lista, int numPart){
		
		//int fo = 10000000;
		int[] somador = new int[numPart];
		int p = 0;
		for(int i = 0;i < lista.size();i++){
			p = solucao.get(i);
			somador[p] = somador[p] + lista.get(i);
		}
		//return somador;
		for(int j = 0;j < numPart;j++){
			System.out.printf("%d ", somador[j]);
		}		
	}
	public static boolean validaNumPart(int tamanhoA, int numPart){
		if(numPart <= tamanhoA)
			return true;
		else
			return false;
	} 
	public static boolean validaParts(){
		return true;
	}
	public static void main(String[] args) {
		
		int tamanhoArray = 6;
		int numPart = 6;
		
		ArrayList<Integer> Lista = new ArrayList<Integer>();
		ArrayList<Integer> S = new ArrayList<Integer>();
		Lista = CriaArrayAle(tamanhoArray);
		//imprimeArray(Lista);
		System.out.println();
		//S = (criaSolInicial(numPart, Lista));
		//imprimeArray(S);
		System.out.println();
		calculaFo(S, Lista, numPart);
	}

}
