package com.heuristica.AG.AGMOCHILA;

import java.util.ArrayList;

public class Show {
	
	public static void show(ArrayList<Solucao> sol){
		
		for(int j = 0;j<sol.size();j++){
			int[]vetor = sol.get(j).getSolucao();
			
			for(int i = 0;i < vetor.length;i++)
				System.out.printf("%d ",vetor[i]);
			
			System.out.println("\nBENEFICIO......:"+sol.get(j).funcaoObjetivo(sol.get(j)));
			System.out.println("PESO MOCHILA...:"+sol.get(j).calculaPeso(sol.get(j)));
		}
	}
}
