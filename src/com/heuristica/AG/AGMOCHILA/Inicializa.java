package com.heuristica.AG.AGMOCHILA;

public class Inicializa {

	public String nomearq;
	public int tamanhoPop;
	public int numGeracoes;
	public double prob_cruzamento;
	public double prob_mutacao;
	public double tx_inapto;
	public int selecao;
	
	public Inicializa(String arquivo){
		this.nomearq = arquivo;
		this.tamanhoPop = 100; //100
		this.numGeracoes = 500; //500
		this.prob_cruzamento = 0.65;
		this.prob_mutacao = 0.3;
		this.tx_inapto = 0.2;
		this.selecao = 0;	//0 - TORNEO; 1 - ROLETA
	}
	
	public Inicializa(String nomeArq, int tamanhoP, long p_cruzamento, long p_mutacao){
		this.nomearq = nomeArq;
		this.tamanhoPop = tamanhoP;		
		this.prob_cruzamento = p_cruzamento;
		this.prob_mutacao = p_mutacao;
	}
}
