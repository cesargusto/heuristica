package com.cesar.testes;

import java.util.Random;

public class solucao {

	private int[] sol;
	private int tamanho;
	
	public solucao(int[]s){
		this.sol = s;
	}
	public solucao(int t){
		this.tamanho = t;
	}
	
	public void setSolucao(int[] solucao){
		this.sol = solucao;
	}
	public int[] getSolucao(){
		return sol;
	}
	
	public int[] criaMochilaAleatoria()
	{
		int[]m = new int[tamanho];
		Random r = new Random();
		
		for(int i = 0;i < tamanho; i++)
		{
			if(r.nextBoolean())
				m[i] = 1;
			else
				m[i] = 0;
		}
		return m;
	}
	public String toString(){
		String st = "[";
		for(int i = 0;i < sol.length;i++){
			st = st +" "+sol[i];
		}
		return st;
	}
}
