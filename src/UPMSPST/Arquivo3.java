package UPMSPST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arquivo3 {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo2.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();

		int tamanho = Integer.parseInt(linha);//tranforma o strig linha em inteiro
		
		linha = br.readLine();
		StringTokenizer st = new StringTokenizer(linha, " ");
		int[]valor = new int[tamanho];
		int i = 0;
		while(st.hasMoreElements()){
			valor[i] = Integer.parseInt((String) st.nextElement());
			//System.out.println(valor[i] * 3);
			i++;
		}
		for(int j = 0; j<valor.length;j++){
			System.out.printf("%d ",valor[j]);
		}		
		br.close();
	}

}
