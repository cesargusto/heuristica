package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.Random;

public class Start {
	
    public static void main(String[] args) throws NumberFormatException, IOException{
    	
    	Inicializa in = new Inicializa();
    	Populacao pop = new Populacao(in);
    	
    	pop.geraPopAleat();
    	
    	Show.show(pop);
    	
    	int indicePai1 = pop.Roleta();
    	int indicePai2 = pop.Roleta();
    	
    	System.out.println("Rol1\t"+indicePai1);
    	System.out.println("Rol2\t"+indicePai2);
    	
    	Solucao pai1 = new Solucao();
    	Solucao pai2 = new Solucao();
    	
    	pai1.setSolucao(pop.getPopulacao().get(indicePai1).getSolucao());
    	pai2.setSolucao(pop.getPopulacao().get(indicePai2).getSolucao());
    	
    	System.out.println();
    	
    	System.out.println("Pais:");
    	Show.showSol(pai1);
    	Show.showSol(pai2);
    	
    	Solucao filho = new Solucao();
    	int qtitens = pop.getPopulacao().get(0).getQtItens();
    	int ponto = (int)qtitens/2;    	
    	
    	filho = pop.cruzamento(pai1, pai2, ponto);
    	
    	System.out.println("\nPonto\t"+ponto);
    	
    	System.out.println("\nFilho:");
    	Show.showSol(filho);
    	
    	Random rand = new Random();
    	int posMut = rand.nextInt(qtitens);
    	filho.mutacao(posMut);
    	System.out.println("\nPosição de Mutação: "+posMut);
    	
    	System.out.println("\nFilho Mutado: ");
    	Show.showSol(filho);
    	  	
    }

}