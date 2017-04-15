package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;

public class Playteste {

	public static void main(String[]args) throws NumberFormatException, IOException{
		
		Thebest t = new Thebest();
		Inicializa i = new Inicializa();
		Populacao po = new Populacao(i);
		Populacao n_po = new Populacao(i);
		
		po.geraPopAleat();
		
		System.out.println("PO\n");
		Show.show(po);
		
		while(n_po.getPopulacao().size() < i.tamanhoPop){
			
			Solucao p1 = new Solucao();
			Solucao p2 = new Solucao();
			
			Solucao f1 = new Solucao();
			Solucao f2 = new Solucao();
			
			int ip1 = po.Roleta();
			int ip2 = po.Roleta();
			
			p1 = po.getPopulacao().get(ip1);
			p2 = po.getPopulacao().get(ip2);
			
			int ponto = p1.getQtItens()/2;
			
			f1.cruzamento(p1, p2, ponto);
			f2.cruzamento(p2, p1, ponto);
			
			if(f1.avalia(t,po))
				n_po.setPopulacao(f1);
			if(f2.avalia(t, po))
				n_po.setPopulacao(f2);
		}//while
		
		System.out.println("N_PO gerado por cruzamento\n");
		Show.show(n_po);
		
		po = n_po;
		System.out.println("PO");		
		Show.show(po);		
		
		n_po = new Populacao(i);
		n_po.geraPopAleat();
		Show.show(n_po);
			
	}
}
