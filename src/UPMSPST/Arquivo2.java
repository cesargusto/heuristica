package UPMSPST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Arquivo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream arquivo = new FileInputStream("arquivo.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			
			BufferedReader br = new BufferedReader(input);
			
			String linha;
			
			do{
				linha = br.readLine();
				if(linha != null){
					String[] palavras = linha.split(";");
					System.out.println("---------------");
					for(int i = 0;i < palavras.length; i++){
						System.out.println("Palavra Lida = "+palavras[i]);
						}
				}
			}while(linha != null);
			
		}catch(Exception e){
			System.out.println("Erro ao ler o arquivo");
		}

	}

}
