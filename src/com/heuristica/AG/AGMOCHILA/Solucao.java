package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Solucao {

	private Inicializa in;
	private int tamanhoPop;
	private int[]solucao;
	private int qtItens;
	private int capMochila;
	private ArrayList<Item> dados;
	private Random rand;
	private Arquivo arq;
	
	public Solucao() throws NumberFormatException, IOException{
		this.in = new Inicializa();
		this.tamanhoPop = in.tamanhoPop;
		this.arq = new Arquivo(in.nomearq);
		this.qtItens = arq.getQuantItens();
		this.capMochila = arq.getPesoMaxMochila();
		this.dados = arq.getDados();
		this.solucao = new int[qtItens];
		this.rand = new Random();
	}
	
    public Solucao criaMochilaAleatoria() throws NumberFormatException, IOException{
		Solucao s = new Solucao();
		
		for(int i = 0;i < qtItens; i++){
			if(!rand.nextBoolean())
				s.setSolucao(0,i);
			else
			{
				s.setSolucao(1, i);		//se s nao for aceito desfaz alteracao e sai
				if(!aceitaMochila(s))
				{
					s.setSolucao(0, i);
					break;
				}
			}
		}
		return s;
    }	
    
    public boolean aceitaMochila(Solucao mochila){
        
    	int contador = 0;
        
        for(int i = 0; i < qtItens;i++)
        {
        	if(mochila.getSolucao()[i] == 1)
        		contador = contador + dados.get(i).getTamanhoItem();
        }
        if (contador <= this.capMochila)
        	return true;
        else
            return false;
    }
    public int calculaPeso(Solucao mochila){
    	int peso = 0;
        for(int i = 0; i < qtItens;i++)
        {
        	if(mochila.getSolucao()[i] == 1)
        		peso = peso + dados.get(i).getTamanhoItem();
        }    	
    	return peso;
    }
    //SOMA OS BENEFICIOS
	public int funcaoObjetivo(Solucao so){
		int fo = 0;
		for(int i = 0;i<this.qtItens;i++){
			if(so.getSolucao()[i] == 1){
				fo += this.dados.get(i).getBeneficioItem();
			}
		}
		return fo;
	}

	public int[] getSolucao() {
		return solucao;
	}
	
	public void setSolucao(int elemento, int posicao) {
		this.solucao[posicao] = elemento;
	}	
	
	public String toString(){
		String st="";
		for(int i = 0;i < solucao.length;i++){
			st += solucao[i]+" ";
		}
		return st;
	}
}
