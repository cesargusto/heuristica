package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Solucao implements Cloneable{

	private Inicializa in;
	private ArrayList<Boolean> solucao;
	private int fo;
	private int qtItens;
	private int capMochila;
	private ArrayList<Item> dados;
	private Random rand;
	private Arquivo arq;
	
	public Solucao(Inicializa ini) throws NumberFormatException, IOException{
		this.in = ini;
		this.arq = new Arquivo(in.nomearq);
		this.qtItens = arq.getQuantItens();
		this.capMochila = arq.getPesoMaxMochila();
		this.dados = arq.getDados();
		this.solucao = new ArrayList<>();
		this.rand = new Random();
	}

	public Solucao(Arquivo arquivo) throws IOException{
		this.arq = arquivo;
		this.dados = this.arq.getDados();
		this.qtItens = arq.getQuantItens();
		this.solucao = new ArrayList<>(qtItens);
	}
	
	public Solucao(){
		//this.qtItens = arquivo.getQuantItens();
		this.solucao = new ArrayList<>();
	}
	
	@Override
	public Solucao clone() throws CloneNotSupportedException {
		Solucao solCp = (Solucao) super.clone();
		solCp.dados = new ArrayList<Item>(dados);
		solCp.solucao = new ArrayList<Boolean>(solucao);
		return solCp;
	}
	
    public void cria_mochila_aleatoria() throws NumberFormatException, IOException{
		
		for(int i = 0;i < qtItens; i++)
				this.setSolucaoAdd(false);
		
		int posicao = 0;
		
		if(Util.prob(in.tx_inapto)){
			for(int i = 0;i < qtItens;i++){
				if(!rand.nextBoolean())
					this.setSolucao(false,i);
				else
					this.setSolucao(true, i);		//se s nao for aceito desfaz alteracao e sai
			}
		}
		else{
			for(int i = 0;i < qtItens; i++){
				posicao = rand.nextInt(qtItens);
				this.setSolucao(true, posicao);
				if(!aceitaMochila()){
					this.setSolucao(false, posicao);
					break;
				}
			}
		}
    }
    
    public void criaMochila2Aleatoria() throws NumberFormatException, IOException{
		
		for(int i = 0;i < qtItens; i++){
				this.setSolucao(false,i);
		}
		int posicao = 0;
		for(int i = 0;i < qtItens; i++){
			posicao = rand.nextInt(qtItens);
			this.setSolucao(true, posicao);
			if(!Util.prob(in.tx_inapto)){
				if(!aceitaMochila()){
					this.setSolucao(false, posicao);
					break;
				}
			}

		}
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
    
    public boolean aceitaMochila(){
    	int contador = 0;
        for(int i = 0; i < qtItens;i++)
        {
        	if(solucao.get(i) == true)
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
        	if(solucao.get(i) == true)
        		peso += dados.get(i).getTamanhoItem();
        }    	
    	return peso;
    }
    
    //SOMA OS BENEFICIOS
	public int calculaFo_Ben(){
		int fo = 0;
		for(int i = 0;i<this.qtItens;i++){
			if(solucao.get(i) == true){
				fo += this.dados.get(i).getBeneficioItem();
			}
		}
		return fo;
	}

	//RETORNA O SOMATÓRIO DOS BENEFICIOS DE TODOS OS ELEMENTOS 
	public int alfa_valor(){
		int alfa = 0;
		for(int i =0;i < qtItens;i++){
			alfa += dados.get(i).getBeneficioItem();
		}
		return alfa;
	}
	
	//CALCULA FUNÇÃO OBJETIVO COM PENALIZAÇÃO
	public int calculaFo(){
		
		int w = 0;
		int p = 0;
		int fo = 0;
		int intervalo = 0;
		int b = this.capMochila;
		int alfa = this.alfa_valor();
		
		for(int i = 0;i<this.solucao.size();i++){
			boolean valor = this.getSolucao(i);
			if(valor){
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
	
	public boolean avalia(Thebest tb, Populacao po){
		
		if(this.aceitaMochila()){
			
			long fo = this.calculaFo();
			
			if(fo > po.getMelhor_so_pop().calculaFo())
				po.setMelhor_so_pop(this);
			if(fo > tb.getMelhor_so_global().calculaFo()){
				tb.setMelhor_so_global(this);
			}
			return true;
		}else
			return false;
	}

	public void geraVizinhoSA(int pos){
		if(this.solucao.get(pos) == false)
			this.solucao.set(pos, true);
		else
			this.solucao.set(pos, false);
	}
	
	public int getFo() {
		return fo;
	}

	public void setFo(int fo) {
		this.fo = fo;
	}
	
	public void mutacao(int posicao){
		if(this.getSolucao(posicao) == true)
			this.setSolucao(false, posicao);
		else
			this.setSolucao(true, posicao);
	}

	public void cruzamento(Solucao pai1, Solucao pai2, int ponto) throws NumberFormatException, IOException{
		ArrayList<Boolean> sub1 = new ArrayList<>(pai1.getSolucao().subList(0, ponto));
		ArrayList<Boolean> sub2 = new ArrayList<>(pai2.getSolucao().subList(ponto, pai2.qtItens));
		this.solucao.addAll(sub1);
		this.solucao.addAll(sub2); 
	}	
	
	public boolean getSolucao(int posicao) {
		return this.solucao.get(posicao).booleanValue();
	}
	
	public void setSolucao(boolean elemento, int posicao) {
		this.solucao.set(posicao, elemento);
	}
	
	public void setSolucaoAdd(boolean elemento) {
		this.solucao.add(elemento);
	}
	
	public void subSolucao(boolean elemento, int pos){
		this.solucao.set(pos, elemento);
	}
	
	public void setSolucao(boolean elemento) {
		this.solucao.add(elemento);
	}
	
	public ArrayList<Boolean> getSolucao() {
		return solucao;
	}
	
	public void setSolucao(boolean[] solution) {
		for(int i = 0;i < solution.length;i++)
			this.solucao.add(i, solution[i]);
	}
	
	public int getQtItens() {
		return qtItens;
	}

	public String toString(){
		String st="";
		for(int i = 0;i < solucao.size();i++){
			st += solucao.get(i)+" ";
		}
		return st;
	}
	
	public void exibeSolucao(Thebest tb){
	   	String nome = "";
		int tamanho = 0, beneficio = 0;
		for(int i = 0;i < qtItens;i++){
			if(tb.getMelhor_so_global().getSolucao().get(i) == true){
				nome = dados.get(i).getNomeItem();
				tamanho = dados.get(i).getTamanhoItem();
				beneficio = dados.get(i).getBeneficioItem();
				
				System.out.printf("%s\t%d\t%d\n",nome, tamanho, beneficio);
			}
		}
	}
	public void exibeSolucaoSA(Thebest tb){
	   	String nome = "";
		int tamanho = 0, beneficio = 0;
		for(int i = 0;i < qtItens;i++){
			if(tb.getMelhor_so_sa_global().getSolucao(i) == true){
				nome = dados.get(i).getNomeItem();
				tamanho = dados.get(i).getTamanhoItem();
				beneficio = dados.get(i).getBeneficioItem();
				
				System.out.printf("%s\t%d\t%d\n",nome, tamanho, beneficio);
			}
		}
	}
}
