package AG;

public class HelloWordAG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DEFINE SOLUCAO
		Algoritmo.setSolucao("Olá Mundo");
		
		//DEFINE OS CARACTERES EXISTENTES
		String alf = "!,.:;?áÁãÃâÂõÕôÔóÓéêÉÊíQWERTYUIOPASDFGHJKLÇZXCVBNMqwertyuiopasdfghjklçzxcvbnm1234567890 ";
		Algoritmo.setCaracteres(alf);
		
		//TAXA DE CROSSOVER DE 60%
		Algoritmo.setTaxaDeCrossover(0.6);
		
		//TAXA DE MUTAÇÃO DE 3%
		Algoritmo.setTaxaDeMutacao(0.3);
		
		//ELETISMO
		boolean elitismo = true;
		
		//TAMANHO DA POPULALÇÃO
		int tamPop = 100;
		
		//NUMERO MAXIMO DE GERAÇÕES
		int numMaxGeracoes = 10000;
		
		//DEFINE O NUMERO DE GENES DO INDIVIDUO BASEADO NA SOLUCAO
		int numGenes = Algoritmo.getSolucao().length();
		
		//CRIA A PRIMEIRA POPULAÇÃO ALEATORIA
		Populacao populacao = new Populacao(numGenes, tamPop);
		
		boolean temSolucao = false;
		int geracao = 0;
		
		System.out.println("Iniciando ... Aptidão da solução: "+Algoritmo.getSolucao().length());
		
		//LOOP ATE CRITERIO DE PARADA
		while(!temSolucao && geracao < numMaxGeracoes){
			geracao++;
			
			//CRIA NOVA POPULACAO
			populacao = Algoritmo.novaGeracao(populacao, elitismo);
			
			System.out.println("Geração "+geracao+ " | Aptidão: "+populacao.getIndividuo(0).getAptidao() + " | Melhor: "+populacao.getIndividuo(0).getGenes());
			
			//VERIFICA SE TEM SOLUCAO
			temSolucao = populacao.temSolucao(Algoritmo.getSolucao());
		}
		
		if(geracao == numMaxGeracoes){
			System.out.println("Numero máximo de Gerações  |"+populacao.getIndividuo(0).getGenes() +" "+populacao.getIndividuo(0).getAptidao());
		}
		if(temSolucao){
			System.out.println("Encontrado resultado na Geração  "+ geracao +" | "+populacao.getIndividuo(0).getGenes() + "(Aptidão: " +populacao.getIndividuo(0).getAptidao() + ")");
		}

	}

}
