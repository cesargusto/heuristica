package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Populacao implements Cloneable{
	
	private int tamanhoPop;
	private Solucao so;
	private Solucao melhor_so_pop;
	private ArrayList<Solucao> populacao;
	private ArrayList<Solucao> filhos;
	
	public Populacao(Inicializa in) throws NumberFormatException, IOException{
		this.tamanhoPop = in.tamanhoPop;
		this.so = new Solucao();
		this.melhor_so_pop = new Solucao();
		this.populacao = new ArrayList<>();
		this.filhos = new ArrayList<>();
	}
	
	public void geraPopAleat() throws NumberFormatException, IOException{
		
		for(int i = 0;i < this.tamanhoPop;i++){
			Solucao so = new Solucao();
			so.criaMochilaAleatoria();
			populacao.add(so);
		}
	}

	public int Roleta(){
		
		ArrayList<Integer> aptidoes = new ArrayList<>();
		
		Integer soma = 0;
		
		for(int i = 0;i < tamanhoPop;i++){
			soma += populacao.get(i).calculaFo();
			aptidoes.add(soma);
		}
		Random r = new Random();
		int rand = r.nextInt(aptidoes.get(aptidoes.size()-1));
		int posicao = 0;
		
		for(int i = 0;i<aptidoes.size();i++){
			if(rand >= 0 && rand <=aptidoes.get(i)){
				posicao = i;
				break;
			}
			else if( rand > aptidoes.get(i) && rand <=aptidoes.get(i+1)){
				posicao = i+1;
				break;				
			}
		}
		return posicao;
	}

	public Solucao getMelhor_so_pop() {
		return melhor_so_pop;
	}

	public void setMelhor_so_pop(Solucao melhor_so_pop) {
		this.melhor_so_pop = melhor_so_pop;
	}

	public int getTamanhoPop() {
		return tamanhoPop;
	}
	
	public ArrayList<Solucao> getPopulacao() {
		return populacao;
	}
	
	public void setPopulacao(Solucao solucao) {
		this.populacao.add(solucao);
	}
	
	public void setPopulacao(ArrayList<Solucao> populacao) {
		this.populacao = populacao;
	}

	public ArrayList<Solucao> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Solucao> filhos) {
		this.filhos = filhos;
	}
	@Override
	public Populacao clone() throws CloneNotSupportedException{
		return (Populacao) super.clone();
	}
}
 