package com.heuristica.SA.SAMOCHILA;

import java.io.IOException;

public class StartSA {

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {

		int numExec = 1;
				
		//String exp1 = "teste1";
		String exp1 = "KNAPDATA40";
		String exp2 = "KNAPDATA100";
		String exp3 = "KNAPDATA10000";
		String exp4 = "KNAPDATA10000_2";
		String exp5 = "KNAPDATA11000";
		String exp6 = "KNAPDATA100000"; //erro
		
		for(int i = 0;i < numExec;i++){
			System.out.printf("\nExecução [ %d ] Instância [ %s ]\n",i , exp1);
			ControllerSA cont = new ControllerSA(exp1);
			cont.sanneling();
		}
		
		for(int i = 0;i < numExec;i++){
			System.out.printf("\nExecução [ %d ] Instância [ %s ]\n",i , exp2);
			ControllerSA cont = new ControllerSA(exp2);
			cont.sanneling();
		}
		
		for(int i = 0;i < numExec;i++){
			System.out.printf("\nExecução [ %d ] Instância [ %s ]\n",i , exp3);
			ControllerSA cont = new ControllerSA(exp3);
			cont.sanneling();
		}
		
		for(int i = 0;i < numExec;i++){
			System.out.printf("\nExecução [ %d ] Instância [ %s ]\n",i , exp4);
			ControllerSA cont = new ControllerSA(exp4);
			cont.sanneling();
		}
		
		for(int i = 0;i < numExec;i++){
			System.out.printf("\nExecução [ %d ] Instância [ %s ]\n",i , exp5);
			ControllerSA cont = new ControllerSA(exp5);
			cont.sanneling();
		}
		
		for(int i = 0;i < numExec;i++){
			System.out.printf("\nExecução [ %d ] Instância [ %s ]\n",i , exp6);
			ControllerSA cont = new ControllerSA(exp6);
			cont.sanneling();
		}
		
		System.out.printf("\n*** [ FIM ] ***\n");
	}

}
