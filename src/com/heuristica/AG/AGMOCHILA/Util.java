package com.heuristica.AG.AGMOCHILA;

import java.util.Random;

public class Util {

	public static boolean prob(double prob){
		Random rand = new Random();
		Double v = rand.nextDouble();
		return(v <= prob);
	}
	
	/*public static void main(String[]args){
		System.out.println(probabil(0.6));
	}*/
}
