package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;

public class Start{

	public static void main(String[]args) throws NumberFormatException, IOException, CloneNotSupportedException{
		//Start experiment
		
		int numExec = 1;
		
		//String exp2 = "teste1";
		//String exp1 = "KNAPDATA40";
		//String exp2 = "KNAPDATA100";
		//String exp3 = "KNAPDATA10000";
		//String exp4 = "KNAPDATA10000_2";
		//String exp5 = "KNAPDATA11000";
		String exp6 = "KNAPDATA100000"; //erro
		
		/*
		for(int i = 0;i < numExec;i++){
			System.out.printf("Execução [ %d ] Instância [ %s ]\n",i , exp1);
			Controller.ag(exp1);
		}
		*//*
		for(int i = 0;i < numExec;i++){
			System.out.printf("Execução [ %d ] Instância [ %s ]\n",i , exp2);
			Controller.ag(exp2);
		}
		*//*
		for(int i = 0;i < numExec;i++){
			System.out.printf("Execução [ %d ] Instância [ %s ]\n",i , exp3);
			Controller.ag(exp3);
		}
		*//*
		for(int i = 0;i < numExec;i++){
			System.out.printf("Execução [ %d ] Instância [ %s ]\n",i , exp4);
			Controller.ag(exp4);
		}
		/*
		for(int i = 0;i < numExec;i++){
			System.out.printf("Execução [ %d ] Instância [ %s ]\n",i , exp5);
			Controller.ag(exp5);
		}
		*/
		for(int i = 0;i < numExec;i++){
			System.out.printf("Execução [ %d ] Instância [ %s ]\n",i , exp6);
			Controller.ag(exp6);
		}
		
		System.out.printf("\n*** [ FIM ] ***\n");
		
	}
}
