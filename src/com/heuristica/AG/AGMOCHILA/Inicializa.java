package com.heuristica.AG.AGMOCHILA;

public class Inicializa {

	public String nomearq;
	public int tamanhoPop;
	public int numGeracoes;
	public double prob_cruzamento;
	public double prob_mutacao;
	public double tx_inapto;
	
	public Inicializa(){
		this.nomearq = "teste1";
		this.tamanhoPop = 10;
		this.numGeracoes = 25;
		this.prob_cruzamento = 0.65;
		this.prob_mutacao = 0.8;
		this.tx_inapto = 0.5;
	}
	
	public Inicializa(String nomeArq, int tamanhoP, double p_cruzamento, double p_mutacao){
		this.nomearq = nomeArq;
		this.tamanhoPop = tamanhoP;		
		this.prob_cruzamento = p_cruzamento;
		this.prob_mutacao = p_mutacao;
	}
}
