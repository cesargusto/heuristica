package UPMSPST;

import java.util.ArrayList;

public class Arquivo {
	public static void main(String[] args){
		ArrayList<Integer>vetor = new ArrayList<>();
		
		vetor.add(164);
		vetor.add(542);
		vetor.add(981);
		vetor.add(703);
		
		String arq1 = "Arquivo1";
		Arq arq = new Arq();
		arq.grava(arq1, vetor);
	} 

}
