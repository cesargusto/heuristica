package com.heuristica.AG.AGMOCHILA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Arq {

	public void grava(String path, String nomearq, ArrayList<Integer> array){
		File arquivo = new File(path+""+nomearq+".txt");
		try{
			if(!arquivo.exists()){
				arquivo.createNewFile();
			}
			
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0;i < array.size();i++){
				bw.write(array.get(i).toString());
				bw.write(",");
			}
			
			bw.newLine();
			
			bw.close();
			fw.close();
			
			}catch(Exception e){
				System.out.println("Erro ao escrever no arquivo");
			}
		}
	
}
