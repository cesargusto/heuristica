package com.heuristica.AG.AGMOCHILA;

public class Show {
	
	public static void show(Populacao pop){
		System.out.println("Peso\tBeneficio\tSolucao");
		for(int j = 0;j < pop.getTamanhoPop();j++){
			System.out.printf("%d\t",pop.getPopulacao().get(j).calculaPeso());
			System.out.printf("%d\t\t",pop.getPopulacao().get(j).calculaFo());
			System.out.println(pop.getPopulacao().get(j).toString());
			}
		System.out.println();
	}
	
	public static void showSol(Solucao s){
		System.out.printf("%d\t%d\t\t",s.calculaPeso(),s.calculaFo());
		System.out.println(s.toString());		
	}
}
