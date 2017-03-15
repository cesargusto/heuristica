package AG;

import java.util.Random;

public class Individuo {

	private String genes = "";
	private int aptidao = 0;
	
	//gera individuos aleatórios
	public Individuo(int numGenes){
		
		genes = "";
		Random r = new Random();
		
		String caracteres = Algoritmo.getCaracteres();
		
		for(int i = 0;i < numGenes; i++){
			genes += caracteres.charAt(r.nextInt(caracteres.length()));
		}
		
		geraAptidao();
	}
	//gera individuos predefinidos
	public Individuo(String genes){
		this.genes = genes;
		
		Random r = new Random();
		//Se for mutar cria um gene aleatorio
		if(r.nextDouble() <= Algoritmo.getTaxaDeMutacao()){
			String caracteres = Algoritmo.getCaracteres();
			String geneNovo="";
			int posAleatoria = r.nextInt(genes.length());
			for (int i = 0;i < genes.length(); i ++){
				if(i==posAleatoria){
					geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
				}else{
					geneNovo += genes.charAt(i);
				}
			}
			this.genes = geneNovo;
		}
		geraAptidao();
	}
	//gera o valor de aptidao, sera calculada pelo numero de bits do gene iguais ao da solucao
	private void geraAptidao(){
		String solucao = Algoritmo.getSolucao();
		for (int i = 0;i < solucao.length(); i++){
			if(solucao.charAt(i) == genes.charAt(i)){
				aptidao++;
			}
		}
	}
	public int getAptidao(){
		return aptidao;
	}
	
	public String getGenes(){
		return genes;
	}
}
