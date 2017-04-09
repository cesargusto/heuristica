package com.heuristica.AG.AGMOCHILA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Arquivo {
	
	private String caminhoArq;
	private FileInputStream  is;
	private InputStreamReader isr;
	private BufferedReader br;
	private int pesoMaxMochila;
	private int quantItens;
	
	Arquivo(String nomeArq) throws NumberFormatException, IOException
	{
		this.caminhoArq = "files/mochila/"+nomeArq+".txt";
		this.is = new FileInputStream(this.caminhoArq);
		this.isr = new InputStreamReader(this.is);
		this.br = new BufferedReader(this.isr);
		this.pesoMaxMochila = Integer.parseInt(br.readLine());
		this.quantItens = Integer.parseInt(br.readLine());
	}
	
	public ArrayList<Item> getDados() throws IOException{
		
		String nome, linha;
		int tamanho, beneficio;	
		
		ArrayList<Item> ArrayDados = new ArrayList<>();
		StringTokenizer tk;
		
		for(int i = 0;i<this.quantItens;i++)
		{
			linha = br.readLine();
			tk = new StringTokenizer(linha, ",");
			nome = tk.nextToken();
			tamanho = Integer.parseInt(tk.nextToken());
			beneficio = Integer.parseInt(tk.nextToken());
			ArrayDados.add(new Item(nome, tamanho, beneficio));
		}
		
		br.close();
		return ArrayDados;
	}

	public int getPesoMaxMochila() {
		return pesoMaxMochila;
	}
	public int getQuantItens() {
		return quantItens;
	}
	public void exibeDados(ArrayList<Item> array){
    	System.out.println("NOME\tTAMANHO\tBENEFICIO");
    	for(int i = 0;i < array.size();i++)
    		System.out.println(array.get(i).toString());
	}
}
