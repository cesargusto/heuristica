package com.heuristica.SA.SAMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.heuristica.AG.AGMOCHILA.Arquivo;
import com.heuristica.AG.AGMOCHILA.Item;
import com.heuristica.AG.AGMOCHILA.Thebest;

public class SolucaoSA implements Cloneable{

	private Arquivo arquivo;
	private ArrayList<Item> dados;
	private ArrayList<Boolean> solucao;
	private int qtItens;
	
	public SolucaoSA(Arquivo arquivo) throws IOException{
		this.arquivo = arquivo;
		this.dados = this.arquivo.getDados();
		this.qtItens = arquivo.getQuantItens();
		this.solucao = new ArrayList<>(qtItens);
	}
	
	public SolucaoSA(){
		//this.qtItens = arquivo.getQuantItens();
		this.solucao = new ArrayList<>();
	}
	
	@Override
	public SolucaoSA clone() throws CloneNotSupportedException {
		SolucaoSA solSACp = (SolucaoSA) super.clone();
		solSACp.dados = new ArrayList<Item>(dados);
		solSACp.solucao = new ArrayList<Boolean>(solucao);
		return solSACp;
	}
	
    public void cria_mochila_apta() throws NumberFormatException, IOException{
		
    	Random rand = new Random();
    	for(int i = 0;i < this.qtItens;i++){
    		this.solucao.add(Boolean.FALSE);
    	}
		
		for(int i = 0;i < this.qtItens; i++){
			if(!rand.nextBoolean())
				this.setSolucao(false);
			else
			{
				this.setSolucao(true);		//when not accept remove the last element and break for
				if(!aceitaMochila())
				{
					this.subSolucao(false, i);
					break;
				}
			}
		}
    }	

    public boolean aceitaMochila() throws IOException{
    	int contador = 0;
        for(int i = 0; i < this.qtItens;i++)
        {
        	if(this.solucao.get(i) == true)
        		contador += this.dados.get(i).getTamanhoItem();
        	
        }
        if (contador <= arquivo.getPesoMaxMochila())
        	return true;
        else
            return false;
    }
    
	public void geraVizinhoSA(int pos){
		if(this.solucao.get(pos) == false)
			this.solucao.set(pos, true);
		else
			this.solucao.set(pos, false);
	}
    
	//RETORNA O SOMATÓRIO DOS BENEFICIOS DE TODOS OS ELEMENTOS 
	public int alfa_valor(){
		int alfa = 0;
		for(int i =0;i < qtItens;i++){
			alfa += dados.get(i).getBeneficioItem();
		}
		return alfa;
	}
	
	public int calculaFo(){
		
		int w = 0;
		int p = 0;
		int fo = 0;
		int intervalo = 0;
		int b = arquivo.getPesoMaxMochila();
		int alfa = this.alfa_valor();
		
		for(int i = 0;i<this.qtItens;i++){
			if(solucao.get(i) == true){
				w += this.dados.get(i).getTamanhoItem();
				p += this.dados.get(i).getBeneficioItem();
			}
		}
		
		intervalo = w - b;
		if(intervalo < 0)
			fo = p;
		else
			fo = p - alfa * intervalo;
		return fo;
	}
    
	//SOMA PESOS
    public int calculaPeso(){
    	int peso = 0;
        for(int i = 0; i < qtItens;i++)
        {
        	if(solucao.get(i) == true)
        		peso += dados.get(i).getTamanhoItem();
        }    	
    	return peso;
    }
    
	
	public ArrayList<Boolean> getSolucao() {
		return solucao;
	}

	public void setSolucao(boolean elemento) {
		this.solucao.add(elemento);
	}
	public void subSolucao(boolean elemento, int pos){
		this.solucao.set(pos, elemento);
	}
	
	public int getQtItens() {
		return qtItens;
	}
	
	public void exibeSolucao(Thebest tb){
	   	String nome = "";
		int tamanho = 0, beneficio = 0;
		for(int i = 0;i < qtItens;i++){
			if(tb.getMelhor_so_sa_global().getSolucao().get(i) == true){
				nome = dados.get(i).getNomeItem();
				tamanho = dados.get(i).getTamanhoItem();
				beneficio = dados.get(i).getBeneficioItem();
				
				System.out.printf("%s\t%d\t%d\n",nome, tamanho, beneficio);
			}
		}
	}
}
