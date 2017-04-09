package com.cesar.teste2;

public class Item {

	private String nome;
	private int volume;
	private int beneficio;
	
	public Item(String n, int v, int b){
		setNome(n);
		setVolume(v);
		setBeneficio(b);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}
	public String toString(){
		return this.nome+"\t"+this.volume+"\t"+this.beneficio;
	}
	
}
