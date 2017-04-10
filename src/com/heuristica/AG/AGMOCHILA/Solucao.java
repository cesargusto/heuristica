package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Solucao {

	private Inicializa in;
	private int[]solucao;
	private int qtItens;
	private int capMochila;
	private ArrayList<Item> dados;
	private Random rand;
	private Arquivo arq;
	
	public Solucao() throws NumberFormatException, IOException{
		this.in = new Inicializa();
		this.arq = new Arquivo(in.nomearq);
		this.qtItens = arq.getQuantItens();
		this.capMochila = arq.getPesoMaxMochila();
		this.dados = arq.getDados();
		this.solucao = new int[qtItens];
		this.rand = new Random();
	}
	
    public void criaMochilaAleatoria() throws NumberFormatException, IOException{
		
		for(int i = 0;i < qtItens; i++){
			if(!rand.nextBoolean())
				this.setSolucao(0,i);
			else
			{
				this.setSolucao(1, i);		//se s nao for aceito desfaz alteracao e sai
				if(!aceitaMochila())
				{
					this.setSolucao(0, i);
					break;
				}
			}
		}
    }	
    
    public boolean aceitaMochila(){
        
    	int contador = 0;
        
        for(int i = 0; i < qtItens;i++)
        {
        	if(solucao[i] == 1)
        		contador += dados.get(i).getTamanhoItem();
        }
        if (contador <= this.capMochila)
        	return true;
        else
            return false;
    }
    
    //SOMA PESOS
    public int calculaPeso(){
    	int peso = 0;
        for(int i = 0; i < qtItens;i++)
        {
        	if(solucao[i] == 1)
        		peso += dados.get(i).getTamanhoItem();
        }    	
    	return peso;
    }
    
    //SOMA OS BENEFICIOS
	public int calculaFo(){
		int fo = 0;
		for(int i = 0;i<this.qtItens;i++){
			if(solucao[i] == 1){
				fo += this.dados.get(i).getBeneficioItem();
			}
		}
		return fo;
	}
	
	public void mutacao(int posicao){
		if(this.getSolucao(posicao)== 1)
			this.setSolucao(0, posicao);
		else
			this.setSolucao(1, posicao);
	}
	
	public int getSolucao(int posicao) {
		return solucao[posicao];
	}
	
	public void setSolucao(int elemento, int posicao) {
		this.solucao[posicao] = elemento;
	}	

	public int[] getSolucao() {
		return solucao;
	}
	
	public void setSolucao(int[] solution) {
		for(int i = 0;i < solution.length;i++)
			this.solucao[i] = solution[i];
	}
	
	public int getQtItens() {
		return qtItens;
	}

	public String toString(){
		String st="";
		for(int i = 0;i < solucao.length;i++){
			st += solucao[i]+" ";
		}
		return st;
	}
}
