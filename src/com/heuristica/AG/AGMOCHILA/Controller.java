package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.Random;

public class Controller {

	public static void ag(String nome)throws NumberFormatException, IOException, CloneNotSupportedException{
		
    	Inicializa in = new Inicializa(nome);
    	Thebest tb = new Thebest(in);
 
    	Populacao pop = new Populacao(in);
		Populacao novaPop = new Populacao(in);
		Random rand = new Random();
		
		String nomeGer = "ger_"+nome;
		String nomePop = "pop_"+nome;
		
    	/***GERA POPULACAO ALEATÓRIA***/
    	pop.geraPopAleat();
    	//Show.show(pop);
    	
    	int contador = 0;
    	
    	while(contador < in.numGeracoes){//while GERAÇÕES
		    
    		while(novaPop.getPopulacao().size() < in.tamanhoPop){ //while POPULAÇÃO
		    	
		    	//INSTANCIAR 1 E 2(SOLUCAO)
		    	Solucao pai1 = new Solucao(in);
		    	Solucao pai2 = new Solucao(in);
		    	
		    	//INSTANCIAR FILHOS 1 E 2(SOLUCAO)
		    	Solucao filho1 = new Solucao(in);
		    	Solucao filho2 = new Solucao(in);
		    	
		    	int indicePai1 = 0;
		    	int indicePai2 = 0;
		    	
		    	//ESCOLHE MÉTODO DE SELEÇÃO
		    	if(in.selecao == 1){
			    	//SELEÇÃO DE PAIS POR ROLETAS
			    	indicePai1 = pop.Roleta();
			    	indicePai2 = pop.Roleta();
		    	}
		    	else{
			    	//SELEÇÃO DE PAIS POR TORNEIO
			    	indicePai1 = pop.Torneio();
			    	indicePai2 = pop.Torneio();
		    	}	
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
		    		
		    		//TESTE PARA MUTAÇÃO FILHO 1
		    		
		    		if(Util.prob(in.prob_mutacao)){
		        		
		    			int ran = rand.nextInt(qtitens);
		    			
		        		filho1.mutacao(ran);
		        		
		        		if(filho1.avalia(tb, pop)){
		        			novaPop.setPopulacao(filho1);
		        		}
		        		else{
		        			if(Util.prob(in.tx_inapto))
		        				novaPop.setPopulacao(filho1);
		        			else
		        				System.out.printf("");//Filho1 mutado FORA
		        			}
		    		}//se nao houver mutação avalia também
		    		else{
		    			if(filho1.avalia(tb, pop))
		    				novaPop.setPopulacao(filho1);
		    			else{
		    				if(Util.prob(in.tx_inapto))
		    					novaPop.setPopulacao(filho1);
		    				else
		    					System.out.printf("");//Filho1 nao mutado FORA
		    			}
		    				
		    		}
		    		
		    		//TESTE PARA MUTAÇÃO FILHO 2
		    		
		    		if(Util.prob(in.prob_mutacao)){
		        		
		    			int ran = rand.nextInt(qtitens);
		        		
		        		filho2.mutacao(ran);
		        		
		        		if(filho2.avalia(tb, pop))
		        			novaPop.setPopulacao(filho2);
		        		else{
		        			if(Util.prob(in.tx_inapto))
		        				novaPop.setPopulacao(filho2);
		        			else
		        				System.out.printf("");//FILHO 2 MUTADO FORA
		        			}
		        	}
		    		else{
		    			if(filho2.avalia(tb, pop))
		    				novaPop.setPopulacao(filho2);
		    			else{
		    				if(Util.prob(in.tx_inapto))
		    					novaPop.setPopulacao(filho2);
		    				else
		    					System.out.printf("");//FILHO 2 NAO MUTADO FORA
		    			}
		    		}
		
		    	}
		    	else
		    		System.out.printf("");//NAO HOUVE CRUZAMENTO
		    
		    }/* WHILE POPULAÇOES */

/***************************[ AO FIM DE CADA POPULAÇÃO ]*************************************/
		
    		//Guarda o melhor valor de função objetivo - grafico de convergencia
    		tb.setMelhores_fo_pop(pop.getMelhor_so_pop().calculaFo());
    		tb.setMelhores_fo(tb.getMelhor_so_global().calculaFo());
    	
		    //System.out.printf("[ GERAÇÃO %d DE %d ] \n",contador, in.numGeracoes);
		    //Show.showSol(pop.getMelhor_so_pop());
		    
    		//faz copia da geracao atual e aloca uma nova geração
    		pop = novaPop.clone();    
		    novaPop = new Populacao(in);
		    
		    //Insere na nova população o melhor individuo da geração anterior
		    novaPop.setPopulacao(tb.getMelhor_so_global());
		    System.out.println("\ngeração: "+contador);
		    contador++;
		    
    	}/* WHILE GERAÇOES */
    
/****************************** [ RESULTADOS FINAIS ] **********************************/

    	System.out.println("\nEVOLUÇÃO DO ALGORITMO\n");
    	//System.out.println(tb.getMelhores_fo_pop());
    	//System.out.println(tb.getMelhores_fo());
    	
    	Arq arq = new Arq();
    	arq.grava(nomePop, tb.getMelhores_fo_pop());
    	arq.grava(nomeGer, tb.getMelhores_fo());
    	
    	System.out.println("\n*** MELHOR SOLUÇÃO ***\n");
    	pop.getPopulacao().get(0).exibeSolucao(tb);
    	System.out.printf("----------------------\n");
    	Show.showSol(tb.getMelhor_so_global());
    	
    	System.out.printf("\n");
	}
}
