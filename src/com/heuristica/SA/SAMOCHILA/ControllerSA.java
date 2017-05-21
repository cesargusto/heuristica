package com.heuristica.SA.SAMOCHILA;

import java.io.IOException;

import com.heuristica.AG.AGMOCHILA.Arq;
import com.heuristica.AG.AGMOCHILA.Arquivo;
import com.heuristica.AG.AGMOCHILA.Show;
import com.heuristica.AG.AGMOCHILA.Solucao;
import com.heuristica.AG.AGMOCHILA.Thebest;

public class ControllerSA {
	
	private Arquivo arquivo;
	private String nome;
	private Solucao so;
	private SA sa;
	private Thebest tb;
	
	public ControllerSA(String nome) throws NumberFormatException, IOException{
		this.nome = nome;
		this.arquivo = new Arquivo(nome);
		this.sa = new SA();
		this.so = new Solucao(arquivo);
		this.tb = new Thebest();
	}
	
	public void sanneling() throws NumberFormatException, IOException, CloneNotSupportedException{

		String caminhoSA = "experimento/sa/";
		
		String nomeSAc = "saC_"+nome;
		String nomeSAm = "saM_"+nome;
		
		this.so.cria_mochila_apta();
		
		Solucao s_fim = sa.simAnnealing(so, tb);
		
    	Arq arqSA = new Arq();
    	
    	arqSA.grava(caminhoSA, nomeSAc, tb.getMelhores_fo());
    	arqSA.grava(caminhoSA, nomeSAm, tb.getMelhores_fo_sa());
		
    	System.out.println("\n*** MELHOR SOLUÇÃO ***\n");

    	s_fim.exibeSolucao(tb);
    	System.out.printf("----------------------\n");
    	Show.showSol(tb.getMelhor_so_sa_global());
    	
    	System.out.printf("\n");
	}
}
