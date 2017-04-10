package com.cesar.testes.oi;

import java.util.ArrayList;
import java.util.Random;

public class Testepacote{
	
	public static void main(String[]args){
		
		ArrayList<Integer>array = new ArrayList<>();
		array.add(8);
		array.add(10);
		array.add(27);
		array.add(34);
		array.add(36);
		array.add(48);
		array.add(59);
		array.add(66);
		array.add(69);
		array.add(76);		
		
		System.out.println(array);
		
		
		Random r = new Random();
		int t = r.nextInt(array.get(array.size()-1));
		System.out.println("valor aleatorio: "+t);
		
		for(int i = 0;i<array.size();i++){
			if(t >= 0 && t <=array.get(i)){
				System.out.println(i);
				break;
			}
			else if( t > array.get(i) && t <=array.get(i+1)){
				System.out.println(i+1);
				break;				
			}
		}
		
	}

}
