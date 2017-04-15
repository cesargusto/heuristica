package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Start {
	
    public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException{
    	
    	/* - >> garantir melhor indivio na proxima geração
    	 * - >> passar objeto thebest como parametro para a funcao avalia
    	 * - aleatorizar a posição dos elementos no geração da mochila aleatoria
    	 * - permitir 20% de elementos não aptos na geração aleatória
    	 * - armazenar um ranking das melhores soluçoes
    	 * */
    	
    	Random rand = new Random();
    	Inicializa in = new Inicializa();
    	Thebest tb = new Thebest();
 
    	Populacao pop = new Populacao(in);
		Populacao novaPop = new Populacao(in);
		
    	/***GERA POPULACAO ALEATÓRIA***/
    	pop.geraPopAleat();
    	
    	int contador = 0;
    	
    	while(contador < in.numGeracoes){//while GERAÇÕES
		    
    		while(novaPop.getPopulacao().size() < in.tamanhoPop){ //while POPULAÇÃO
		    	
		    	//INSTANCIAR 1 E 2(SOLUCAO)
		    	Solucao pai1 = new Solucao();
		    	Solucao pai2 = new Solucao();
		    	
		    	//INSTANCIAR FILHOS 1 E 2(SOLUCAO)
		    	Solucao filho1 = new Solucao();
		    	Solucao filho2 = new Solucao();
		    	
		    	//INDICES DOS PAIS PELA ROLETAS
		    	int indicePai1 = pop.Roleta();
		    	int indicePai2 = pop.Roleta();
		    	
		    	//APONTAMENTO PARA OS PAIS
		    	pai1 = pop.getPopulacao().get(indicePai1);
		    	pai2 = pop.getPopulacao().get(indicePai2);
		    	
		    	//TAMANHO DA SOLUCAO E PONTO ALEATORIO DE CORTE
		    	int qtitens = pop.getPopulacao().get(0).getQtItens();
		    	
		    	//CRUZAMENTO E MUTAÇÃO
		
		    	if(Util.prob(in.prob_cruzamento)){
		
		        	int ponto = 1 + rand.nextInt(qtitens - 1);
		        	
		    		filho1.cruzamento(pai1, pai2, ponto);
		    		filho2.cruzamento(pai2, pai1, ponto);
		    		
		    		if(Util.prob(in.prob_mutacao)){
		        		
		    			int ran = rand.nextInt(qtitens);
		    			
		        		filho1.mutacao(ran);
		        		
		        		if(filho1.avalia(tb, pop)){
		        			novaPop.setPopulacao(filho1);
		        		}
		        		else{
		        			if(Util.prob(in.tx_inapto)){
		        				novaPop.setPopulacao(filho1);
		        			}
		        			else
		        				System.out.printf("");//Filho1 FORA
		        			
		        		}
		        		ran = rand.nextInt(qtitens);
		        		
		        		filho2.mutacao(ran);
		        		
		        		if(filho2.avalia(tb, pop)){
		        			novaPop.setPopulacao(filho2);
		        		}else{
		        			if(Util.prob(in.tx_inapto)){
		        				novaPop.setPopulacao(filho2);
		        			}
		        			else
		        				System.out.printf("");//filho fora
		        			}
		        		}
		
		    	}else{
		    		System.out.printf("");//NAO HOUVE CRUZAMENTO\n
		    	}
		    
		    	//System.out.println("-------------------------------------------------------");
		    
		    }/* WHILE POPULAÇOES */

/***************************[ PÓS POPULAÇÃO ]*************************************/
		
    		//Guarda o melhor valor de função objetivo - grafico de convergencia
    		tb.setMelhores_fo(tb.getMelhor_so_global().calculaFo());
    	
		    System.out.printf("[ MELHOR DA GERAÇÃO %d ] \n",contador);
		    Show.showSol(pop.getMelhor_so_pop());
		    
    		//faz copia da geracao atual e aloca uma nova geração
    		pop = novaPop.clone();    
		    novaPop = new Populacao(in);
		    
		    //Insere na nova população o melhor individuo da geração anterior
		    novaPop.setPopulacao(tb.getMelhor_so_global());
		
		    contador++;
		    
    	}/* WHILE GERAÇOES */
    
/****************************** [ RESULTADOS FINAIS ] **********************************/
    	
    	System.out.println("\n*** EVOLUÇÃO DO ALGORITMO ***\n");
    	System.out.println(tb.getMelhores_fo());
    	System.out.printf("\n*** [ FIM ] ***\n");
    }

}