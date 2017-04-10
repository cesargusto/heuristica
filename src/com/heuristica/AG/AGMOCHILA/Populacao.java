package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Populacao {
	
	private int tamanhoPop;
	private Solucao so;
	private ArrayList<Solucao> populacao;
	
	public Populacao(Inicializa in) throws NumberFormatException, IOException{
		this.tamanhoPop = in.tamanhoPop;
		this.so = new Solucao();
		this.populacao = new ArrayList<>();
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
	
	public Solucao cruzamento(Solucao pai1, Solucao pai2, int ponto) throws NumberFormatException, IOException{
		Solucao filho = new Solucao();
		for(int i = 0;i < pai1.getQtItens();i++){
			if(i < ponto)
				filho.setSolucao(pai1.getSolucao(i), i);
			else
				filho.setSolucao(pai2.getSolucao(i), i);
		}
		return filho;
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
}
 