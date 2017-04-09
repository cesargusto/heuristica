package com.heuristica.AG.AGMOCHILA;

public class Item {

	private String nomeItem;
	private int tamanhoItem;
	private int beneficioItem;
	
	Item(String nome, int tamanho, int beneficio){
		setNomeItem(nome);
		setTamanhoItem(tamanho);
		setBeneficioItem(beneficio);
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public int getTamanhoItem() {
		return tamanhoItem;
	}

	public void setTamanhoItem(int tamanhoItem) {
		this.tamanhoItem = tamanhoItem;
	}

	public int getBeneficioItem() {
		return beneficioItem;
	}

	public void setBeneficioItem(int beneficioItem) {
		this.beneficioItem = beneficioItem;
	}
	public String toString(){
		return this.getNomeItem()+"\t"+this.getTamanhoItem()+"\t"+this.getBeneficioItem();
	}
}
