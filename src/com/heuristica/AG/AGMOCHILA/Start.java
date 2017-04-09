package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;

public class Start {
	
    public static void main(String[] args) throws NumberFormatException, IOException{
    	Inicializa in = new Inicializa();
    	Populacao pop = new Populacao(in);

    	Show.show(pop.geraPopAleat());
    }

}