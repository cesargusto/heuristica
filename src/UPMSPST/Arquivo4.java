package UPMSPST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Arquivo4 {

	public static void main(String[] args) throws IOException{
		InputStream input = new FileInputStream("arquivo2.txt");
		InputStreamReader rd = new InputStreamReader(input);
		BufferedReader br = new BufferedReader(rd);
		
		String linha = br.readLine();
		while(linha != null){
			System.out.println(linha);
			linha = br.readLine();
			}
		br.close();
	}
}

