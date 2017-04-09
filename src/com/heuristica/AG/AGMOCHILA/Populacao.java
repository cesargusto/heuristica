package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Populacao {
	
	private int tamanhoPop;
	
	public Populacao(Inicializa in) throws NumberFormatException, IOException{
		this.tamanhoPop = in.tamanhoPop;
	}

	public ArrayList<Solucao> geraPopAleat() throws NumberFormatException, IOException{
		
		ArrayList<Solucao> pop = new ArrayList<>();
		Solucao so = new Solucao();
		for(int i = 0;i < this.tamanhoPop;i++){
			pop.add(so.criaMochilaAleatoria());
		}
		return pop;
	}
}
