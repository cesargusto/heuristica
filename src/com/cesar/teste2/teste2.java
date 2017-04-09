package com.cesar.teste2;

import java.util.ArrayList;

public class teste2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st = "x1";
		int vol = 5;
		int ben = 80;
		Item it = new Item(st, vol, ben);
		ArrayList<Item> array = new ArrayList<>();
		array.add(it);
		System.out.println(array.get(0).getBeneficio());

	}

}
