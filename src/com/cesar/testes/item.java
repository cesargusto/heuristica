package com.cesar.testes;

public class item {

	private String nomeItem;
	private int tamanho;
	private int beneficio;
	
	public item(String nome, int tamanho, int beneficio){
		this.nomeItem = nome;
		this.tamanho = tamanho;
		this.beneficio = beneficio;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}
	
	public String toString(){
		return "NOME.....: "+this.getNomeItem()+"\nTAMANHO..: "+this.getTamanho()+"\nBENEFICIO: "+this.beneficio;
	}

	public String toString(boolean x){
		return "NOME.....: "+this.getNomeItem()+"\tTAMANHO..: "+this.getTamanho()+"\tBENEFICIO: "+this.beneficio+"\n";
	}	
}
