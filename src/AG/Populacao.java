package AG;

public class Populacao {

	private Individuo[] individuos;
	private int tamPopulacao;
	
	//cria uma população com individuos aleatórios
	
	public Populacao(int numGenes, int tamPop){
		tamPopulacao = tamPop;
		individuos = new Individuo[tamPop];
		for(int i = 0;i< individuos.length; i++){
			individuos[i] = new Individuo(numGenes);
		}
	}
	public Populacao(int tamPop){
		tamPopulacao = tamPop;
		individuos = new Individuo[tamPop];
		for(int i = 0;i < individuos.length; i++){
			individuos[i] = null;
		}
	}
	
	public void setIndividuo(Individuo individuo, int posicao){
		individuos[posicao] = individuo;
	}
	
	public void setIndividuo(Individuo individuo){
		for(int i = 0;i < individuos.length; i ++){
			if(individuos[i] == null){
				individuos[i] = individuo;
				return;
			}
		}
	}
	//verifica se algum individuo da populacao possui a solucao
	public boolean temSolucao(String solucao){
		Individuo i = null;
		
		for(int j = 0; j < individuos.length; j++){
			if(individuos[j].getGenes().equals(solucao)){
				i = individuos[j];
				break;
			}
		}
		if(i == null){
			return false;
		}
		return true;
	}
	//ordena a populacao pelo valor de aptidao de cada individuo. O melhor individuo
	//estará no inicio
	public void ordenaPopulacao(){
		boolean trocou = true;
		while(trocou){
			trocou = false;
			for(int i = 0;i< individuos.length -1; i++){
				if(individuos[i].getAptidao() < individuos[i + 1].getAptidao()){
					Individuo temp = individuos[i];
					individuos[i] = individuos[i + 1];
					individuos[i + 1] = temp;
					trocou = true;
				}
			}
		}
	}	
	//numero de individuos existentes na populacao
	public int getNumIndividuos(){
		int num = 0;
		for(int i = 0; i < individuos.length; i++){
			if (individuos[i] != null){
				num++;
			}
		}
		return num;
	}
	
	public int getTamPopulacao(){
		return tamPopulacao;
	}
	public Individuo getIndividuo(int pos){
		return individuos[pos];
	}
}
